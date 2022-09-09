package ru.otus.model;

import java.util.HashMap;
import java.util.Map;

public class MoneyStorage {
    private final Map<Denomination, Cell> cells = new HashMap<>();

    public void putCell(Denomination denomination, Cell cell) {
        cells.put(denomination, cell);
    }

    public Cell getCell(Denomination denomination) {
        return cells.get(denomination);
    }
}
