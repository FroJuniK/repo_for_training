package ru.otus.demo.behavioralPatterns.chain;

public class ApplicationInput extends ApplicationProcessor {

    @Override
    protected void processInternal(Application application) {
        application.addHistoryRecord("Заявление принято");
    }

    @Override
    public String getProcessorName() {
        return "Прием заявления";
    }
}
