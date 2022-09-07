package ru.otus.demo.creationalPatterns.abstractfactory.luminescent;

import ru.otus.demo.creationalPatterns.abstractfactory.Lampholder;

/**
 * @author sergey
 * created on 18.09.18.
 */
public class LampholderLuminescent implements Lampholder {
    @Override
    public void hold() {
        System.out.println("Luminescent hold");
    }
}
