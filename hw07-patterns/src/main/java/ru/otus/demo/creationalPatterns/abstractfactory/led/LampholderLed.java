package ru.otus.demo.creationalPatterns.abstractfactory.led;

import ru.otus.demo.creationalPatterns.abstractfactory.Lampholder;

/**
 * @author sergey
 * created on 18.09.18.
 */
public class LampholderLed implements Lampholder {
    @Override
    public void hold() {
        System.out.println("Led hold");
    }
}
