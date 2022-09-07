package ru.otus.demo.creationalPatterns.factories.factorymethod;

import ru.otus.demo.creationalPatterns.factories.simplefactory.Configuration;
import ru.otus.demo.creationalPatterns.factories.simplefactory.ConfigurationFile;

class ConfigurationFactoryFile extends ConfigurationFactory {
    @Override
    Configuration buildConfiguration() {
        return new ConfigurationFile();
    }
}
