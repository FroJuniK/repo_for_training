package ru.otus.demo.generics.bounds;

import ru.otus.demo.generics.bounds.entries.Animal;
import ru.otus.demo.generics.bounds.entries.Cat;

import java.util.ArrayList;
import java.util.List;

public class Wildcard_2 {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        printWild(animalList);
        printObj(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printWild(catList);
        printObj(catList);

        for (Object cat : catList) {
            if (cat instanceof Cat) {
                System.out.println(((Cat) cat).getMyau());
            }
        }

        //        //левый тип данных
        List<String> stringList = new ArrayList<>();
        stringList.add("подкидыш");
        printWild(stringList);
        printObj(stringList);

        //        //Можно еще и так
        //        List voidList = new ArrayList<>();
        //        voidList.add(LocalTime.now());
        //        printWild(voidList);
        //        printObj(voidList);

    }

    //Unbounded Wildcards
    private static void printWild(List<?> animalList) {
        //animalList.add("внезапно добавленная строка"); //ошибка
        animalList.forEach(System.out::println);
    }

    private static void printObj(List animalList) {
        animalList.add("внезапно добавленная строка");
        animalList.forEach(System.out::println);
    }
}