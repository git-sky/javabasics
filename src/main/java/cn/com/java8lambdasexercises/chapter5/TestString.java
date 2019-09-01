package cn.com.java8lambdasexercises.chapter5;

import cn.com.java8lambdasexercises.chapter1.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestString {

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");
    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);


    public static void main(String[] args) {
        System.out.println(formatArtists(membersOfTheBeatles));
        System.out.println(formatArtistsForLoop(membersOfTheBeatles));
        System.out.println(formatArtistsRefactor1(membersOfTheBeatles));
        System.out.println(formatArtistsRefactor2(membersOfTheBeatles));
        System.out.println(formatArtistsRefactor3(membersOfTheBeatles));
        System.out.println(formatArtistsRefactor4(membersOfTheBeatles));
        System.out.println(formatArtistsRefactor5(membersOfTheBeatles));

        System.out.println(formatArtistsReducing(membersOfTheBeatles));
    }

    public static String formatArtists(List<Artist> artists) {
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(Collectors.joining(", ", "[", "]"));

        return result;
    }

    public static String formatArtistsForLoop(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();

        return result;
    }

    public static String formatArtistsRefactor1(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                });
        builder.append("]");
        String result = builder.toString();

        return result;
    }

    public static String formatArtistsRefactor2(List<Artist> artists) {
        StringBuilder reduced =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringBuilder(), (builder, name) -> {
                            if (builder.length() > 0) {
                                builder.append(", ");
                            }
                            builder.append(name);
                            return builder;
                        }, (left, right) -> left.append(right));

        reduced.insert(0, "[");
        reduced.append("]");
        String result = reduced.toString();

        return result;
    }

    public static String formatArtistsRefactor3(List<Artist> artists) {
        StringCombiner combined =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringCombiner(", ", "[", "]"),
                                StringCombiner::add,
                                StringCombiner::merge);

        String result = combined.toString();

        return result;
    }

    public static String formatArtistsRefactor4(List<Artist> artists) {
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .reduce(new StringCombiner(", ", "[", "]"),
                                StringCombiner::add,
                                StringCombiner::merge)
                        .toString();

        return result;
    }

    public static String formatArtistsRefactor5(List<Artist> artists) {
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(new StringCollector(", ", "[", "]"));

        return result;
    }

    public static String formatArtistsReducing(List<Artist> artists) {
        String result =
                artists.stream()
                        .map(Artist::getName)
                        .collect(Collectors.reducing(
                                new StringCombiner(", ", "[", "]"),
                                name -> new StringCombiner(", ", "[", "]").add(name),
                                StringCombiner::merge))
                        .toString();

        return result;
    }

    /*.reduce(,
    ,
    StringCombiner::merge)
            .toString()*/

}
