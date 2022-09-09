package ru.otus;

import ru.otus.exception.UnableToWithdrawException;
import ru.otus.model.Banknote;

import java.util.List;

public interface Atm {

    void depositMoney(List<Banknote> money);

    List<Banknote> withdrawMoney(int value) throws UnableToWithdrawException;

    int getBalance();
}
