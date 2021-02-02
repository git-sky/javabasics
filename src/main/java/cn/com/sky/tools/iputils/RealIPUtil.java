package cn.com.sky.tools.iputils;

import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *
 *   获取公网ip的正确姿势
 *
 * 这里不分在nginx上获取还是在业务的server获取用户公网ip。
 *
 * 1.使用remote_addr，如果拿到的直接就是公网ip，停止获取。
 *
 * 2.使用X-Real-IP字段，如果拿到的是公网地址，说明业务server与用户之间只有一层代理，拿到的就是用户的真实的可信任的ip，否则，拿到的是内网ip，说明有在离业务server最近的代理之前还有一层shark，跳到第三步，从可信任的XFF中获取ip。
 *
 * 3.获取http X-Forwarded-For请求头字段，该字段是以英文逗号空格隔开，拆开之后，从前往后遍历，第一个公网ip即是用户的公网ip，从后往前一个遍历，第一个公网ip就是之前X-Real-IP。
 *
 * 经过这三个步骤，能够确保业务或者nginx能拿到真实的可信任的用户ip。
 *
 *
 * </pre>
 */
public class RealIPUtil {
    public static String getUserIp(HttpServletRequest request) {
        String userIp = request.getRemoteAddr();

        if (isPublicIp(userIp)) {
            return userIp;
        }

        userIp = request.getHeader("X-Real-IP");

        if (isPublicIp(userIp)) {
            return userIp;
        }

        userIp = getFirstPublicIp(request.getHeader("X-Forwarded-For"));
        if (userIp != null) {
            return userIp;
        }

        return null;
    }

    private static String getFirstPublicIp(String proxyIps) {
        String[] proxyIpArray = null;

        if (proxyIps != null && !proxyIps.isEmpty()) {
            proxyIpArray = proxyIps.split(", ");
        }

        if (proxyIpArray != null) {
            for (String proxyIp : proxyIpArray) {
                if (isPublicIp(proxyIp)) {
                    return proxyIp;
                }
            }
        }
        return null;
    }

    private static boolean isPublicIp(String userIp) {
        return userIp != null && !userIp.isEmpty() && !isLocalIp(userIp) && !isInternalIp(userIp);
    }

    private static boolean isLocalIp(String userIp) {
        return "127.0.0.1".equals(userIp);
    }


    private static boolean isInternalIp(String ip) {
        byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
        return isInternalIp(addr);
    }


    /**
     * 内网地址范围,addr为null时候，默认为内网ip
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     *
     * @param addr
     * @return
     */
    private static boolean isInternalIp(byte[] addr) {
        if (addr == null) {
            return true;
        }
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        //10.0.0.0～10.255.255.255
        final byte SECTION_1 = 0x0A;
        //172.16.0.0～172.31.255.255
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        //192.168.0.0～192.168.255.255
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }
}