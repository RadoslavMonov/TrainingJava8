package com.company.exercises.streams;

import java.util.function.Function;

public class Ex6_lowercaseCountInString {
    public static void main(String[] args) {
        String str = "AbCdEfG";

        Function<String,Long> getLowerCaseCount = s -> s.chars()
                .filter(value -> value >= 97)
                .filter(value -> value <= 121)
                .count();

        System.out.println(getLowerCaseCount.apply(str));

    }
}
