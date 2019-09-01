package cn.com.java8lambdasexercises.chapter4;


import cn.com.java8lambdasexercises.chapter1.Album;
import cn.com.java8lambdasexercises.chapter1.Track;

import java.util.List;

public class OrderImperative extends Order {

    public OrderImperative(List<Album> albums) {
        super(albums);
    }

    public long countRunningTime() {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }

    public long countMusicians() {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    public long countTracks() {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }


}
