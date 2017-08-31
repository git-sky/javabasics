package cn.com.sky.tools.httpclient.post;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sky.tools.diamond.ReloadableConfig;

import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 *     businessName（短信平台分配的）
 *     userId（用户ID）
 *     templateId（模板ID）
 *     parameter（短信模板中参数和值）
 *
 * </pre>
 */
public class SmsUtil {

    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);


    private static String url = ReloadableConfig.getString("smsAddressHttp");
    private static String businessName = ReloadableConfig.getString("businessName");
    private static String templateId = ReloadableConfig.getString("templateId");


    /**
     * @param userId 收短信的useid
     * @param amount 返利金额
     * @return
     * @throws Exception
     */
    public static void sendSms(String userId, String amount) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        HttpClient client = new DefaultHttpClient();

        // 短信模板中参数和值
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("money", amount);

        // 表单方式
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("businessName", businessName));
        pairList.add(new BasicNameValuePair("templateId", templateId));
        pairList.add(new BasicNameValuePair("userId", userId));
        pairList.add(new BasicNameValuePair("parameter", jsonParam.toString()));
        UrlEncodedFormEntity entry = new UrlEncodedFormEntity(pairList, "utf-8");
        httpPost.setEntity(entry);

        HttpResponse resp = client.execute(httpPost);
        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity respEntity = resp.getEntity();
            String result = EntityUtils.toString(respEntity, "UTF-8");
            JSONObject json = JSONObject.parseObject(result);
            Boolean success = json.getBoolean("success");
            String message = json.getString("message");
            Integer code = json.getInteger("code");
            if (success) {
                logger.info("Send sms success!!! userId:{},amount:{}", userId, amount);
            } else {
                logger.error("Send sms failed!!! userId:{},amount:{},result:{}", userId, amount, result);
            }
        } else {
            logger.error("Send sms failed!!! userId:{},amount:{},statusCode:{}", userId, amount, resp.getStatusLine().getStatusCode());
        }
    }
}
