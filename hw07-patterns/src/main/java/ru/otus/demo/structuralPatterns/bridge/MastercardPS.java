package ru.otus.demo.structuralPatterns.bridge;

public class MastercardPS implements PaymentSystem {
    @Override
    public void printName() {
        System.out.println("MastercardPS");
    }
}
