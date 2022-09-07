package ru.otus.demo.behavioralPatterns.command;

@FunctionalInterface
public interface Command {
    String execute(SomeObject object);
}
