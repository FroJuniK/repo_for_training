package ru.otus.demo.structuralPatterns.decorator;

public final class DataSourceImpl implements DataSource {
    @Override
    public int getInteger() {
        return 15;
    }
}
