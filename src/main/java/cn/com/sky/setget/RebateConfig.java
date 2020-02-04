package cn.com.sky.setget;

import java.util.List;
import java.util.Map;

public class RebateConfig extends AbstractDynamicConfig {
    //动态开关
    private boolean rebateBoolean;
    private String rebateString;
    private Integer rebateInteger;
    private List<String> rebateList;
    private Map<String, String> rebateMap;

    public boolean getRebateBoolean() {
        return rebateBoolean;
    }

    public void setRebateBoolean(boolean rebateBoolean) {
        this.rebateBoolean = rebateBoolean;
    }

    public String getRebateString() {
        return rebateString;
    }

    public void setRebateString(String rebateString) {
        this.rebateString = rebateString;
    }

    public Integer getRebateInteger() {
        return rebateInteger;
    }

    public void setRebateInteger(Integer rebateInteger) {
        this.rebateInteger = rebateInteger;
    }

    public List<String> getRebateList() {
        return rebateList;
    }

    public void setRebateList(List<String> rebateList) {
        this.rebateList = rebateList;
    }

    public Map<String, String> getRebateMap() {
        return rebateMap;
    }

    public void setRebateMap(Map<String, String> rebateMap) {
        this.rebateMap = rebateMap;
    }

}