package cn.com.sky.tools.iputils;

/**
 * 实用工具类
 * <p>
 * 判断ip是否在某个网段中。
 */
public class IPUtils {


    public static void main(String[] args) {
        System.out.println(isIpInRangeByMask("10.153.48.127", "10.153.48.0/26"));
        System.out.println(isIpInRangeByMask("10.168.1.2", "10.168.0.224/23"));
        System.out.println(isIpInRangeByMask("192.168.0.1", "192.168.0.0/24"));
        System.out.println(isIpInRangeByMask("10.168.0.0", "10.168.0.0/32"));

        System.out.println(isIpInRangeBySection("10.153.48.127", "10.153.48.1-10.153.48.0.62"));
        System.out.println(isIpInRangeBySection("10.168.1.2", "10.168.0.1-10.168.1.254"));
        System.out.println(isIpInRangeBySection("192.168.0.1", "192.168.0.1-192.168.0.254"));
        System.out.println(isIpInRangeBySection("10.168.0.0", "10.168.0.0-10.168.0.0"));

    }


    /**
     * 判断某个ip是否在一个网段内 isIpInRangeByMask("192.168.1.127", "192.168.1.64/26")
     *
     * @param testIp 需判断的IP
     * @param cidr   ip网段
     * @return boolean
     */
    public static boolean isIpInRangeByMask(String testIp, String cidr) {
        String[] ips = testIp.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24)
                | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8)
                | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24)
                | (Integer.parseInt(cidrIps[1]) << 16)
                | (Integer.parseInt(cidrIps[2]) << 8)
                | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
    }


    /**
     * 判断某个IP是否在一个IP网段内
     *
     * @param testIp    需判断的IP
     * @param ipSection IP网段，以“-”连接的两个IP地址
     * @return
     */
    public static boolean isIpInRangeBySection(String testIp, String ipSection) {
        ipSection = ipSection.trim();
        testIp = testIp.trim();
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
        if (!ipSection.matches(REGX_IPB) || !testIp.matches(REGX_IP)) {
            return false;
        }
        int idx = ipSection.indexOf('-');
        String[] sips = ipSection.substring(0, idx).split("\\.");
        String[] sipe = ipSection.substring(idx + 1).split("\\.");
        String[] sipt = testIp.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; i++) {
            ips = ips << 8 | Integer.parseInt(sips[i]);
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }


}