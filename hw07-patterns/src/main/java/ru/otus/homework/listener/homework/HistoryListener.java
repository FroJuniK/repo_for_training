package ru.otus.homework.listener.homework;

import ru.otus.homework.listener.Listener;
import ru.otus.homework.model.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private final Map<Long, Message> history;

    public HistoryListener() {
        this.history = new HashMap<>();
    }

    @Override
    public void onUpdated(Message msg) {
        history.put(msg.getId(), msg.copy());
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(history.get(id));
    }
}
