package ru.otus.demo.creationalPatterns.abstractfactory;

/**
 * @author sergey
 * created on 17.09.18.
 */
public interface AbstractFactory {
    Bulb createBulb();

    Lampholder createLampholder();
}
