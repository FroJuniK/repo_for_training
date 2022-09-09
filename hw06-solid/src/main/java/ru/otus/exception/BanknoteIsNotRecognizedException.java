package ru.otus.exception;

public class BanknoteIsNotRecognizedException extends Exception {
    public BanknoteIsNotRecognizedException() {
    }

    public BanknoteIsNotRecognizedException(String message) {
        super(message);
    }
}
