package ru.otus.demo.aop.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        MyClassInterface myClass = Ioc.createMyClass();
        myClass.secureAccess("Security Param");
    }
}



