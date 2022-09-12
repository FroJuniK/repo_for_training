package ru.otus.time;

import java.time.LocalTime;

public interface TimeProvider {
    LocalTime getTime();
}
