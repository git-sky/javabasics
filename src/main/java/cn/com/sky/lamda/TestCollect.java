//package cn.com.sky.lamda;
//
//import org.junit.Test;
//
//import java.util.*;
//import java.util.function.BinaryOperator;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static java.lang.Character.isDigit;
//import static java.util.Arrays.asList;
//import static java.util.stream.Collectors.toList;
//import static org.junit.Assert.assertEquals;
//
//public class TestCollect {
//
//    //collect(toList()) 方法由 Stream 里的值生成一个列表，是一个及早求值操作。
//    @Test
//    public void test() {
//        List<String> collected = Stream.of("a", "b", "c").collect(toList());
//        assertEquals(asList("a", "b", "c"), collected);
//
//    }
//
//    //如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以 使用该函数，将一个流中的值转换成一个新的流。
//
//    @Test
//    public void testMap() {
////
////        List<String> collected = new ArrayList<>();
////        for (String string : asList("a", "b", "hello")) {
////            String uppercaseString = string.toUpperCase();
////            collected.add(uppercaseString);
////        }
////        assertEquals(asList("A", "B", "HELLO"), collected);
//
//
//        List<String> collected = Stream.of("a", "b", "hello")
//                .map(string -> string.toUpperCase()).collect(toList());
//        assertEquals(asList("A", "B", "HELLO"), collected);
//    }
//
//    //遍历数据并检查其中的元素时，可尝试使用 Stream 中提供的新方法 filter
//
//    @Test
//    public void testFilter() {
//
////        List<String> beginningWithNumbers = new ArrayList<>();
////        for (String value : asList("a", "1abc", "abc1")) {
////            if (isDigit(value.charAt(0))) {
////                beginningWithNumbers.add(value);
////            }
////        }
////        assertEquals(asList("1abc"), beginningWithNumbers);
//
//
//        List<String> beginningWithNumbers
//                = Stream.of("a", "1abc", "abc1")
//                .filter(value -> isDigit(value.charAt(0)))
//                .collect(toList());
//        assertEquals(asList("1abc"), beginningWithNumbers);
//
//    }
//
//
//    //flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream。
//    @Test
//    public void testFlatMap() {
//
//        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
//                .flatMap(numbers -> numbers.stream())
//                .collect(toList());
//        assertEquals(asList(1, 2, 3, 4), together);
//    }
//
//    @Test
//    public void testMax() {
//        List<Track> tracks = asList(new Track("Bakai", 524),
//                new Track("Violets for Your Furs", 378),
//                new Track("Time Was", 451));
//        Track shortestTrack = tracks.stream()
//                .min(Comparator.comparing(track -> track.getLength()))
//                .get();
//
//        System.out.println(tracks.get(1).getName());
//        assertEquals(tracks.get(1), shortestTrack);
//    }
//
//    @Test
//    public void testReduce() {
//
////        int count = Stream.of(1, 2, 3)
////                .reduce(0, (acc, element) -> acc + element);
////
////        assertEquals(6, count);
//
//
//        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
//        int count = accumulator.apply(
//                accumulator.apply(
//                        accumulator.apply(0, 1),
//                        2), 3);
//        System.out.println(count);
//
//
////        使用命令式编程方式求和
//        int acc = 0;
//        for (Integer element : asList(1, 2, 3)) {
//            acc = acc + element;
//        }
//        assertEquals(6, acc);
//
//    }
//
//
//    @Test
//    public void testz() {
//
//        public Set<String> findLongTracks (List < Album > albums) {
//            Set<String> trackNames = new HashSet<>();
//            for (Album album : albums) {
//                for (Track track : album.getTrackList()) {
//                    if (track.getLength() > 60) {
//                        String name = track.getName();
//                        trackNames.add(name);
//                    }
//                }
//            }
//            return trackNames;
//        }
//
//        public Set<String> findLongTracks (List < Album > albums) {
//            Set<String> trackNames = new HashSet<>();
//            albums.stream()
//                    .forEach(album -> {
//                        album.getTracks()
//                                .forEach(track -> {
//                                    if (track.getLength() > 60) {
//                                    });
//                                });
//                        return trackNames;
//                    }
//        }
//
//
//        public Set<String> findLongTracks (List < Album > albums) {
//            Set<String> trackNames = new HashSet<>();
//            albums.stream()
//                    .forEach(album -> {
//                        album.getTracks()
//                                .filter(track -> track.getLength() > 60)
//                                .map(track -> track.getName())
//                                .forEach(name -> trackNames.add(name));
//                    });
//            return trackNames;
//        }
//
//
//        public Set<String> findLongTracks (List < Album > albums) {
//            Set<String> trackNames = new HashSet<>();
//            albums.stream()
//                    .flatMap(album -> album.getTracks())
//                    .filter(track -> track.getLength() > 60)
//                    .map(track -> track.getName())
//                    .forEach(name -> trackNames.add(name));
//            return trackNames;
//        }
//
//        public Set<String> findLongTracks (List < Album > albums) {
//            return albums.stream()
//                    .flatMap(album -> album.getTracks())
//                    .filter(track -> track.getLength() > 60)
//                    .map(track -> track.getName())
//                    .collect(toSet());
//        }
//
//
//    }
