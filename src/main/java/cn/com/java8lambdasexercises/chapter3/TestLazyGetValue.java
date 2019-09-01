package cn.com.java8lambdasexercises.chapter3;

import cn.com.java8lambdasexercises.chapter1.Artist;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * 惰性求值
 */
public class TestLazyGetValue {
    @Test
    public void testLazy() {

        Artist johnLennon = new Artist("John Lennon", "UK");
        Artist paulMcCartney = new Artist("Paul McCartney", "UK");
        Artist georgeHarrison = new Artist("George Harrison", "UK");
        Artist ringoStarr = new Artist("Ringo Starr", "UK");

        List<Artist> allArtists = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

//        由于使用了惰性求值，没有输出艺术家的名字;运行这段代码，程序不会输出任何信息!
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });

//        如果将同样的输出语句加入一个拥有终止操作的流，艺术家的名字就会被输出。
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();


    }

}