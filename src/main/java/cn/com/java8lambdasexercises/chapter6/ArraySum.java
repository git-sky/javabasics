//package cn.com.java8lambdasexercises.chapter6;
//
//
//
//import org.openjdk.jmh.Main;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.runner.RunnerException;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import static java.util.stream.Collectors.groupingBy;
//import static java.util.stream.Collectors.toList;
//
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//public class ArraySum {
//
//    public static void main(String[] ignore) throws IOException, RunnerException {
//        final String[] args = {
//            ".*ArraySum.*",
//            "-wi",
//            "5",
//            "-i",
//            "5"
//        };
//        Main.main(args);
//    }
//
//    public List<Album> albums;
//
//    @Setup
//    public void initAlbums() {
//        int n = Integer.getInteger("arraysum.size", 1000);
//        albums = IntStream.range(0, n)
//                          .mapToObj(i -> SampleData.aLoveSupreme.copy())
//                          .collect(toList());
//    }
//
//    @GenerateMicroBenchmark
//
//public int serialArraySum() {
//    return albums.stream()
//                 .flatMap(Album::getTracks)
//                 .mapToInt(Track::getLength)
//                 .sum();
//}
//
//
//    @GenerateMicroBenchmark
//
//public int parallelArraySum() {
//    return albums.parallelStream()
//                 .flatMap(Album::getTracks)
//                 .mapToInt(Track::getLength)
//                 .sum();
//}
//
//
//}
