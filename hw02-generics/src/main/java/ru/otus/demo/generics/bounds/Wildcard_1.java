package ru.otus.demo.generics.bounds;

import ru.otus.demo.generics.bounds.entries.Animal;
import ru.otus.demo.generics.bounds.entries.Cat;
import ru.otus.demo.generics.bounds.entries.HomeCat;
import ru.otus.demo.generics.bounds.entries.WildCat;

import java.util.ArrayList;
import java.util.List;

public class Wildcard_1 {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        print(animalList);
        printWild(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new HomeCat("Барсик"));
        catList.add(new WildCat("Багира"));

        List<HomeCat> homeCatList = new ArrayList<>();
        homeCatList.add(new HomeCat("Мурка"));
        //print(homeCatList);
        printWild(homeCatList);

        //print(catList); //Ошибка
        printWild(catList);
    }

    private static void print(List<Animal> animalList) {
        animalList.forEach(System.out::println);
    }

    private static void printWild(List<? extends Animal> animalList) {
        animalList.forEach(System.out::println);
    }
}
