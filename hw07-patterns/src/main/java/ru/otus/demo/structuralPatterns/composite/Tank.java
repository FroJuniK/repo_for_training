package ru.otus.demo.structuralPatterns.composite;

public class Tank implements Unit {
    @Override
    public void move() {
        System.out.println("Tank is moving");
    }
}
