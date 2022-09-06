package ru.otus.homework;

import java.util.PriorityQueue;
import java.util.Queue;

public class Cell {
    private final Queue<Integer> banknotes = new PriorityQueue<>();

    public boolean putMoney(int banknote) {
        return banknotes.add(banknote);
    }

    public Integer getMoney() {
        return banknotes.poll();
    }

    public int getQuantity() {
        return banknotes.size();
    }
}
