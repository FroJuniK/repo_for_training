package ru.otus.model;

import java.util.List;

public class ObjectForMessage implements Cloneable {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public ObjectForMessage copy() {
        ObjectForMessage copy = new ObjectForMessage();
        if (getData() != null) {
            copy.setData(List.copyOf(getData()));
        }
        return copy;
    }
}
