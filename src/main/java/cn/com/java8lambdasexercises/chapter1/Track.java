package cn.com.java8lambdasexercises.chapter1;

/**
 * 专辑中的一支曲目
 */
public final class Track {

    /**
     * 曲目名称
     */
    private final String name;
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }


    public String getName() {
        return name;
    }


    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
