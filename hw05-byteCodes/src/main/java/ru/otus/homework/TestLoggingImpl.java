package ru.otus.homework;

import ru.otus.homework.annotations.Log;

public class TestLoggingImpl implements TestLogging {
    public void calculation(int param) {
        System.out.println(param / 10);
    }

    @Log
    public void calculation(int... params) {
        int result = 0;
        for (int param : params) {
            result += param;
        }
        System.out.println(result);
    }

    @Log
    public void calculation(int param1, int param2, String param3) {
        System.out.println(param1 == param2 ? param3 : "not equal");
    }
}
