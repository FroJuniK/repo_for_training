package ru.otus.homework;

import ru.otus.homework.annotations.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.*;

public class Ioc {
    private Ioc() {
    }

    static class MethodDTO {
        String name;
        Parameter[] parameters;

        public MethodDTO(String name, Parameter[] parameters) {
            this.name = name;
            this.parameters = parameters;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || Method.class != obj.getClass()) {
                return false;
            }
            Method m = (Method) obj;
            return name.equals(m.getName()) && Arrays.equals(parameters, m.getParameterTypes());
        }
    }

    static TestLogging createMyClass(TestLogging arg) {
        InvocationHandler handler = new Ioc.MyInvocationHandler(arg);
        return (TestLogging) Proxy.newProxyInstance(arg.getClass().getClassLoader(), arg.getClass().getInterfaces(), handler);
    }

    static class MyInvocationHandler implements InvocationHandler {
        private final TestLogging testLogging;
        private final List<MethodDTO> methodsWithAnnotation;

        MyInvocationHandler(TestLogging testLogging) {
            this.testLogging = testLogging;
            this.methodsWithAnnotation = getMethodsWithAnnotation();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methodsWithAnnotation.contains(method)) {
                System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            }
            return method.invoke(testLogging, args);
        }

        private List<MethodDTO> getMethodsWithAnnotation() {
            List<MethodDTO> result = new ArrayList<>();
            Method[] methods = testLogging.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Log.class)) {
                    result.add(new MethodDTO(method.getName(), method.getParameters()));
                }
            }
            return result;
        }
    }
}
