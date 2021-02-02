package cn.com.a_temp;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: sky
 * @Date: 2020/4/10 17:00
 */
public class Testc {

    public static void main(String[] args) {
        String s = "#XMDJ#{\"api_name\":\"/api/v1/fe/exchange/queryMoney\",\"app\":\"mgc-gateway\",\"client_ip\":\"0:0:0:0:0:0:0:1\",\"request_content\":\"[{\\\"accessToken\\\":\\\"\\\",\\\"clientId\\\":\\\"\\\",\\\"mgcId\\\":1247818626254241890,\\\"token\\\":\\\"38AgQAThwZIldHvRroIK976Py44AAAAAGkkBAJ2YD9DwEj1i8YGAws5P-JSqbDDlQ3ps-U9C5Y14gfmn6W9IDlzhDa5c0PJpUJIJYA\\\"}]\",\"response_content\":\"{\\\"code\\\":0,\\\"data\\\":{1:\\\"0\\\"},\\\"msg\\\":\\\"ok\\\"}\",\"result_code\":\"1\",\"timestamp\":1586509087439,\"userid\":\"37381287\",\"visit_time\":\"2020-04-10 16:58:07\"}#XMDJ#";

        System.out.println(s.length());


        System.out.println(StringUtils.countMatches("中国人民共和中国", "中国"));

    }
}