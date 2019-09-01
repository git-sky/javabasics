package cn.com.java8lambdasexercises.chapter5;


import cn.com.java8lambdasexercises.chapter1.Album;
import cn.com.java8lambdasexercises.chapter1.Artist;
import cn.com.java8lambdasexercises.chapter1.Track;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.charset.Charset.defaultCharset;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.averagingInt;


/**
 * 数据分组
 */
public class TestGroupingBy {

    public static final Artist johnColtrane = new Artist("John Coltrane", "US");
    public static final Artist johnColtrane2 = new Artist("John Coltrane-2", "US");
    public static final Artist johnColtrane3 = new Artist("John Coltrane-3", "US");


    public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), asList(johnColtrane));
    public static final Album sampleShortAlbum = new Album("sample Short Album", asList(new Track("short track", 30)), asList(johnColtrane));

    public static final Album manyTrackAlbum = new Album("sample Short Album", asList(new Track("short track", 30), new Track("short track 2", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), asList(johnColtrane2));

    public static final Album threeAlbum = new Album("three Album", asList(new Track("short track", 30), new Track("short track 2", 30)), asList(johnColtrane3));


    public static Stream<Album> albums = Stream.of(aLoveSupreme, sampleShortAlbum, manyTrackAlbum, threeAlbum);

    @Test
    public void numberOfAlbumsDumb() {
        //数据分组
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));

        //使用for计算统计值
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }
        System.out.println(numberOfAlbums);
    }

    @Test
    public void numberOfAlbums() {
        //使用counting计算统计值
        Map<Artist, Long> map = albums.collect(groupingBy(album -> album.getMainMusician(), counting()));
        System.out.println(map);
    }


    @Test
    public void nameOfAlbumsDumb() {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));

        //使用for计算统计值
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(toList()));
        }
        System.out.println(nameOfAlbums);
    }


    @Test
    public void nameOfAlbums() {
        Map<Artist, List<String>> nameOfAlbums = albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
        System.out.println(nameOfAlbums);
    }


    @Test
    public void averageNumberOfTracks() {
        double d = albums.collect(averagingInt(album -> album.getTrackList().size()));
        System.out.println(d);
    }

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, defaultCharset())
                .stream()
                .flatMap(line -> SPACES.splitAsStream(line));

        return countWords(words);
    }

    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(groupingBy(word -> word, counting()));
    }

}