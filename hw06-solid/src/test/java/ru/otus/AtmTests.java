package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.exception.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AtmTests {
    private Atm atm;

    @BeforeEach
    void setUp() {
        atm = new Atm();
        atm.createAtm();
    }

    @Test
    void putMoney() throws BanknoteIsNotRecognizedException {
        List<Integer> money = Arrays.asList(100, 100, 1000);

        atm.depositMoney(money);

        int expected = money.stream().reduce(0, Integer::sum);
        int fact = atm.getBalance();

        assertEquals(fact, expected);
    }

    @Test
    void requestMoney() throws BanknoteIsNotRecognizedException, UnableToWithdrawException {
        List<Integer> money = Arrays.asList(100, 100, 100, 200, 200, 500, 1000, 2000, 5000);
        atm.depositMoney(money);

        List<Integer> expected = Arrays.asList(100, 200, 1000);
        List<Integer> fact = atm.withdrawMoney(1300);

        assertTrue(fact.containsAll(expected));
    }

    @Test
    void putMoneyWithAnError() {
        List<Integer> money = Arrays.asList(10, 100, 1000);

        assertThrows(BanknoteIsNotRecognizedException.class, () -> atm.depositMoney(money));
    }

    @Test
    void requestMoneyWithAnError() throws BanknoteIsNotRecognizedException {
        List<Integer> money = Arrays.asList(500, 1000, 2000, 5000);
        atm.depositMoney(money);

        assertThrows(UnableToWithdrawException.class, () -> atm.withdrawMoney(1050));
    }
}