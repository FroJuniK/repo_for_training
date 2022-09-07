package ru.otus.demo.creationalPatterns.factories.factorymethod;

import ru.otus.demo.creationalPatterns.factories.simplefactory.Configuration;
import ru.otus.demo.creationalPatterns.factories.simplefactory.ConfigurationDB;

class ConfigurationFactoryDB extends ConfigurationFactory {
    @Override
    Configuration buildConfiguration() {
        return new ConfigurationDB();
    }
}
