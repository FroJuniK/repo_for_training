package ru.otus.demo.behavioralPatterns.strategy;

public class Taxi implements Strategy {
    @Override
    public void transportation() {
        System.out.println("доехать на такси");
    }
}
