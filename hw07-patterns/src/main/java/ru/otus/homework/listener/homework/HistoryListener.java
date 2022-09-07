package ru.otus.homework.listener.homework;

import ru.otus.homework.listener.Listener;
import ru.otus.homework.model.Message;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    @Override
    public void onUpdated(Message msg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        throw new UnsupportedOperationException();
    }
}
