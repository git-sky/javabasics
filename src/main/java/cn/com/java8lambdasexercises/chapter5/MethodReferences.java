package cn.com.java8lambdasexercises.chapter5;


import cn.com.java8lambdasexercises.chapter1.Album;
import cn.com.java8lambdasexercises.chapter1.Artist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static cn.com.java8lambdasexercises.chapter5.TestGroupingBy.countWords;
import static java.nio.charset.Charset.defaultCharset;
import static java.util.stream.Collectors.groupingBy;

public class MethodReferences {

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
//        return albums.collect(groupingBy(a -> a.getMainMusician()));
        //方法引用
        return albums.collect(groupingBy(Album::getMainMusician));
    }

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, defaultCharset())
                .stream()
                .flatMap(SPACES::splitAsStream);

        return countWords(words);
    }

}
