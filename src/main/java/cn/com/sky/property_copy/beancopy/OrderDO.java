package cn.com.sky.property_copy.beancopy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class OrderDO implements Serializable {

    /**
     * C订单渠道
     */
    private Integer channel;

    /**
     * b订单渠道
     */
    private Integer bNchannel;

}