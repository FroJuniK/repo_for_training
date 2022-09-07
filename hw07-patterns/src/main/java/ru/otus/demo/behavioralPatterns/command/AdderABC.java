package ru.otus.demo.behavioralPatterns.command;

public class AdderABC implements Command {
    @Override
    public String execute(SomeObject object) {
        object.setValue(object.getValue() + "+ABC");
        return "ABC added";
    }
}
