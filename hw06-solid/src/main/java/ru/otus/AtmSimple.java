package ru.otus;

import ru.otus.exception.UnableToWithdrawException;
import ru.otus.model.Banknote;
import ru.otus.model.Cell;
import ru.otus.model.Denomination;
import ru.otus.model.MoneyStorage;

import java.util.ArrayList;
import java.util.List;

public class AtmSimple implements Atm {
    private final MoneyStorage moneyStorage;

    public AtmSimple(MoneyStorage moneyStorage) {
        this.moneyStorage = moneyStorage;
    }

    /**
     * Добаляет все купюры в ячейки
     */
    public void depositMoney(List<Banknote> money) {
        for (Banknote banknote : money) {
            Cell cell = moneyStorage.getCell(banknote.denomination());
            cell.putMoney(banknote);
        }
    }

    /**
     * Возвращает список купюр к выдаче.
     * Если запрошена неккоректная сумма или недостаточно купюр, то исключение
     */
    public List<Banknote> withdrawMoney(int value) throws UnableToWithdrawException {
        List<Banknote> result = withdrawalCheck(value);
        if (result == null || result.isEmpty()) {
            throw new UnableToWithdrawException("Unable to withdraw money");
        } else {
            for (Banknote banknote : result) {
                Cell cell = moneyStorage.getCell(banknote.denomination());
                cell.pickUpMoney();
            }
        }
        return result;
    }

    /**
     * Вспомогательный метод для получения списка купюр к выдаче
     */
    private List<Banknote> withdrawalCheck(int value) {
        List<Banknote> result = new ArrayList<>();
        if (value > 0) {
            for (Denomination denomination : Denomination.values()) {
                while (value - denomination.getValue() >= 0) {
                    value -= denomination.getValue();
                    result.add(new Banknote(denomination));
                }

            }
        }
        return value > 0 ? null : result;
    }

    /**
     * Возвращает сумму остатка денежых средств
     */
    public int getBalance() {
        int result = 0;
        for (Denomination value : Denomination.values()) {
            result += value.getValue() * moneyStorage.getCell(value).getQuantity();
        }
        return result;
    }
}
