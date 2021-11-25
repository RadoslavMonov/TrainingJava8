package com.company.exercises.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Ex7_StringWithMostLowercases {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abcDEF","abcdefg","abCDEFG");

        Function<String,Long> getLowerCaseCount = s -> s.chars()
                .filter(value -> value >= 97)
                .filter(value -> value <= 121)
                .count();

        System.out.println(strings.stream()
                .max(Comparator.comparing(s -> getLowerCaseCount.apply(s)))
                .get());


    }
}
