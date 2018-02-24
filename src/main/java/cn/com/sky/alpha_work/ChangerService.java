package cn.com.sky.alpha_work;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Map;

//interface IChange<T> {
//    List<DataPlan> change(T obj, ChangeConst changeConst);
//}

/**
 * 返利计划推送到商品系统
 */
//@Service
public class ChangerService {
//    private static final Logger logger = LoggerFactory.getLogger(ChangerService.class);
//    private static final String topic = ReloadableConfig.getString("send.product.topic");//"dev_gome_dpc3";//
//    private static final String groupName = ReloadableConfig.getString("send.product.groupName");
//    private static final String brokerList = ReloadableConfig.getString("send.product.brokerList");
//    private static final String tag = ReloadableConfig.getString("send.product.tag", "*");//"dev_gome_dpc3";//
//
//    static {
//        Validate.notEmpty(topic, "diamond中必须配置send.product.topic");
//        TopicInfo info = new TopicInfo(groupName, "rebate_send_product", brokerList);
//        RocketProducerManager.start(info);
//    }
//
//    @Autowired
//    @Qualifier("rebatePlanManagerImpl")
//    private IRebatePlanManager planManager;
//
//    @Autowired
//    private ICategoryDBService categoryService;
//
//    @Autowired
//    private OfflinePlatformSharingPoMapper offlinePlatformSharingPoMapper;
//
//    @Autowired
//    private OfflineSellerRatioPoMapper offlineSellerRatioPoMapper;
//
//    @Autowired
//    private SendToBigDataWithPlanMqClient sendToBigDataWithPlanMqClient;
//
//    private Map<Class<?>, IChange<?>> changers = Maps.newConcurrentMap();
//
//    public ChangerService() {
//        changers.put(RebatePlanPo.class, new ChangerService.PlanChanger());
//    }
//
//    public <T> void change(T obj, ChangeConst changeConst) {
//        List<DataPlan> change = Lists.newArrayList();
//        try {
//            @SuppressWarnings("unchecked")
//            IChange<T> iChange = (IChange<T>) changers.get(obj.getClass());
//            change = iChange.change(obj, changeConst);
//        } catch (Exception e) {
//            logger.error("change Error! changeConst:{}", changeConst, e);
//        }
//
//        if (change == null || change.size() == 0) {
//            logger.info("The data is empty!");
//        }
//
//        RebatePlanPo planPo = planManager.selectByPrimaryKey(((RebatePlanPo) obj).getId());
//        if (needSendCalcCenter(planPo)) {
//            if (new Date().after(planPo.getValidStartTime())){
//                send2CalcCenter(change);
//            }
//        }
//        try {
//            if (((RebatePlanPo) obj).getSendToBigDataFlag()){
//                if (needSendCalcCenter(planPo)){
//                    if (new Date().after(planPo.getValidStartTime())){
//                        send2BigData(change);
//                    }
//                }else {
//                    send2BigData(change);
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Send to big data with error msg:",e);
//        }
//    }
//
//    /**
//     * 推送到商品中心
//     */
//    private void send2CalcCenter(List<DataPlan> change) {
//        try {
//            for (DataPlan data : change) {
//                logger.info("Send to calc center with json[{}]", JsonUtil.toJson(data));
//                if (data.getProductFlag()==1){
//                    data.setProductFlag(null);
//                    String json = JsonUtil.toJson(data);
//                    SendResult srr = RocketProducerManager.sendMessageForOther(topic, tag, data.getPlanId(), json.getBytes(Charset.forName("UTF-8")));
//                    logger.info("Send to calc center with result[{}]", JsonUtil.toJson(srr));
//                    logger.info("message:{}-msgId:{}-sendStatus:{}-messageQueue:{}", json, srr.getMsgId(), srr.getSendStatus(), srr.getMessageQueue());
//                }
//            }
//        } catch (Exception e) {
//            logger.error("send2CalcCenter error! changeList:{}", change, e);
//        }
//    }
//
//    /**
//     * 推送到大数据中心
//     */
//    private void send2BigData(List<DataPlan> change) throws Exception {
//        for (DataPlan data : change) {
//            data.setProductFlag(null);
//            DataPlanToBigData dataPlanToBigData = new DataPlanToBigData();
//            if (data.getPlanId() !=null && !"".equals(data.getPlanId())){
//                RebatePlanPo planPo = planManager.selectByPrimaryKey(Integer.parseInt(data.getPlanId()));
//                dataPlanToBigData.setEndCondition(planPo.getEstimateAmount());
//            }
//            dataPlanToBigData.setData(data);
//            dataPlanToBigData.setSendTime(new Date().getTime());
//            dataPlanToBigData.setType("rebate.plan");
//            String json = JsonUtil.toJson(dataPlanToBigData);
//            logger.info("Send to big data with json[{}]",json);
//            SendResult sendResult = sendToBigDataWithPlanMqClient.send(json);
//            logger.info("Send to big data with result[{}]", JsonUtil.toJson(sendResult));
//        }
//    }
//
//    /**
//     * 是否需要发送商品系统<br>
//     * 邀请商家入驻、邀请好友注册不给商品系统推送
//     *
//     * @param planPo
//     *            计划Po
//     */
//    public boolean needSendCalcCenter(RebatePlanPo planPo) {
//        // 商家入驻-固定返利
//        boolean checkinFixed = planPo.getPlanType() == BaseConstants.PLAN_TYPE_SELLER_INVITATION && planPo.getFlow() == BaseConstants.PLAN_FLOW_SELLER_INVITATION_FIXED;
//        // 平台基础和促销，邀请好友-固定返利
//        boolean frindFixed = BusinessUtil.checkIsPlatform(planPo) && planPo.getFlow() == BaseConstants.PLAN_FLOW_INVITED_FRIEND_FIXED;
//        boolean needSend = true;
//        if (checkinFixed || frindFixed) {
//            needSend = false;
//        }
//        return needSend;
//    }
//
//    public enum ChangeConst {
//        ADD(1), UPDATE(2), DEL(3);
//        int v;
//
//        ChangeConst(int va) {
//            this.v = va;
//        }
//
//        public int getV() {
//            return this.v;
//        }
//    }
//
//    private class PlanChanger implements IChange<RebatePlanPo> {
//
//        @Override
//        public List<DataPlan> change(RebatePlanPo obj, ChangeConst changeConst) {
//
//            List<DataPlan> ret = Lists.newArrayList();
//
//            RebatePlanPo planPo = planManager.selectByPrimaryKey(obj.getId());
//
//            DataPlan data = setNewData(planPo);
//
//            if (!BusinessUtil.checkIsSellerCheckIn(planPo)) {// 非"邀请商家入驻-分享返利"
//                List<RebatePlanCommodityPo> commoditys;
//                if (changeConst == ChangeConst.ADD) {
//                    commoditys = planManager.selectPlanCommodityListsByPlanIdAndStatus(obj.getId());
//                } else {
//                    commoditys = planManager.selectPlanCommodityListsByPlanId(obj.getId());
//                }
//
//                if (CollectionUtils.isEmpty(commoditys)) {
//                    logger.error("planId:{},没有关联商品记录", obj.getId());
//                    data.setProductFlag(0);//为了兼容计划推送大数据 增加此标识
//                    ret.add(data);
//                    return ret;
//                } else {
//                    if (planPo.isSkuLevel()) {// sku级别
//                        setSku(commoditys, data, planPo);
//                    } else {// 非sku级别
//                        setCategoryAndProduct(commoditys, data);
//                    }
//                }
//            }
//
//            ret.add(data);
//            return ret;
//        }
//
//        private void setCategoryAndProduct(List<RebatePlanCommodityPo> commoditys, DataPlan data) {
//            StringBuilder sbCategory = new StringBuilder();
//            StringBuilder sbProduct = new StringBuilder();
//            for (RebatePlanCommodityPo commodityPo : commoditys) {
//                Integer type = commodityPo.getType();// 1..7级别品类
//                String typeId = commodityPo.getId();// 品类id
//                if (StringUtils.isBlank(typeId)) {
//                    continue;
//                }
//
//                if (type == 1) { // dubbo调用在线的商品目录
//                    List<Category> categoryList = categoryService.getThreeCategoryIdByFirstCategoryId(typeId);
//                    getThirdCategory(sbCategory, categoryList);
//                } else if (type == 2) { // dubbo调用在线的商品目录
//                    List<Category> categoryList = categoryService.getThreeCategoryIdBySecCategoryId(typeId);
//                    getThirdCategory(sbCategory, categoryList);
//                } else if (type == 3) {
//                    sbCategory.append(typeId);
//                    sbCategory.append(",");
//                } else {
//                    sbProduct.append(typeId);
//                    sbProduct.append(",");
//                }
//            }
//
//            data.setCategory(sbCategory.toString());
//            data.setProduct(sbProduct.toString());
//        }
//
//        private void getThirdCategory(StringBuilder sbCategory, List<Category> categoryList) {
//            if (categoryList != null && categoryList.size() > 0) {
//                for (Category category : categoryList) {
//                    if (category == null || category.getCategoryId() == null) {
//                        continue;
//                    }
//                    sbCategory.append(category.getCategoryId());
//                    sbCategory.append(",");
//                }
//            }
//        }
//
//        private void setSku(List<RebatePlanCommodityPo> commoditys, DataPlan data, RebatePlanPo planPo) {
//            List<DataPlanCommodity> list = Lists.newArrayList();
//            for (RebatePlanCommodityPo commodityPo : commoditys) {
//                if (commodityPo == null) {
//                    continue;
//                }
//                String typeId = commodityPo.getId();// 品类id
//                if (StringUtils.isBlank(typeId)) {
//                    continue;
//                }
//                DataPlanCommodity dpc = new DataPlanCommodity();
//                dpc.setSkuId(commodityPo.getId());
//                dpc.setSkuRebateRatio(commodityPo.getRebateRatio());
//                if (planPo.isRebateFixed()) {
//                    dpc.setSkuRebateRatio(commodityPo.getRebateAmount());
//                }
//
//                if (planPo.getFlow() == BaseConstants.PLAN_FLOW_DISTRIBUTION_RATIO || planPo.getFlow() == BaseConstants.PLAN_FLOW_DISTRIBUTION_FIXED) {//分销
//
//                    if (dpc.getSkuRebateRatio() != null) {
//                        Integer skuRebateRatio = getRebateRatio(planPo, dpc.getSkuRebateRatio());//线下分销返利百分比需要乘以公司代码中的比例
//                        dpc.setSkuRebateRatio(skuRebateRatio);
//                    }
//                }
//
//
//                list.add(dpc);
//            }
//            data.setSkuPlans(list);
//        }
//
//        private DataPlan setNewData(RebatePlanPo planPo) {
//            DataPlan data = new DataPlan();
//            data.setPlanId(String.valueOf(planPo.getId()));
//            data.setPlanName(planPo.getName());
//            data.setStartTime(planPo.getValidStartTime().getTime());
//            data.setEndTime(planPo.getValidEndTime().getTime());
//            data.setStatus(String.valueOf(planPo.getStatus()));
//            data.setPlanType(String.valueOf(planPo.getPlanType()));
//            data.setFlow(String.valueOf(planPo.getFlow()));
//            data.setFlowDesc(planPo.getDescrition());
//            data.setRebateRatio(planPo.getRebateRatio());
//            data.setRatioMap(planPo.getRatios());
//            data.setRebateLevel(planPo.getRebateLevel());
//            data.setMerchantScopes(planPo.getMerchantScopes());
//            data.setCategory("");
//            data.setProduct("");
//            data.setOrgCode(planPo.getMarketingOrganizationId());
//            data.setProdSource(planPo.getProductSource());
//
//            data.setRebateThreshold(planPo.getRebateThreshold());
//
//            if (planPo.isRebateFixed()) {
//                data.setRebateRatio(planPo.getRebateAmount());
//            }
//
//            if (planPo.isSkuLevel()) {
//                data.setSkuType("SKUNO");
//            }
//
//            if (planPo.getFlow() == BaseConstants.PLAN_FLOW_SHARE_RATIO || planPo.getFlow() == BaseConstants.PLAN_FLOW_SHARE_FIXED) {//线下门店:分享返利
//                String targetMaps = getShareRatioMap(planPo);//线下分享需要使用配置表中的比例
//                data.setRatioMap(targetMaps);
//            } else if (planPo.getFlow() == BaseConstants.PLAN_FLOW_DISTRIBUTION_RATIO || planPo.getFlow() == BaseConstants.PLAN_FLOW_DISTRIBUTION_FIXED) {//分销
//                String targetMaps = getDisRatioMap();//线下分销需要使用配置表中的比例
//                data.setRatioMap(targetMaps);
//
//                if (data.getRebateRatio() != null) {
//                    Integer rebateRatio = getRebateRatio(planPo, data.getRebateRatio());//线下分销返利百分比需要乘以公司代码中的比例
//                    data.setRebateRatio(rebateRatio);
//                }
//            }
//
//
//            return data;
//        }
//
//        private Integer getRebateRatio(RebatePlanPo planPo, Integer rebateRatio) {
//            if (rebateRatio == null) return 0;
//
//            Integer payRatio = 10000;//公司比例
//
//            if (planPo.getZZCONID() != null) {
//                Map map = Maps.newHashMap();
//                map.put("zeroDate", DateUtil.getTodayBeginTime());
//                map.put("companyNo", planPo.getZZCONID());
//                List<OfflineSellerRatioPo> list = offlineSellerRatioPoMapper.selectSellerCurrentEffective(map);
//                if (list != null && list.size() > 0) {
//                    OfflineSellerRatioPo po = list.get(0);
//                    if (po != null && po.getPaymentRatio() != null) {
//                        payRatio = po.getPaymentRatio();
//                    }
//                }
//            }
//
//            BigDecimal payRatioD = MoneyScaleUtil.getMultiplyResult(payRatio, 0.0001, 4);
//            return MoneyScaleUtil.getMultiplyResult(rebateRatio, payRatioD, 0).intValue();
//        }
//
//        private String getDisRatioMap() {
//            Map map = Maps.newHashMap();
//            map.put("type", 1);//分销计划
//            map.put("zeroDate", DateUtil.getTodayBeginTime());
//            OfflinePlatformSharingPo platPo = offlinePlatformSharingPoMapper.selectPlatCurrentEffective(map);
//
//            Integer platRatio = 0;//平台比例默认是0
//            if (platPo.getPlanRatio() != null) {
//                platRatio = platPo.getPlanRatio();
//            }
//
//            return changeRatioMapsDis(platRatio);
//        }
//
//        private String getShareRatioMap(RebatePlanPo planPo) {
//            Map map = Maps.newHashMap();
//            map.put("type", 2);//分享计划
//            map.put("zeroDate", DateUtil.getTodayBeginTime());
//            OfflinePlatformSharingPo platPo = offlinePlatformSharingPoMapper.selectPlatCurrentEffective(map);
//
//            Integer platRatio = 0;//平台比例默认是0
//            if (platPo.getPlanRatio() != null) {
//                platRatio = platPo.getPlanRatio();
//            }
//
//            Map<Integer, Map<Integer, Integer>> soureMaps = BusinessUtil.calcString2Map(planPo.getRatios());
//
//            return changeRatioMaps(platRatio, soureMaps);
//        }
//    }

    public static void main(String[] args) {

//        String s ="{1={1=100},2={1=50,2=50},3={1=33,3=34,2=33},4={1=25,3=25,2=25,4=25}}";
        String s = "{1={1=100}, 2={1=50, 2=50}, 3={1=33, 2=33, 3=34}, 4={1=25, 2=25, 3=25, 4=25}}";


//        Map<Integer, Map<Integer, Integer>> soureMaps = BusinessUtil.calcString2Map(s);
//
//        String result=changeRatioMaps(8000, soureMaps);
//        System.out.println("soure:"+s);
//        System.out.println("target:"+result);

        System.out.println(changeRatioMapsDis(8000));

    }

    private static String changeRatioMaps(Integer platRatio, Map<Integer, Map<Integer, Integer>> soureMaps) {

        Integer shopRatio = 10000 - platRatio;//分销比例

        Map<Integer, Map<Integer, Double>> targetMaps = Maps.newHashMap();

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : soureMaps.entrySet()) {
            Integer key = entry.getKey();
            Map<Integer, Integer> innerMap = entry.getValue();

            Map<Integer, Double> targetInnerMap = Maps.newHashMap();
            for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                Integer inKey = innerEntry.getKey();
                Integer inVal = innerEntry.getValue();

                BigDecimal targetValue = MoneyScaleUtil.getCalcResult2(new BigDecimal(inVal),
                        MoneyScaleUtil.getCalcResult(new BigDecimal(shopRatio), new BigDecimal("0.0001"), MoneyScaleUtil.Operator.multiply, 4), MoneyScaleUtil.Operator.multiply);

//                BigDecimal sRatio = MoneyScaleUtil.getMultiplyResult(shopRatio, 0.0001, 4);
//                BigDecimal targetValue = MoneyScaleUtil.getMultiplyResult(inVal, sRatio, 2);

                targetInnerMap.put(inKey + 1, targetValue.doubleValue());
            }
            targetInnerMap.put(1, MoneyScaleUtil.getCalcResult2(new BigDecimal(platRatio), new BigDecimal("0.01"), MoneyScaleUtil.Operator.multiply).doubleValue());

            targetMaps.put(key, targetInnerMap);

        }

        return targetMaps.toString();
    }


    private static String changeRatioMapsDis(Integer platRatio) {

        Integer shopRatio = 10000 - platRatio;//分销比例

        Map<Integer, Map<Integer, Double>> targetMaps = Maps.newHashMap();
        Map<Integer, Double> targetInnerMap = Maps.newHashMap();
        targetInnerMap.put(1, MoneyScaleUtil.getCalcResult2(new BigDecimal(platRatio), new BigDecimal("0.01"), MoneyScaleUtil.Operator.multiply).doubleValue());
        targetInnerMap.put(2, MoneyScaleUtil.getCalcResult2(new BigDecimal(shopRatio), new BigDecimal("0.01"), MoneyScaleUtil.Operator.multiply).doubleValue());
        targetMaps.put(1, targetInnerMap);


        return targetMaps.toString();
    }


}
