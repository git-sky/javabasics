package cn.com.a_temp;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class sdfsadf {

    public static void main(String[] args) {

        String detailMessage = "mtthrift remote(10.24.105.82:8001) invoke($invoke), traceId:-7127282034312999719\n" +
                "                    // Exception:com.sankuai.game.center.core.api.thrift.exception.CommonBizException:CODE:2001022, DESC:授权码已过期\n" +
                "                    //#DetailMessage#CommonBizException(code=2001022, desc=授权码已过期, bizCause=)";

        String ex = null;
        if (StringUtils.isNotBlank(detailMessage)) {
            int beginIdx = detailMessage.indexOf("Exception:");
            if (beginIdx > 0) {
                int endIdx = detailMessage.indexOf(":", beginIdx + 10);
                if (endIdx > beginIdx + 10) {
                    ex = detailMessage.substring(beginIdx + 10, endIdx);
                }
            }
        }

        System.out.println("ex=" + ex);
    }
}