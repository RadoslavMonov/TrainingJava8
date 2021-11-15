package com.company.exercises.streams;

import com.company.data.MusicSampleData;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex5_PureFunctions {
    public static void main(String[] args) {
//        Pure functions.
//        Are these lambda expressions side effect-free, or do they mutate state?
//                x -> x + 1
//        Here’s the example code:
//
//        AtomicInteger count = new AtomicInteger(0);
//        List<String> origins = album.musicians()
//                .forEach(musician -> count.incrementAndGet())

        AtomicInteger count = new AtomicInteger(0);
        System.out.println(MusicSampleData.manyTrackAlbum.musicians.stream().count());

        MusicSampleData.manyTrackAlbum.musicians
                .forEach(musician -> count.incrementAndGet());

        System.out.println(count);

    }
}
