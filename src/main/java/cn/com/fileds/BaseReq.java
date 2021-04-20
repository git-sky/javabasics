package cn.com.fileds;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
public class BaseReq {

    /**
     * 第三方id
     */
    private String clientId;

    /**
     * 第三方id
     */
    private String appId;

    /**
     * 应用密钥
     */
    private String appSecret;

    /**
     * 第三方access token
     */
    private String accessToken;

    /**
     * 请求来源（3：小容器）
     */
    private Integer source;


//   以下为风控需求相关

    /**
     * 设备id
     */
    private String mtDeviceId;

    /**
     * 平台标识，Android/iOS
     */
    private String basePlatform;

    /**
     * 设备硬件信息集合
     */
    private String fingerprint;

    /**
     * 客户端版本号
     */
    private String mtVersion;


    /**
     * 加密的业务参数
     */
    private String bizContent;

}