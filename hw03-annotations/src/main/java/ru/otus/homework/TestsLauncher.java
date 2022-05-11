package ru.otus.homework;

import ru.otus.homework.annotations.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.otus.reflection.ReflectionHelper.callMethod;
import static ru.otus.reflection.ReflectionHelper.instantiate;

public class TestsLauncher {
    public static void main(String[] args) throws ClassNotFoundException {
        run(ClassWithTests.class.getCanonicalName());
    }

    public static void run(String testClass) throws ClassNotFoundException {
        int failed = 0;

        Class<?> clazz = Class.forName(testClass);
        Map<String, List<Method>> methods = getMethodsByAnnotations(clazz.getDeclaredMethods());
        for (Method method : methods.get(Test.class.getCanonicalName())) {
            Object testClassInstance = instantiate(clazz);
            try {
                callBefore(methods, testClassInstance);
                callMethod(testClassInstance, method.getName());
            } catch (RuntimeException ex) {
                System.out.printf("Task %s FAILED\n%s%n", method.getName(), ex);
                failed++;
            } finally {
                callAfter(methods, testClassInstance);
            }
        }
        printStatistics(methods.get(Test.class.getCanonicalName()).size(), failed);
    }

    private static Map<String, List<Method>> getMethodsByAnnotations(Method[] methods) {
        return Stream.of(methods).collect(Collectors.groupingBy(TestsLauncher::getNameFirstAnnotationOnMethod));
    }

    private static String getNameFirstAnnotationOnMethod(Method method) {
        return method.getDeclaredAnnotations()[0].annotationType().getName();
    }

    private static void callBefore(Map<String, List<Method>> methods, Object instance) {
        callMethod(instance, methods.get(Before.class.getCanonicalName()).get(0).getName());
    }

    private static void callAfter(Map<String, List<Method>> methods, Object instance) {
        callMethod(instance, methods.get(After.class.getCanonicalName()).get(0).getName());
    }

    private static void printStatistics(int total, int failed) {
        System.out.printf("Tests failed: %d, passed: %d, total: %d%n", failed, total - failed, total);
    }
}
