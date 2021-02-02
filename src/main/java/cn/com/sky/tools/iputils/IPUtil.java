
package cn.com.sky.tools.iputils;

import com.google.common.collect.Sets;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import sun.net.util.IPAddressUtil;

public class IPUtil {
    private static final Logger LOG = LoggerFactory.getLogger(IPUtil.class);
    private static final String MTSSO_WHITEIPS = "mtsso.whiteips";
    private static final String MTSSO_WHITEIPV6S = "mtsso.whiteipv6s";
    private static Set<String> DEFAULT_IPV4_IPS = Sets.newHashSet(new String[]{"106.120.108.32-106.120.108.63", "119.253.36.48-119.253.36.63", "119.254.241.64-119.254.241.79", "218.97.248.0-218.97.248.15", "124.65.158.40/30", "111.207.124.64/26", "110.249.213.32/28", "192.168.*.*", "127.0.0.1", "172.16.0.0/12", "10.*.*.*", "211.151.229.*", "58.83.134.*", "106.3.46.0/27", "172.30.0.0/16", "172.16.220.0/24", "103.37.140.0/26", "58.135.78.62", "222.223.204.194-222.223.204.203", "111.200.192.0-111.200.192.15", "111.200.192.15/28", "121.28.51.57", "121.28.51.58/30", "121.28.51.59-121.28.51.62", "218.107.201.146-218.107.201.158", "120.42.46.74-120.42.46.78", "124.251.11.36", "124.251.11.37", "124.250.28.18", "124.250.28.22", "103.37.138.10", "103.37.138.14", "106.39.80.150", "106.39.80.151"});
    public static final Set<String> DEFAULT_IPV6_IPS = Sets.newHashSet(new String[]{"240E:83:0201:0F00::/56", "240e:83:201:d00::2/56", "240e:83:201:e00::2/56", "2408:80F1:0100:1100:8000::/65", "2408:80f1:100:1100::a/126", "2408:80f1:100:1100::6/126", "240E:83:0201:1100::/64", "2405:1480:0:1::177:8b/127", "2405:1480:0:1::177:16b/127", "2405:1480:0:1::177:12b/127", "2405:1480:0:1::177:20b/127", "2405:1480:0:1::177:32b/127", "2405:1480:0:1::33:112b/127", "240e:83:201:1010::2/128", "2405:1480:0:1::177:24b/127", "2405:1480:0:1::177:28b/127"});
    private static final HashMap<String, String> hex2BinHash = new HashMap(16);
    private static Set<String> ipv4s;
    private static Set<String> ipv6s;
    private static AntPathMatcher matcher;

    public IPUtil() {
    }

    private static Set<String> getIpv4s() {
        return ipv4s;
    }

    private static Set<String> getIpv6s() {
        return ipv6s;
    }

    private static Set<String> getIpsfromConfig(String key) {
        LinkedHashSet<String> confIps = Sets.newLinkedHashSet();
        return confIps;
    }

    public static boolean isInner(String ip) {
        if (StringUtil.isBlank(ip)) {
            LOG.warn("empty ip");
            return false;
        } else {
            boolean isIpv4 = IPAddressUtil.isIPv4LiteralAddress(ip);
            String[] ips = isIpv4 ? (String[]) getIpv4s().toArray(new String[getIpv4s().size()]) : (String[]) getIpv6s().toArray(new String[getIpv6s().size()]);
            boolean checkIp = checkIp(ip, ips);
            if (!checkIp) {
                String key = isIpv4 ? "mtsso.whiteips" : "mtsso.whiteipv6s";
                Set<String> conips = getIpsfromConfig(key);
                String[] array = (String[]) conips.toArray(new String[conips.size()]);
                return checkIp(ip, array);
            } else {
                return true;
            }
        }
    }

    public static boolean checkIp(String ip, String[] ips) {
        if (StringUtil.isBlank(ip)) {
            LOG.warn("empty ip");
            return false;
        } else {
            return IPAddressUtil.isIPv4LiteralAddress(ip) ? checkIpV4(ip, ips) : checkIpV6(ip, ips);
        }
    }

    private static boolean checkIpV4(String ip, String[] ips) {
        String[] ipArray = ips;
        int ipLength = ips.length;

        for (int i = 0; i < ipLength; ++i) {
            String range = ipArray[i];
            LOG.debug("check " + range + "," + ip);
            if (range.contains("/") && netMatch(range, ip)) {
                return true;
            }

            if (range.contains("*") && matcher.match(range, ip)) {
                return true;
            }

            if (range.contains("-")) {
                String[] regions = range.split("-");
                if (regions.length != 2) {
                    LOG.warn("illegal range " + range);
                } else {
                    LOG.debug("isInner " + ip + "," + regions[0] + "," + regions[1]);
                    long begin = getIpNum(regions[0]);
                    long end = getIpNum(regions[1]);
                    if (isInner(getIpNum(ip), begin, end)) {
                        return true;
                    }
                }
            } else if (range.equalsIgnoreCase(ip)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkIpV6(String ip, String[] ips) {
        if (!isIPv6(ip)) {
            return false;
        } else {
            String[] ipArray = ips;
            int ipLength = ips.length;

            for (int i = 0; i < ipLength; ++i) {
                String ip1 = ipArray[i];
                if (isIPv6(ip1)) {
                    if (ip1.contains("/")) {
                        if (compareIpv6Mask(ip, getMask(ip1), ip1)) {
                            return true;
                        }
                    } else if (compareIpv6(ip, ip1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private static boolean netMatch(String subnet, String addr) {
        String[] parts = subnet.split("/");
        String ip = parts[0];
        int prefix;
        if (parts.length < 2) {
            prefix = 0;
        } else {
            prefix = Integer.parseInt(parts[1]);
        }

        Inet4Address a = null;
        Inet4Address a1 = null;
        try {
            a = (Inet4Address) InetAddress.getByName(ip);
            a1 = (Inet4Address) InetAddress.getByName(addr);
        } catch (UnknownHostException var13) {

        }

        byte[] b = a.getAddress();
        int ipInt = (b[0] & 255) << 24 | (b[1] & 255) << 16 | (b[2] & 255) << 8 | b[3] & 255;
        byte[] b1 = a1.getAddress();
        int ipInt1 = (b1[0] & 255) << 24 | (b1[1] & 255) << 16 | (b1[2] & 255) << 8 | b1[3] & 255;
        int mask = ~((1 << 32 - prefix) - 1);
        return (ipInt & mask) == (ipInt1 & mask);
    }

    public static long getIpNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = (long) Integer.parseInt(ip[0]);
        long b = (long) Integer.parseInt(ip[1]);
        long c = (long) Integer.parseInt(ip[2]);
        long d = (long) Integer.parseInt(ip[3]);
        return a * 256L * 256L * 256L + b * 256L * 256L + c * 256L + d;
    }

    private static boolean isInner(long userIp, long begin, long end) {
        LOG.debug("isInner " + userIp + "," + begin + "," + end);
        return userIp >= begin && userIp <= end;
    }

    public static boolean isIP(String ip) {
        return isIPv4(ip) || isIPv6(ip);
    }

    public static boolean isIPv4(String ip) {
        String isIPv4 = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d|\\*)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d|\\*)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d|\\*)(/([1-9]|(1|2)[0-9]|3[0-2]))?$";
        return ip.matches(isIPv4);
    }

    public static boolean isIPv6(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        } else if (!ip.contains("/")) {
            return IPAddressUtil.isIPv6LiteralAddress(ip);
        } else {
            String[] ipSplit = ip.split("/");
            int mask = Integer.valueOf(ipSplit[1]);
            return IPAddressUtil.isIPv6LiteralAddress(ipSplit[0]) && mask > 0 && mask <= 128;
        }
    }

    public static String getRealIp(HttpServletRequest request) {
        String ip = head(request, "X-Real-IP");
        if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        } else {
            ip = head(request, "X-Forwarded-For");
            if (ip != null) {
                int index = ip.indexOf(44);
                return index != -1 ? ip.substring(0, index) : ip;
            } else {
                ip = request.getHeader("Proxy-Client-IP");
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("WL-Proxy-Client-IP");
                }

                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getRemoteAddr();
                }

                return ip == null ? "unkown" : ip;
            }
        }
    }

    private static String head(HttpServletRequest req, String s) {
        return req.getHeader(s);
    }

    public static boolean isLocalIp(String ip) {
        return ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1") || ip.equals("::1");
    }

    public static String getHost(HttpServletRequest request) {
        String host = request.getHeader("X-Forwarded-Host");
        if (host == null) {
            host = request.getHeader("Host");
        }

        return host;
    }

    public static boolean compareIpv6(String ipv61, String ipv62) {
        return isIP(ipv61) && isIP(ipv62) ? convert2CompleteIPV6(ipv61).equals(convert2CompleteIPV6(ipv62)) : false;
    }

    public static boolean compareIpv6Mask(String ip, int mask, String range) {
        ArrayList<String> maskList = bin2hex(mask);
        String[] ipv6 = convert2CompleteIPV6(ip).split(":");
        String[] rangeIP = convert2CompleteIPV6(range).split(":");

        for (int i = 0; i < 8; ++i) {
            if ((Integer.valueOf(ipv6[i], 16) & Integer.valueOf((String) maskList.get(i), 16)) != (Integer.valueOf(rangeIP[i], 16) & Integer.valueOf((String) maskList.get(i), 16))) {
                return false;
            }
        }

        return true;
    }

    public static String convert2CompleteIPV6(String ip) {
        if (!isIP(ip)) {
            return ip;
        } else {
            if (ip.contains("/")) {
                ip = ip.split("/")[0];
            }

            int index = ip.indexOf(":");
            String ipv6;
            int i;
            if (index > 0) {
                int size = 8 - (ip.split(":").length - 1);
                String tmp = "";

                for (i = 0; i < size; ++i) {
                    tmp = tmp + ":0000";
                }

                tmp = tmp + ":";
                ipv6 = ip.replaceAll("::", tmp);
            } else if (index == 0) {
                ipv6 = "0000:0000:0000:0000:0000:0000:0000:0000";
            } else {
                ipv6 = ip.replace("::", "0000:0000:0000:0000:0000:0000:0000:");
            }

            String[] ipv6List = ipv6.split(":");
            StringBuilder result = new StringBuilder();

            for (i = 0; i < 8; ++i) {
                if (7 == i) {
                    if (ipv6List[i].length() != 4) {
                        result.append(StringUtils.leftPad(ipv6List[i], 4, '0'));
                    } else {
                        result.append(ipv6List[i]);
                    }
                } else if (ipv6List[i].length() != 4) {
                    result.append(StringUtils.leftPad(ipv6List[i], 4, '0') + ":");
                } else {
                    result.append(ipv6List[i] + ":");
                }
            }

            return result.toString();
        }
    }

    public static int getMask(String ip) {
        return isIP(ip) && ip.contains("/") ? Integer.valueOf(ip.split("/")[1]) : 0;
    }

    private static ArrayList<String> bin2hex(int mask) {
        String value = "";
        ArrayList<String> list = new ArrayList();
        String str = "";
        int i;
        if (mask != 0) {
            for (i = 0; i < mask; ++i) {
                str = str + "1";
            }

            for (i = 0; i < 128 - mask; ++i) {
                str = str + "0";
            }
        }

        while (str.length() > 4) {
            list.add(str.substring(0, 4));
            str = str.substring(4);
        }

        list.add(str);

        for (i = 0; i < list.size(); ++i) {
            Iterator var5 = hex2BinHash.entrySet().iterator();

            while (var5.hasNext()) {
                Entry<String, String> e = (Entry) var5.next();
                if (((String) list.get(i)).equals(e.getValue())) {
                    value = value.concat((String) e.getKey());
                    break;
                }
            }
        }

        ArrayList valArr;
        for (valArr = new ArrayList(); value.length() > 4; value = value.substring(4)) {
            valArr.add(value.substring(0, 4));
        }

        valArr.add(value);
        return valArr;
    }

    static {
        hex2BinHash.put("0", "0000");
        hex2BinHash.put("1", "0001");
        hex2BinHash.put("2", "0010");
        hex2BinHash.put("3", "0011");
        hex2BinHash.put("4", "0100");
        hex2BinHash.put("5", "0101");
        hex2BinHash.put("6", "0110");
        hex2BinHash.put("7", "0111");
        hex2BinHash.put("8", "1000");
        hex2BinHash.put("9", "1001");
        hex2BinHash.put("A", "1010");
        hex2BinHash.put("B", "1011");
        hex2BinHash.put("C", "1100");
        hex2BinHash.put("D", "1101");
        hex2BinHash.put("E", "1110");
        hex2BinHash.put("F", "1111");
        ipv4s = Collections.synchronizedSet(new HashSet());
        ipv6s = Collections.synchronizedSet(new HashSet());
        ipv4s.addAll(DEFAULT_IPV4_IPS);
        ipv6s.addAll(DEFAULT_IPV6_IPS);
        matcher = new AntPathMatcher();
    }
}
