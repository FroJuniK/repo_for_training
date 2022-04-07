package ru.otus;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        String input = "Apple-banana-pineapple became friends.";
        System.out.println(CharMatcher.is('-').replaceFrom(input, " and "));

        List<String> names = Lists.newArrayList("John","Jane","Adam","Tom","Viki","Tyler");
        List<List<String>> result = Lists.partition(names, 2);
        System.out.println(result);
    }
}
