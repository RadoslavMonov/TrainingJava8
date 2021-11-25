package com.company.exercises;



import com.company.data.MusicSampleData;
import com.company.models.Album;
import com.company.models.Track;

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
        albums.add(MusicSampleData.aLoveSupreme);
        albums.add(MusicSampleData.sampleShortAlbum);
        albums.add(MusicSampleData.manyTrackAlbum);

        Album leastTracksAlbum = albums.stream()
                .min(Comparator.comparing(album -> album.getTrackList().size()))
                .get();

       Album mostTracksAlbum = albums.stream()
                .max(Comparator.comparing(album -> album.getTrackList().size()))
                .get();

        System.out.println(String.format("Album with least amount of tracks is %s with %d tracks",
                leastTracksAlbum.getName(),leastTracksAlbum.getTrackList().size()));
        System.out.println(String.format("Album with most amount of tracks is %s with %d tracks",
                mostTracksAlbum.getName(),mostTracksAlbum.getTrackList().size()));
    }
}
