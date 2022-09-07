package ru.otus.demo.structuralPatterns.bridge;

public class VisaPS implements PaymentSystem {
    @Override
    public void printName() {
        System.out.println("VisaPS");
    }
}
