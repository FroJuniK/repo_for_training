package ru.otus.demo.creationalPatterns.abstractfactory.updated;

import ru.otus.demo.creationalPatterns.abstractfactory.AbstractFactory;
import ru.otus.demo.creationalPatterns.abstractfactory.luminescent.LuminescentFactory;

/**
 * @author sergey
 * created on 18.09.18.
 */
public class LuminescentStrategy implements Strategy {
    @Override
    public AbstractFactory configuration() {
        return new LuminescentFactory();
    }
}
