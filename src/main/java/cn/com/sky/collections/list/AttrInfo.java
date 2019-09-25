package cn.com.sky.collections.list;

public class AttrInfo {

    private Integer attrId;

    private String attrName;

    public AttrInfo() {
    }

    public AttrInfo(Integer attrId, String attrName) {
        this.attrId = attrId;
        this.attrName = attrName;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public String toString() {
        return "AttrInfo{" +
                "attrId=" + attrId +
                ", attrName='" + attrName + '\'' +
                '}';
    }
}
