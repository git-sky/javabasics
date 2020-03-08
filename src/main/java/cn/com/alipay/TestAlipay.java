package cn.com.alipay;

import com.alipay.api.internal.util.AlipaySignature;

import java.util.UUID;


public class TestAlipay {

    public static void main(String[] args) {

        final String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid.length());
        System.out.println("uuid = " + uuid);
    }
}