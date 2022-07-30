package ru.otus.homework;

import ru.otus.homework.annotations.Log;

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
        String[] parameters;

        public MethodDTO(String name, String[] parameters) {
            this.name = name;
            this.parameters = parameters;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode() + parameters.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof MethodDTO))
                return false;
            MethodDTO method = (MethodDTO) obj;
            return name.equals(method.name) && Arrays.equals(parameters, method.parameters);
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
            MethodDTO methodDTO = new MethodDTO(method.getName(), paramArrayToStringArray(method.getParameters()));
            if (methodsWithAnnotation.contains(methodDTO)) {
                System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            }
            return method.invoke(testLogging, args);
        }

        private List<MethodDTO> getMethodsWithAnnotation() {
            List<MethodDTO> result = new ArrayList<>();
            Method[] methods = testLogging.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Log.class)) {
                    result.add(new MethodDTO(method.getName(), paramArrayToStringArray(method.getParameters())));
                }
            }
            return result;
        }

        private String[] paramArrayToStringArray(Parameter[] arr) {
            return Arrays.stream(arr).map(Parameter::toString).toArray(String[]::new);
        }
    }
}
