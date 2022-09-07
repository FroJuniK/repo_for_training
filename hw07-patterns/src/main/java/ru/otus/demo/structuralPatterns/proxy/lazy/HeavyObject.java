package ru.otus.demo.structuralPatterns.proxy.lazy;

public interface HeavyObject {

    void init(String value);

    boolean isInit();

    String getValue();
}
