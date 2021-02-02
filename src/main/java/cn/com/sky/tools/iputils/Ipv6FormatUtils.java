package cn.com.sky.tools.iputils;


/**
 * ipv6 address formatter.
 * Created by sofical on 2020/6/24.
 */
public class Ipv6FormatUtils {
    /**
     * 将任意一个ipv6地址转换成扩展格式.
     * @param sourceIp 源IP.
     * @return 扩展格式ipv6地址.
     */
    public static String formatToExtend(String sourceIp) {
        String[] columnArr = sourceIp.split("::");
        String behindPart = "";
        Integer behindColumnCount = 0;
        if (columnArr.length > 1) {
            behindPart = columnArr[1];
            String[] behindPartArr = behindPart.split(":");
            behindColumnCount = behindPartArr.length;
            if (behindPart.startsWith("/")) {
                behindPart = ":0000" + behindPart;
            } else {
                behindPart = ":" + behindPart;
            }
        }

        String prePart = columnArr[0] + ":0000:0000:0000:0000:0000:0000:0000:0000";
        String[] prePartArr = prePart.split(":");
        int i = 0;
        String preIp = "";
        for (String preColumn : prePartArr) {
            if (i < (8 - behindColumnCount)) {
                preColumn = "0000" + preColumn;
                preColumn = preColumn.substring(preColumn.length() -4);
                preIp += ("".equals(preIp) ? "" : ":") + preColumn;
            }
            i++;
        }

        return preIp + behindPart;
    }

    /**
     * 将任意一个ipv6地址转换为8位简写地址（姑且称为标准地址）.
     * @param sourceIp 源IP.
     * @return 8位简写ipv6地址.
     */
    public static String formatToStandard(String sourceIp) {
        String ipExtend = formatToExtend(sourceIp);
        ipExtend = ipExtend.replaceAll(":0000", ":0");
        ipExtend = ipExtend.replaceAll("0000:", "0:");
        return ipExtend;
    }

    /**
     * 将任意一个ipv6地址转成压缩地址.
     * @param sourceIp 源IP.
     * @return 压缩ipv6地址.
     */
    public static String formatToCompress(String sourceIp) {
        String ipExtend = formatToExtend(sourceIp);
        String ipStandard = formatToStandard(ipExtend);
        ipStandard = loopReplace(ipStandard,":0:", "::");
        ipStandard = loopReplace(ipStandard,":0/", "::/");
        ipStandard =  loopReplace(ipStandard,":::", "::");
        return ipStandard;
    }

    private static String loopReplace(String source, String search, String replace) {
        source = source.replaceAll(search, replace);
        if (source.indexOf(search) > -1) {
            source = loopReplace(source, search, replace);
        }
        return source;
    }


    public static void main(String[] args) {
//        String testIp = "15ba:db5::/64";
        //String testIp = "2409::7c00:bd5f:14b3:376e:e97d";
        String testIp = "2001:DB8:0:23:8:800:0:417A";
        String ipExtend = formatToExtend(testIp);
        System.out.println(ipExtend);

        String standardIp = formatToStandard(ipExtend);
        System.out.println(standardIp);

        String compressIp = formatToCompress(standardIp);
        System.out.println(compressIp);

//        　2001:0DB8:0000:0023:0008:0800:200C:417A→ 2001:DB8:0:23:8:800:200C:417A
    }
}
