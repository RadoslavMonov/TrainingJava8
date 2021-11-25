package com.company.data;


import com.company.models.Album;
import com.company.models.Artist;
import com.company.models.Track;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class MusicSampleData {

    public static final Artist johnColtrane = new Artist("John Coltrane", "US");
    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");
    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison,
            ringoStarr);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles,
            "UK");

    public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement",
            467), new Track("Resolution", 442)), asList(johnColtrane));

    public static final Album sampleShortAlbum = new Album("sample Short Album 1", asList(new Track("short track",
            30)), asList(johnColtrane));

    public static final Album manyTrackAlbum = new Album("sample Short Album 2", asList(new Track("short track",
                    30), new Track("short track 2", 30), new Track("short track 3", 30),
            new Track("short track 4", 30), new Track("short track 5", 30)), asList(johnColtrane));

    public static final Album collabAlbum = new Album("1970 hits", asList(new Track("Yesterday", 300),
            new Track("Other beatles song", 400)), asList(theBeatles, ringoStarr, johnColtrane));

    public static List<Album> albumsList = Arrays.asList(aLoveSupreme, sampleShortAlbum, manyTrackAlbum, collabAlbum);

    public static Stream<Album> albums = Stream.of(aLoveSupreme);

    public static Stream<Artist> threeArtists() {
        return Stream.of(johnColtrane, johnLennon, theBeatles);
    }

    public static List<Artist> getThreeArtists() {
        return Arrays.asList(johnColtrane, johnLennon, theBeatles);
    }

}
