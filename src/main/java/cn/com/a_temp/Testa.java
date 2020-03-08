package cn.com.a_temp;


import com.alipay.api.DefaultAlipayClient;
import com.google.common.collect.Maps;

import javax.crypto.KeyGenerator;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class Testa {

//    public static void main(String[] args) {
//        LocalDateTime now = Instant.ofEpochMilli(DateUtils.getTimeInMills()).atZone(ZoneId.systemDefault()).toLocalDateTime();
//        Duration duration = Duration.between(now, now.toLocalDate().atStartOfDay().plusDays(1));
//        System.out.println((int) duration.getSeconds());
//    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String[]> parameterMap = Maps.newHashMap();

        //遍历
        for (Iterator iter = parameterMap.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry element = (Map.Entry) iter.next();
            //key值
            Object strKey = element.getKey();
            //value,数组形式
            String[] value = (String[]) element.getValue();

            System.out.print(strKey.toString() + "=");
            for (int i = 0; i < value.length; i++) {
                System.out.print(value[i] + ",");
            }
            System.out.println();


            System.out.println(map);
        }

        System.out.println(UUID.randomUUID());




    }
}