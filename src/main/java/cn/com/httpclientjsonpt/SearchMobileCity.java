//package cn.com.sky.tools.httpclientjsonpt;
//
//import java.io.IOException;
//
//import org.apache.commons.httpclient.*;
//import org.apache.commons.httpclient.methods.*;
//
///**
// * 提交参数演示 该程序连接到一个用于查询手机号码所属地的页面 以便查询号码段1861041所在的省份以及城市
// *
// * @authorLiudong
// */
//
//// http://www.114best.com/dh/114.aspx?w=1861041
//
//public class SearchMobileCity {
//    public static void main(String[] args) throws IOException {
//        HttpClient client = new HttpClient();
//        client.getHostConfiguration().setHost("www.114best.com", 80, "http");
//        HttpMethod method = getPostMethod(); // 使用 POST 方式提交数据
//        client.executeMethod(method); // 打印服务器返回的状态
//        System.out.println(method.getStatusLine()); // 打印结果页面
//        String response = new String(method.getResponseBodyAsString().getBytes(
//                "ISO8859_1"));
//        // 打印返回的信息
//        System.out.println(response);
//        method.releaseConnection();
//    }
//
//    /**
//     * 使用 GET 方式提交数据
//     *
//     * @return
//     */
//    private static HttpMethod getGetMethod() {
//        return new GetMethod("/dh/114.aspx?w=1861041");
//    }
//
//    /**
//     * 使用 POST 方式提交数据
//     *
//     * @return
//     */
//    private static HttpMethod getPostMethod() {
//        PostMethod post = new PostMethod("/dh/114.aspx");
//        NameValuePair simcard = new NameValuePair("w", "1861041");
//        post.setRequestBody(new NameValuePair[]{simcard});
//        return post;
//    }
//}
