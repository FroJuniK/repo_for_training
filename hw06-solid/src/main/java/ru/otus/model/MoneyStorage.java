package ru.otus.model;

import ru.otus.exception.UnableToWithdrawException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyStorage {
    private final Map<Denomination, Cell> cells = new HashMap<>();

    public void putCell(Denomination denomination, Cell cell) {
        cells.put(denomination, cell);
    }

    public Cell getCell(Denomination denomination) throws UnableToWithdrawException {
        Cell cell = cells.get(denomination);
        if (cell == null) {
            throw new UnableToWithdrawException("No cell with denomination " + denomination.getValue());
        }
        return cell;
    }

    /**
     * Добаляет все купюры в ячейки
     */
    public void depositMoney(List<Banknote> money) throws UnableToWithdrawException {
        for (Banknote banknote : money) {
            Cell cell = getCell(banknote.denomination());
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
                Cell cell = getCell(banknote.denomination());
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
}
