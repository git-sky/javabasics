package cn.com.sky.tools.json.jackson.tree;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class TestTree {


    @Test
    public void test() throws IOException {

        String content = "{\"cityCode\":\"\",\"cityId\":\"7\",\"cityName\":\"西安\",\"poiId\":\"136615\",\"poiName\":\"秦龙温泉\"," +
                "\"siteId\":202,\"status\":{\"cleanTime\":1557817205,\"crawlTime\":1557817205,\"currNum\":2142,\"siteId\":202," +
                "\"total\":2723,\"version\":20190514016},\"tickets\":[{\"deals\":[{\"bookTime\":\"最晚需在【出行当天17:30】前购买\",\"couponType\":\"\",\"dealId\":\"17873630\",\"dealName\":\"秦龙温泉门票+自助餐/小火锅票成人票(当天可定)\",\"extend\":\"\",\"include\":\"秦龙温泉成人票1张+自助餐/小火锅1位。\",\"payType\":1,\"poiId\":\"\",\"priceCalendar\":[{\"checkInDate\":20190514,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190522,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190523,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190604,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190608,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190609,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190610,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190611,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190612,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190613,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"}],\"refundRule\":\"未使用可随时申请退款。;;订单不支持部分退。;;如需改期，请申请取消后重新预订。\",\"rpName\":\"成人票\",\"tags\":[\"随时退\"],\"usage\":\"凭联系人手机+携程发送的电子确认单取票入园\",\"vendor\":\"自营\"},{\"bookTime\":\"最晚需在【出行当天17:45】前购买\",\"couponType\":\"\",\"dealId\":\"19017986\",\"dealName\":\"秦龙温泉门票+自助餐/小火锅票成人票\",\"extend\":\"\",\"include\":\"秦龙温泉成人票1张+自助餐/小火锅1位\",\"payType\":1,\"poiId\":\"\",\"priceCalendar\":[{\"checkInDate\":20190514,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190515,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190516,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190517,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190518,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190519,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190520,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190521,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190603,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190604,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190605,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190606,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190607,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190608,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190609,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190610,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190611,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190612,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"},{\"checkInDate\":20190613,\"couponList\":[],\"originPrice\":115,\"unit\":\"RMB\"}],\"refundRule\":\"未使用可随时申请退款。;;订单不支持部分退。;;如需改期，请申请取消后重新预订。\",\"rpName\":\"成人票\",\"tags\":[\"随时退\"],\"usage\":\"凭预留姓名+联系人手机+出行人手机取票入园\",\"vendor\":\"自营\"}],\"ticketType\":\"成人票\"}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(content);
        System.out.println(jsonNode);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(jsonNode.get("cityCode").asText());
        System.out.println(jsonNode.get("cityId").asText());
        System.out.println(jsonNode.get("cityName").asText());


        System.out.println(jsonNode.get("poiName").asText());

        System.out.println(jsonNode.get("siteId").asText());
        System.out.println(jsonNode.get("siteId").asInt());


        System.out.println(jsonNode.get("status").asInt());
        System.out.println(jsonNode.get("status").asText());
        System.out.println(jsonNode.get("status"));


        System.out.println(jsonNode.get("status").get("cleanTime"));
        System.out.println(jsonNode.get("status").get("cleanTime").asInt());
        System.out.println(jsonNode.get("status").get("cleanTime").asLong());
        System.out.println(jsonNode.get("status").get("cleanTime").asText());


        System.out.println(jsonNode.get("tickets"));
        System.out.println(jsonNode.get("tickets").asText());//输出空
        System.out.println(jsonNode.get("tickets").asInt());//输出0
        System.out.println(jsonNode.withArray("tickets"));

        for (JsonNode ob : jsonNode.get("tickets")) {
            System.out.println("ob====" + ob);
            JsonNode dealObj = ob.get("deals");

            System.out.println(dealObj.get(0).get("bookTime").asText());
            System.out.println(dealObj.get(0).get("bookTime"));


            System.out.println("dealObj===" + dealObj);
        }

        for (JsonNode ob : jsonNode.withArray("tickets")) {
            System.out.println("ob-withArray====" + ob);
        }


    }

}