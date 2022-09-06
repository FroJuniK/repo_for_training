package ru.otus.demo.polymorphism.operations;

import ru.otus.demo.polymorphism.Operation;

/**
 * @author sergey
 * created on 09.09.19.
 */
public class Update implements Operation {
    @Override
    public void action(String data) {
        System.out.println("update, data:" + data);
    }
}
