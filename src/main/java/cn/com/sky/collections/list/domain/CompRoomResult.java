package cn.com.sky.collections.list.domain;

public class CompRoomResult {

    private Integer siteId;

    private String compRoomName;

    private Long compRoomId;

    private Integer compRoomMatchResult;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getCompRoomName() {
        return compRoomName;
    }

    public void setCompRoomName(String compRoomName) {
        this.compRoomName = compRoomName;
    }

    public Long getCompRoomId() {
        return compRoomId;
    }

    public void setCompRoomId(Long compRoomId) {
        this.compRoomId = compRoomId;
    }

    public Integer getCompRoomMatchResult() {
        return compRoomMatchResult;
    }

    public void setCompRoomMatchResult(Integer compRoomMatchResult) {
        this.compRoomMatchResult = compRoomMatchResult;
    }

    @Override
    public String toString() {
        return "CompRoomResult{" +
                "siteId=" + siteId +
                ", compRoomName='" + compRoomName + '\'' +
                ", compRoomId=" + compRoomId +
                ", compRoomMatchResult=" + compRoomMatchResult +
                '}';
    }
}
