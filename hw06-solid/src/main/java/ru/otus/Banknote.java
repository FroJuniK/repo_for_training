package ru.otus;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Banknote {
    private static final Set<Integer> banknoteDenomination = ImmutableSet.of(5000, 2000, 1000, 500, 200, 100);

    public static Set<Integer> getBanknoteDenomination() {
        return banknoteDenomination;
    }
}
