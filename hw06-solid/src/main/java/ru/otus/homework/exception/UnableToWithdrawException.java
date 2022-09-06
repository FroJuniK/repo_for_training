package ru.otus.homework.exception;

public class UnableToWithdrawException extends Exception {
    public UnableToWithdrawException() {
    }

    public UnableToWithdrawException(String message) {
        super(message);
    }
}
