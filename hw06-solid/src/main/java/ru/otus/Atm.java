package ru.otus;

import ru.otus.exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Atm {
    private final Map<Integer, Cell> cells = new HashMap<>();

    public void createAtm() {
        for (int denomination : Banknote.getBanknoteDenomination()) {
            cells.put(denomination, new Cell());
        }
    }

    /**
     * Добаляет все распознанные купюры в ячейки, нераспознанные вызывают исключение
     */
    public void depositMoney(List<Integer> money) throws BanknoteIsNotRecognizedException {
        Set<Integer> unrecognizedBanknotes = new HashSet<>();

        for (int banknote : money) {
            Cell cell = cells.get(banknote);
            if (cell != null) {
                cell.putMoney(banknote);
            } else {
                unrecognizedBanknotes.add(banknote);
            }
        }

        if (!unrecognizedBanknotes.isEmpty()) {
            throw new BanknoteIsNotRecognizedException(Arrays.toString(unrecognizedBanknotes.toArray()) + "banknotes not recognized");
        }
    }

    /**
     * Возвращает список купюр к выдаче.
     * Если запрошена неккоректная сумма или недостаточно купюр, то исключение
     */
    public List<Integer> withdrawMoney(int value) throws UnableToWithdrawException {
        List<Integer> result = withdrawalCheck(value);
        if (result == null || result.isEmpty()) {
            throw new UnableToWithdrawException("Unable to withdraw money");
        } else {
            for (int banknote : result) {
                Integer head = cells.get(banknote).getMoney();
                if (head == null) {
                    throw new UnableToWithdrawException("Not enough banknotes");
                }
            }
        }
        return result;
    }

    /**
     * Вспомогательный метод для получения списка купюр к выдаче, если существуют их номиналы
     */
    private List<Integer> withdrawalCheck(int value) {
        List<Integer> result = new ArrayList<>();
        if (value > 0) {
            for (int denomination : Banknote.getBanknoteDenomination()) {
                while (value - denomination >= 0) {
                    value -= denomination;
                    result.add(denomination);
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
        for (Map.Entry<Integer, Cell> entry : cells.entrySet()) {
            result += entry.getKey() * entry.getValue().getQuantity();
        }
        return result;
    }
}
