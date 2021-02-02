package cn.com.sky.tools.iputils;

/**
 * IPV6子网计算工具.
 * Created by sofical on 2020/6/24.
 */
public class Ipv6SubnetRangeUtils {
    /**
     * 子网范围计算.
     * @param sourceIp ip + "/" + 子网位数.
     * @return String[] {起启IP, 结束IP}
     */
    public static String[] computeRange(String sourceIp) {
        //兼容windows表示格式
        sourceIp = sourceIp.replace("%", "/");
        sourceIp = Ipv6FormatUtils.formatToExtend(sourceIp);
        String ipArr[] = sourceIp.split("/");

        //IP部分(扩展格式).
        String ipPart = ipArr[0];

        //计算需要处理的网段和网位
        Integer maskNumber = Integer.valueOf(ipArr[1]);
        Integer dealColumnNumber = maskNumber / 16;
        Integer netNumber = maskNumber % 16;

        //计算前段
        String pre = "";
        Integer i = 0;
        String[] columnArr = ipPart.split(":");
        for (String ipColumn : columnArr) {
            if (i < dealColumnNumber) {
                ipColumn = "0000" + ipColumn;
                ipColumn = ipColumn.substring(ipColumn.length() - 4);
                pre += ("".equals(pre) ? "" : ":") + ipColumn;
                i++;
            }
        }
        //起始地址
        String startIp = pre;
        //结束地址
        String endIp = pre;

        //需要计算的段
        if (dealColumnNumber < 7) {
            String computeColumn = columnArr[dealColumnNumber];
            String binC = Ipv6Helper.c16To2(computeColumn);
            String startB = "";
            String endB = "";
            for (int m=0; m<16; m++) {
                if (m < netNumber) {
                    String bin = binC.substring(m, m + 1);
                    startB += bin;
                    endB += bin;
                } else {
                    startB += "0";
                    endB += "1";
                }
            }

            startIp += ("".equals(startIp) ? "" : ":") + Ipv6Helper.c2To16(startB);
            endIp += ("".equals(endIp) ? "" : ":") + Ipv6Helper.c2To16(endB);
        }

        //计算尾部段
        Integer appendNumber = 7 - i;
        if (appendNumber > 0) {
            for (int n = 0; n < appendNumber; n++) {
                startIp += ("".equals(startIp) ? "" : ":") + "0000";
                endIp += ("".equals(endIp) ? "" : ":") + "ffff";
            }
        }

        return new String[] {startIp, endIp};
    }

    /**
     * 通过起始和终止IP计算子网值.
     * @param startIp 起始IP.
     * @param endIp 终止IP.
     * @return 子网值.
     */
    public static Integer getSubnetFromRange(String startIp, String endIp) {
        //先将IP转为扩展模式
        startIp = Ipv6FormatUtils.formatToExtend(startIp);
        endIp = Ipv6FormatUtils.formatToExtend(endIp);


        //计算差异位
        String[] startIpArr = startIp.split(":");
        String[] endIpArr = endIp.split(":");
        int i;
        for (i = 0; i < 8; i++) {
            if (!startIpArr[i].equals(endIpArr[i])) {
                break;
            }
        }

        //基础值
        Integer baseArr[] = new Integer[] {0, 16, 32, 48, 64, 80, 96, 112};
        Integer base = baseArr[i];


        //计算差异段网位
        String binStart = Ipv6Helper.c16To2(startIpArr[i]);
        String binEnd = Ipv6Helper.c16To2(endIpArr[i]);
        int m;
        for (m = 0; m < 16; m++) {
            String charStart = binStart.substring(m, m+1);
            String charEnd = binEnd.substring(m, m+1);
            if (!charStart.equals(charEnd)) {
                break;
            }
        }

        return base + m;
    }

    public static void main(String[] args) {
        String test = "fe80::/51";
        String[] range = computeRange(test);
        System.out.print("start ip: ");
        System.out.println(range[0]);
        System.out.print("end ip: ");
        System.out.println(range[1]);
        Integer subnet = getSubnetFromRange(range[0], range[1]);
        System.out.print("subnet: ");
        System.out.println(subnet);
    }
}
