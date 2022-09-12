package ru.otus.model;

import ru.otus.exception.UnableToWithdrawException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Cell {
    private final Stack<Banknote> banknotes = new Stack<>();

    public void putMoney(Banknote banknote) {
        banknotes.push(banknote);
    }

    public void pickUpMoney() throws UnableToWithdrawException {
        try {
            banknotes.pop();
        } catch (EmptyStackException ex) {
            throw new UnableToWithdrawException("Not enough banknotes");
        }
    }

    public int getQuantity() {
        return banknotes.size();
    }
}
