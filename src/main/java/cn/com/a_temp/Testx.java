package cn.com.a_temp;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class Testx {

    public static void main(String[] args) {
//        long x = 1;
//        String str = " 1 ";
//        Long userId = Long.valueOf(StringUtils.trim(str));
//        System.out.println(userId);
//        System.out.println(1 == userId);


        for (int i = 0; i <= 99; i++) {


            String s = "CREATE TABLE  if not exists  `pay_order_" + i + "` (\n " +
                    "  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
                    "  `plat` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT ' MT DP OTHER',\n" +
                    "  `uuid` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备唯一标识',\n" +
                    "  `user_id` bigint(20) NOT NULL COMMENT '用户id',\n" +
                    "  `order_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单id',\n" +
                    "  `order_amt` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单金额， 精确到分',\n" +
                    "  `timestamp` bigint(20) NOT NULL COMMENT '支付时间戳（ms)',\n" +
                    "  `order_source` int(4) NOT NULL COMMENT '订单渠道来源',\n" +
                    "  `item_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'poiId/dealId',\n" +
                    "  `item_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'deal/poi/waimai_poi product(到综泛商品）/movie/performance（演出）',\n" +
                    "  `bg` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '业务bg',\n" +
                    "  `bu` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '业务bu',\n" +
                    "  `class_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '一级品类id (后台品类体系）',\n" +
                    "  `category_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二级品类id (后台品类体系)',\n" +
                    "  `type_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '三级品类id (后台品类体系）',\n" +
                    "  `client_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户端类型： android/iphone/pc/other',\n" +
                    "  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                    "  `source` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '单据来源topic',\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE KEY `order_id_source` (`order_id`,`source`),\n" +
                    "  KEY `inx_order_id` (`order_id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单数据';";


            System.out.println(s);

        }

    }


}