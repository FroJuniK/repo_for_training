package ru.otus.demo.behavioralPatterns.visitor;

public interface Element {
    void accept(Visitor v);
}
