package ru.otus.exception;

public class UnableToWithdrawException extends Exception {
    public UnableToWithdrawException() {
    }

    public UnableToWithdrawException(String message) {
        super(message);
    }
}
