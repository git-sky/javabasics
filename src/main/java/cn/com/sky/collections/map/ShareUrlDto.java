package cn.com.sky.collections.map;


public class ShareUrlDto {


    private static final long serialVersionUID = 819911030602510612L;


    private String level;

    private String from;

    private String time;

    private String userid;

    private String mark;

    private String rowKey;//hbaseRowKey

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }


    public ShareUrlDto(String rowKey) {
        setRowKey(rowKey);
    }

    public ShareUrlDto() {
        this(null);
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
