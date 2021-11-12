package com.company.exercises;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FlatMap {
    public static void main(String[] args) {

        //example 1
        List<List<String>> list = asList(
                asList("a"),
                asList("b"));
        System.out.println(list);

        System.out.println(list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        //example 2

        //method ref
        List<Integer> together = Stream.of(asList(1,2),asList(3,4),asList(5,6))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(together);
        //lambda
        List<Integer> together2 = Stream.of(asList(1,2),asList(3,4),asList(5,6))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());


    }
}
