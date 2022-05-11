package ru.otus.homework;

import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

public class ClassWithTests {

    @Before
    public void setUp() {
        System.out.print("\n@Before. ");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }

    @Test
    void test() {
        System.out.print("@Test: anyTest1. ");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }

    @Test
    void testWithEx() throws Exception {
        System.out.print("@Test: anyTest2. ");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
        throw new Exception("Всё сломалось!1");
    }

    @After
    public void tearDown() {
        System.out.print("@After. ");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }
}
