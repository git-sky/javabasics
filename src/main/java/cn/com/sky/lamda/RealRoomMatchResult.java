package cn.com.sky.lamda;


import java.util.Date;


public class RealRoomMatchResult {

    private Integer realRoomId;

    private String realRoomName;

    private Integer matchType;

    private Integer operatorId;

    private String operatorName;

    private Date operatorTime;


    public RealRoomMatchResult(Integer realRoomId) {
        this.realRoomId = realRoomId;
    }

    public Integer getRealRoomId() {
        return realRoomId;
    }

    public void setRealRoomId(Integer realRoomId) {
        this.realRoomId = realRoomId;
    }

    public String getRealRoomName() {
        return realRoomName;
    }

    public void setRealRoomName(String realRoomName) {
        this.realRoomName = realRoomName;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }
}
