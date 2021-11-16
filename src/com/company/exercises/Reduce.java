package com.company.exercises;

import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3)
                .reduce(0, (accumulator, element) -> accumulator + element);

        // 0(acc) + 1(el) -> 1(acc) + 2(el) -> 3(acc) + 3(el) = 6
        System.out.println(sum); // 0 + 1+2+3 = 6
    }
}
