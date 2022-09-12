package ru.otus;

import ru.otus.exception.UnableToWithdrawException;
import ru.otus.model.Banknote;
import ru.otus.model.Denomination;
import ru.otus.model.MoneyStorage;

import java.util.List;

public class AtmSimple implements Atm {
    private final MoneyStorage moneyStorage;

    public AtmSimple(MoneyStorage moneyStorage) {
        this.moneyStorage = moneyStorage;
    }

    public void depositMoney(List<Banknote> money) throws UnableToWithdrawException {
        moneyStorage.depositMoney(money);
    }

    public List<Banknote> withdrawMoney(int value) throws UnableToWithdrawException {
        return moneyStorage.withdrawMoney(value);
    }

    /**
     * Возвращает сумму остатка денежых средств
     */
    public int getBalance() throws UnableToWithdrawException {
        int result = 0;
        for (Denomination value : Denomination.values()) {
            result += value.getValue() * moneyStorage.getCell(value).getQuantity();
        }
        return result;
    }
}
