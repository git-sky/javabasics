package cn.com.log_pattern;


public class PoiService {

    //仅包含业务逻辑
    public LogModel update() {
        //TODO 业务逻辑
        return null;
    }

    //包含业务逻辑+日志处理
    public void updateInnerLog() {
        //1、TODO 业务逻辑
        //2、TODO 记录日志
    }
}