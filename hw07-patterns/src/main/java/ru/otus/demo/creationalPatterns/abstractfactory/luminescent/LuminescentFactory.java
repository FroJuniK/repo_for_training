package ru.otus.demo.creationalPatterns.abstractfactory.luminescent;

import ru.otus.demo.creationalPatterns.abstractfactory.AbstractFactory;
import ru.otus.demo.creationalPatterns.abstractfactory.Bulb;
import ru.otus.demo.creationalPatterns.abstractfactory.Lampholder;

/**
 * @author sergey
 * created on 17.09.18.
 */
public class LuminescentFactory implements AbstractFactory {
    @Override
    public Bulb createBulb() {
        return new BulbLuminescent();
    }

    @Override
    public Lampholder createLampholder() {
        return new LampholderLuminescent();
    }
}
