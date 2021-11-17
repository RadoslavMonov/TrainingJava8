package com.company.exercises;


import com.company.data.MusicSampleData;
import com.company.models.Album;
import com.company.models.Artist;
import com.company.models.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CombinedExerciseStreams {

    // Our first problem to solve is, for a given album, to find the nationality of every band playing on that album.
    // The artists who play each track can be solo artists or they can be in a band.
    // We’re going to use domain knowledge and artistic license to pretend that a band is really an artist whose name
    // begins with The.
    // This isn’t exactly right, but it’s pretty close!

    public static void main(String[] args) {
        Album album = MusicSampleData.collabAlbum;

        System.out.println(album.getMusicianList().stream()
                .filter(musician -> musician.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(Collectors.toList()));

        // double check results

        List<Artist> artists = album.getMusicians()
                .filter(band -> band.getName().startsWith("The"))
                .collect(Collectors.toList());

        System.out.println(artists.size());
        Artist artist = artists.get(0);
        System.out.println(artist.getName());
        System.out.println(artist.getNationality());

        List<Album> sampleAlbums = MusicSampleData.albumsList;



        long startTimeNotRefactoredMethod = System.currentTimeMillis();
        System.out.println("Set of long tracks(legacy code): " + findLongTracks(sampleAlbums));
        long endTimeNotRefactoredMethod = System.currentTimeMillis();
        printSpentTime(startTimeNotRefactoredMethod,endTimeNotRefactoredMethod);

        long startTimeFirstRefactor = System.currentTimeMillis();
        System.out.println("Set of long tracks(first refactor): " + findLongTracksFirstRefactor(sampleAlbums));
        long endTimeFirstRefactor = System.currentTimeMillis();
        printSpentTime(startTimeFirstRefactor,endTimeFirstRefactor);

        long startTimeSecondRefactor = System.currentTimeMillis();
        System.out.println("Set of long tracks(2nd refactor): " + findLongTracksSecondRefactor(sampleAlbums));
        long endTimeSecondRefactor = System.currentTimeMillis();
        printSpentTime(startTimeSecondRefactor,startTimeSecondRefactor);

        long startTimeFinalRefactored = System.currentTimeMillis();
        System.out.println("Set of long tracks(final refactor): " + findLongTracksFinalRefactor(sampleAlbums));
        long endTimeFinalRefactor = System.currentTimeMillis();
        printSpentTime(startTimeFinalRefactored,endTimeFinalRefactor);
    }

    private static void printSpentTime(long start, long end){
        System.out.println(String.format("Took %d milliseconds to execute",(end - start)));
    }

    // "Legacy" code that needs refactoring
    public static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    // first refactor
    public static Set<String> findLongTracksFirstRefactor(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album ->
                        album.getTracks()
                                .filter(track -> track.getLength() > 60)
                                .map(Track::getName)
                                .forEach(trackNames::add)
                );
        return trackNames;
    }

    // 2nd refactor
    public static Set<String> findLongTracksSecondRefactor(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();

        albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .forEach(trackNames::add);

        return trackNames;
    }

    // Final refactor
    public static Set<String> findLongTracksFinalRefactor(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .collect(Collectors.toSet());
    }
}
