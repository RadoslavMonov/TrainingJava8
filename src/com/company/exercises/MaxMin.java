package com.company.exercises;

import com.company.bookmodels.Album;
import com.company.bookmodels.Track;
import com.company.data.SampleData;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MaxMin {
    public static void main(String[] args) {
        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        System.out.println(shortestTrack.getName());

        List<Album> albums = new LinkedList<>();
        albums.add(SampleData.aLoveSupreme);
        albums.add(SampleData.sampleShortAlbum);
        albums.add(SampleData.manyTrackAlbum);



        Album albumResult = albums.stream()
                .min(Comparator.comparing(album -> album.getTrackList().size()))
                .get();

        System.out.println("Album with least amount of tracks is " + albumResult.getName() + " with " + albumResult.getTrackList().size() + " tracks ") ;

       Album albumResult2 = albums.stream()
                .max(Comparator.comparing(album -> album.getTrackList().size()))
                .get();

        System.out.println("Album with most amount of tracks is " + albumResult2.getName() + " with " + albumResult2.getTrackList().size() + " tracks ") ;

//        assertEquals(tracks.get(1), shortestTrack);
    }
}