package cn.com.fileds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
public class UserTaskReq extends BaseReq {

    /**
     * mgcId
     */
    private Long mgcId;

    /**
     * 同mgcId
     */
//    private String mgcIdStr;


    /**
     * 任务Id
     */
    private Integer taskId;

    /**
     * 扩展字段
     */
    private String extraInfo;

    private String extraInfo_cityId;
    private String extraInfo_referer;
    private String extraInfo_channel;

}