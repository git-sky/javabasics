package cn.com.java8.stream;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Stream创建方式
 */
public class CreateStream {

    @Test
    public void testEmpty() {
        //不包含任何元素的流
        Stream stream = Stream.empty();
        System.out.println(stream);
    }

    @Test
    public void testGenerate() {
        //无限流
        Stream<String> stream = Stream.generate(() -> "echo");
        System.out.println(stream);
        stream.forEach(System.out::println);
    }

    @Test
    public void testIterate() {
        //无限流
        Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        stream.forEach(System.out::println);
    }

    @Test
    public void testSetStream() {
        Set<Integer> set = new HashSet<>(Arrays.asList(3, 2, 1, 4));
        Stream<Integer> stream = set.stream();
        System.out.println(stream);
        List list = stream.filter(a -> a > 2).collect(Collectors.toList());

        System.out.println(list);
    }

    public static void main(String[] args) {
        System.out.println("========== list.stream ==========");
        createStreamFromCollection().forEach(System.out::println);
        System.out.println("========== Stream.of ==========");
        createStreamFromValues().forEach(System.out::println);
        System.out.println("========== Arrays.stream ==========");
        createStreamFromArrays().forEach(System.out::println);


        System.out.println("========== Files.lines ==========");
        Stream<String> streamFromFile = createStreamFromFile();
        System.out.println(streamFromFile);
//        streamFromFile.forEach(System.out::println);

        System.out.println("========== Stream.iterate ===========");
        createStreamFromIterator().forEach(System.out::println);

        System.out.println("========== Stream.generate ==========");
        createStreamFromGenerate().forEach(System.out::println);

        System.out.println("========== Stream.generate ==========");
        createObjStreamFromGenerate().forEach(System.out::println);
    }


    /**
     * Generate the stream object from collection.
     *
     * @return
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "alex", "my", "world", "stream");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "alex", "my", "world", "stream");
    }

    private static Stream<String> createStreamFromArrays() {
        String[] strings = {"hello", "alex", "my", "world", "stream"};
        return Arrays.stream(strings);
    }


    private static Stream<String> createStreamFromFile() {
//        Path path = Paths.get(getPath() + "/CreateStream.java");
        Path path = Paths.get("cn/com/java8/stream/CreateStream.java");
        try (Stream<String> streamFromFile = Files.lines(path)) {
            streamFromFile.forEach(System.out::println);
            return streamFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String path = CreateStream.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    private static Stream<Integer> createStreamFromIterator() {
        //裁剪无限流
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(10);
        return stream;
    }

    private static Stream<Double> createStreamFromGenerate() {
        //裁剪无限流
        return Stream.generate(Math::random).limit(10);
    }

    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    static class ObjSupplier implements Supplier<Obj> {
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name->" + index);
        }
    }

    static class Obj {
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
