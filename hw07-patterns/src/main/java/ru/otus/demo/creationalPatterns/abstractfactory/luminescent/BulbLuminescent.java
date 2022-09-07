package ru.otus.demo.creationalPatterns.abstractfactory.luminescent;

import ru.otus.demo.creationalPatterns.abstractfactory.Bulb;

/**
 * @author sergey
 * created on 17.09.18.
 */
public class BulbLuminescent implements Bulb {
    @Override
    public void light() {
        System.out.println("Luminescent light");
    }
}
