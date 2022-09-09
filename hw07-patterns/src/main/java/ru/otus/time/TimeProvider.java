package ru.otus.time;

import java.time.LocalTime;

public interface TimeProvider {
    default boolean isAnEvenSecond() {
        return LocalTime.now().getSecond() % 2 == 0;
    }
}
