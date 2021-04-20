package cn.com.freemarker;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayUserCertifyOpenQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayUserCertifyOpenQueryResponse;

/**
 *
 */
public class Tsss {

    public static void main(String[] args) {
//
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
//
//        AlipayUserCertifyOpenQueryRequest request = new AlipayUserCertifyOpenQueryRequest();
//        request.setBizContent("{" +
//                "\"certify_id\":\"OC201809253000000393900404029253\"" +
//                "  }");
//        AlipayUserCertifyOpenQueryResponse response = alipayClient.execute(request);
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }


//        //构造client
//        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
//        certAlipayRequest.setServerUrl(gateway);
//        certAlipayRequest.setAppId(app_id);
//        certAlipayRequest.setPrivateKey(privateKey);
//        certAlipayRequest.setFormat("json");
//        certAlipayRequest.setCharset(charset);
//        certAlipayRequest.setSignType(sign_type);
//        certAlipayRequest.setCertPath(app_cert_path);
//        certAlipayRequest.setAlipayPublicCertPath(alipay_cert_path);
//        certAlipayRequest.setRootCertPath(alipay_root_cert_path);
//        DefaultAlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
//
////发送API请求
//        AlipayRequest request = new AlipayTradeQueryRequest();
//        AlipayTradeQueryResponse response =  alipayClient.certificateExecute(request);

    }
}