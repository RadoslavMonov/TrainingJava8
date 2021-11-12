package com.company.exercises;

import com.company.bookmodels.Album;
import com.company.bookmodels.Artist;
import com.company.data.SampleData;

import java.util.List;
import java.util.stream.Collectors;

public class CombinedExerciseStreams {
//    Our first problem to solve is, for a given album, to find the nationality of every band playing on that album.
//    The artists who play each track can be solo artists or they can be in a band.
//    We’re going to use domain knowledge and artistic license to pretend that a band is really an artist whose name begins with The.
//    This isn’t exactly right, but it’s pretty close!

    public static void main(String[] args) {
        Album album = SampleData.collabAlbum;

        System.out.println(album.getMusicianList().stream()
                .filter(musician -> musician.getName().startsWith("The"))
                .map(musician -> musician.getNationality())
                .collect(Collectors.toList()));

        //double check results
        List<Artist> artists = album.getMusicians()
                .filter(band -> band.getName().startsWith("The"))
                .collect(Collectors.toList());

        System.out.println(artists.size());
        Artist artist = artists.get(0);
        System.out.println(artist.getName());
        System.out.println(artist.getNationality());
    }
}
