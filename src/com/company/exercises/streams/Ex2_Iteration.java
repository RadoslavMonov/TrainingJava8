package com.company.exercises.streams;

import com.company.data.MusicSampleData;
import com.company.models.Artist;

import java.util.List;
import java.util.stream.Stream;

public class Ex2_Iteration {

    // Convert from external to internal iteration
//    int totalMembers = 0;
//    for (Artist artist : artists) {
//        Stream<Artist> members = artist.getMembers();
//        totalMembers += members.count();
//    }
    public static void main(String[] args) {
        List<Artist> artists = MusicSampleData.getThreeArtists();

         System.out.println(artists.stream().count());

        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        System.out.println("External iteration result: " + totalMembers);

        System.out.println("Internal iteration resulst : " + artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0l, (sumMembers, members) -> sumMembers + members));
    }
}
