package cn.com.java8lambdasexercises.chapter3;


import cn.com.java8lambdasexercises.chapter1.Album;
import cn.com.java8lambdasexercises.chapter1.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Decisions {

    public static class Imperative {

        public Set<String> originsOfBands(Album album) {
            Set<String> nationalities = new HashSet<>();
            for (Artist artist : album.getMusicianList()) {
                if (artist.getName().startsWith("The")) {
                    String nationality = artist.getNationality();
                    nationalities.add(nationality);
                }
            }
            return nationalities;
        }

    }

    public Set<String> originsOfBands(Album album) {

        Set<String> origins = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(toSet());

        return origins;
    }

    public Set<String> originsOfBandsMisuse(Album album) {

        List<Artist> musicians = album.getMusicians()
                .collect(toList());

        List<Artist> bands = musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(toList());

        Set<String> origins = bands.stream()
                .map(artist -> artist.getNationality())
                .collect(toSet());

        return origins;
    }

}
