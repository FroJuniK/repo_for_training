package ru.otus.homework;

public class Main {

    public static void main(String[] args) {
        TestLogging myClass = Ioc.createMyClass(new TestLoggingImpl());

        myClass.calculation(101);
        myClass.calculation(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        myClass.calculation(4, 4, "eah");
    }
}
