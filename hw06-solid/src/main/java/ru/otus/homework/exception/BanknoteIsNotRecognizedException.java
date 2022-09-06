package ru.otus.homework.exception;

public class BanknoteIsNotRecognizedException extends Exception {
    public BanknoteIsNotRecognizedException() {
    }

    public BanknoteIsNotRecognizedException(String message) {
        super(message);
    }
}
