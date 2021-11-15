package com.company.exercises.streams;

import com.company.data.MusicSampleData;
import com.company.models.Album;
import com.company.models.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1_CommonStreamOperations {
    //Common Stream operations. Implement the following:
//
//        A function that adds up numbers, i.e., int addUp(Stream<Integer> numbers)
//        A function that takes in artists and returns a list of strings with their names and places of origin
//        A function that takes in albums and returns a list of albums with at most three tracks
    public static void main(String[] args) {
        System.out.println("Sum of 1-6 = " + addUp(Stream.of(1,2,3,5,6)));

        List<String> artistsInfo = getArtistsNamesAndOrigin(MusicSampleData.getThreeArtists());
        System.out.println(artistsInfo);

        List<Album> albumsWithMax3Tracks = filterAlbumbsWithMax3Tracks(MusicSampleData.albumsList);

        System.out.println(albumsWithMax3Tracks.stream()
                .map(album -> album.getName() + " has " + album.getTrackList().size() + " tracks ")
                .collect(Collectors.toList()));
    }

    public static Integer addUp(Stream<Integer> numbers) {
        return numbers.reduce(0,(accumulator, element) -> accumulator +element );
    }

    public static List<String> getArtistsNamesAndOrigin(List<Artist> artists) {
       return  artists.stream()
                .map(artist -> artist.getName() + " from " +artist.getNationality())
               .collect(Collectors.toList());
    }

    public static List<Album> filterAlbumbsWithMax3Tracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }
}
