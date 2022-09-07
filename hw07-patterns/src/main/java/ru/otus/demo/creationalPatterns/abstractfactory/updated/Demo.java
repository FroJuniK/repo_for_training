package ru.otus.demo.creationalPatterns.abstractfactory.updated;

import ru.otus.demo.creationalPatterns.abstractfactory.AbstractFactory;
import ru.otus.demo.creationalPatterns.abstractfactory.Bulb;
import ru.otus.demo.creationalPatterns.abstractfactory.Lampholder;

/**
 * @author sergey
 * created on 17.09.18.
 */
public class Demo {

    public Demo(AbstractFactory abstractFactory) {
        Bulb bulb = abstractFactory.createBulb();
        Lampholder lampholder = abstractFactory.createLampholder();

        bulb.light();
        lampholder.hold();
    }

    public static AbstractFactory configuration(Strategy strategy) {
        return strategy.configuration();
    }

    public static void main(String[] args) {
        new Demo(configuration(new LedStrategy()));
        new Demo(configuration(new LuminescentStrategy()));
    }

}
