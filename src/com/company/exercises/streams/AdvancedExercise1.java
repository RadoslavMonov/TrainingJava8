package com.company.exercises.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class AdvancedExercise1 {
//    Write an implementation of the Stream function map using only reduce and lambda expressions.
//    You can return a List instead of a Stream if you want.


    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("rado","pesho","tosho");






    }

    // map f = foldr ((:) . f) []
    // Advanced Exercise
    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
            // Make copy of list (modifying acc would violate contract of reduce method)
            ArrayList<R> result = new ArrayList<>();
            result.addAll(acc);
            result.add(mapper.apply(value));
            return result;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;
        });
    }
}
