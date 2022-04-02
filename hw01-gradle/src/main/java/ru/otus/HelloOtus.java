package ru.otus;

import com.google.common.base.CharMatcher;

public class HelloOtus {
    public static void main(String[] args) {
        String input = "Apple-banana-pineapple became friends.";
        System.out.println(CharMatcher.is('-').replaceFrom(input, " and "));
    }
}