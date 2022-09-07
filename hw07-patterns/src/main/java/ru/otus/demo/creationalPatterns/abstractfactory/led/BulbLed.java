package ru.otus.demo.creationalPatterns.abstractfactory.led;

import ru.otus.demo.creationalPatterns.abstractfactory.Bulb;

/**
 * @author sergey
 * created on 18.09.18.
 */
public class BulbLed implements Bulb {
    @Override
    public void light() {
        System.out.println("Led light");
    }
}
