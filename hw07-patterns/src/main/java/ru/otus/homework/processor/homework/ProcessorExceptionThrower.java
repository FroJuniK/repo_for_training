package ru.otus.homework.processor.homework;

import ru.otus.demo.behavioralPatterns.memento.DateTimeProvider;
import ru.otus.homework.model.Message;
import ru.otus.homework.processor.Processor;

public class ProcessorExceptionThrower implements Processor {

    private final DateTimeProvider dateTimeProvider;

    public ProcessorExceptionThrower(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    @Override
    public Message process(Message message) {
        if (dateTimeProvider.getDate().getSecond() % 2 == 0) {
            throw new RuntimeException();
        }
        return message;
    }
}
