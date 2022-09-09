package ru.otus.processor;

import ru.otus.model.Message;
import ru.otus.time.TimeProvider;

public class ProcessorExceptionThrower implements Processor {

    private final TimeProvider timeProvider;

    public ProcessorExceptionThrower(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public Message process(Message message) {
        if (timeProvider.isAnEvenSecond()) {
            throw new RuntimeException("Even second!");
        }
        return message;
    }
}
