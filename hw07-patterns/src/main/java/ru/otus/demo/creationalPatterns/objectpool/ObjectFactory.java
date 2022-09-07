package ru.otus.demo.creationalPatterns.objectpool;

public interface ObjectFactory<T> {
    T create();
}
