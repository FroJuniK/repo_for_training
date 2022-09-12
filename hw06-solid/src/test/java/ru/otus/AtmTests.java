package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.exception.UnableToWithdrawException;
import ru.otus.model.Banknote;
import ru.otus.model.Cell;
import ru.otus.model.Denomination;
import ru.otus.model.MoneyStorage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AtmTests {
    private AtmSimple atm;

    @BeforeEach
    void setUp() {
        MoneyStorage moneyStorage = new MoneyStorage();
        for (Denomination denomination : Denomination.values()) {
            moneyStorage.putCell(denomination, new Cell());
        }
        atm = new AtmSimple(moneyStorage);
    }

    @Test
    void putMoney() throws UnableToWithdrawException {
        List<Banknote> money = Arrays.asList(
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.ONE_THOUSAND));

        atm.depositMoney(money);

        int expected = money.stream().map((i) -> i.denomination().getValue()).reduce(0, Integer::sum);
        int fact = atm.getBalance();

        assertEquals(fact, expected);
    }

    @Test
    void requestMoney() throws UnableToWithdrawException {
        List<Banknote> money = Arrays.asList(
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.TWO_HUNDREDS),
                new Banknote(Denomination.TWO_HUNDREDS),
                new Banknote(Denomination.FIVE_HUNDREDS),
                new Banknote(Denomination.ONE_THOUSAND),
                new Banknote(Denomination.TWO_THOUSANDS),
                new Banknote(Denomination.FIVE_THOUSANDS));
        atm.depositMoney(money);

        List<Banknote> expected = Arrays.asList(
                new Banknote(Denomination.ONE_HUNDRED),
                new Banknote(Denomination.TWO_HUNDREDS),
                new Banknote(Denomination.ONE_THOUSAND));
        List<Banknote> fact = atm.withdrawMoney(1300);

        assertTrue(fact.containsAll(expected));
    }

    @Test
    void requestMoneyWithAnError() throws UnableToWithdrawException {
        List<Banknote> money = Arrays.asList(
                new Banknote(Denomination.FIVE_HUNDREDS),
                new Banknote(Denomination.ONE_THOUSAND),
                new Banknote(Denomination.TWO_THOUSANDS),
                new Banknote(Denomination.FIVE_THOUSANDS));
        atm.depositMoney(money);

        assertThrows(UnableToWithdrawException.class, () -> atm.withdrawMoney(1050));
    }

    @Test
    void requestMoneyWhenCellsAreEmpty() {
        assertThrows(UnableToWithdrawException.class, () -> atm.withdrawMoney(2000));
    }

    @Test
    void putMoneyWhenNoCell() {
        MoneyStorage moneyStorage = new MoneyStorage();
        moneyStorage.putCell(Denomination.FIVE_HUNDREDS, new Cell());
        atm = new AtmSimple(moneyStorage);

        assertThrows(UnableToWithdrawException.class,
                () -> atm.depositMoney(Arrays.asList(new Banknote(Denomination.ONE_HUNDRED))));
    }
}