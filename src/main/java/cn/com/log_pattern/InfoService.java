package cn.com.log_pattern;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 记录日志的两种模式：
 * 1、业务逻辑中，直接包含了日志的处理。
 * 2、先业务逻辑，后统一记录日志。
 */
public class InfoService {

    private PoiService poiService;
    private RoomService roomService;
    private LogService logService;

    // 1、业务逻辑中，直接包含了日志的处理。
    public void updateInnerLog() {
        poiService.updateInnerLog();
        roomService.updateInnerLog();
    }

    //    2、先业务逻辑，后统一记录日志。
    public void updateAndLog() {
        List<LogModel> list = Lists.newArrayList();
        //先业务逻辑
        LogModel poiLog = poiService.update();
        LogModel roomLog = roomService.update();
        //后统一记录日志
        list.add(poiLog);
        list.add(roomLog);
        logService.insert(list);
    }

}