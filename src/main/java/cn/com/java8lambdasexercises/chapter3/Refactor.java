package cn.com.java8lambdasexercises.chapter3;


import cn.com.java8lambdasexercises.chapter1.Album;
import cn.com.java8lambdasexercises.chapter1.Track;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * 重构： 找出长度大于 1 分钟的曲目
 */
public class Refactor {

    //旧代码
    public void test() {
        Set<String> trackNames = new HashSet<>();
        List<Album> albums = Lists.newArrayList();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
    }

    //重构第一步
    @Test
    public void test1() {
        Set<String> trackNames = new HashSet<>();
        List<Album> albums = Lists.newArrayList();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if (track.getLength() > 60) {
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
    }

    //重构第二步
    @Test
    public void test2() {
        Set<String> trackNames = new HashSet<>();
        List<Album> albums = Lists.newArrayList();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .filter(track -> track.getLength() > 60)
                            .map(track -> track.getName())
                            .forEach(name -> trackNames.add(name));
                });
    }

    //重构第三步
    @Test
    public void test3() {
        Set<String> trackNames = new HashSet<>();
        List<Album> albums = Lists.newArrayList();
        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
    }

    //重构第四步
    public void test4() {
        List<Album> albums = Lists.newArrayList();
        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());
    }
}
