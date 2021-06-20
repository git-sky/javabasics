package cn.com.sky.property_copy.beancopy;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    /**
     * C订单渠道
     */
    private Integer channel;

    /**
     * b订单渠道
     */
    private Integer bNchannel;

    public Integer getChannel() {
        return channel;
    }
    public void setChannel(Integer channel) {
        this.channel = channel;
    }
    public Integer getbNchannel() {
        return bNchannel;
    }
    public void setbNchannel(Integer bNchannel) {
        this.bNchannel = bNchannel;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
