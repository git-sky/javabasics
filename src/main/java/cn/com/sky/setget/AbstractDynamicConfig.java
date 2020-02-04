package cn.com.sky.setget;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractDynamicConfig {

    protected Log logger = LogFactory.getLog(getClass());
    protected Properties resultProp = new Properties();

    protected boolean initFlag = false;
    protected Map<String, Object> initParams = null;

    public boolean dynamicChangeConfig(String field, String value) {
        boolean flag = true;
        if (StringUtils.isBlank(field)) {
            return false;
        }
        field = field.trim();

        Method getMethod = null;
        Method setMethod = null;
        try {
            getMethod = ConfigUtil.getInnerMethod(MethodTypeEnum.GET, field, getClass());
            setMethod = ConfigUtil.getInnerMethod(MethodTypeEnum.SET, field, getClass());
        } catch (Exception e) {
            this.logger.error("dynamicChangeConfig getMethod and setMethod[" + e.toString() + "] -- field=[" + field + "],value=[" + value + "]");
        }
        if (getMethod == null) {
            this.logger.info("BasicComponentProp getMethod  is null , key = " + field + " , value = " + value + " , component  = " + getClass().getName());
            return false;
        }
        Class rtype = getMethod.getReturnType();
        try {
            if (String.class.isAssignableFrom(rtype)) {
                setMethod.invoke(this, new Object[]{value});
            } else if (Map.class.isAssignableFrom(rtype)) {
                Map map = ConfigUtil.analyzeString2Map(rtype, getMethod.getGenericReturnType(), value);
                setMethod.invoke(this, new Object[]{map});
            } else if (rtype.isArray()) {
                Object object = ConfigUtil.analyzeString2Array(getMethod.getReturnType().getComponentType(), value);
                setMethod.invoke(this, new Object[]{object});
            } else if (Collection.class.isAssignableFrom(rtype)) {
                Collection collection = ConfigUtil.analyzeString2Collection(getMethod, value);
                setMethod.invoke(this, new Object[]{collection});
            } else {
                Object object = ConfigUtil.transBasicValue(rtype, value);
                if (null != object) {
                    setMethod.invoke(this, new Object[]{object});
                } else {
                    this.logger.info("Abstract setmethod failure , field = " + field + " , value = " + value + " , bean = " + getClass().getName());
                }
            }
        } catch (Exception e) {
            flag = false;
            this.logger.error("dynamicChangeConfig change and func[" + e.toString() + "] -- field=[" + field + "],value=[" + value + "]");
        }

        this.logger.info("dynamicChangeConfig[" + flag + "] -- field=[" + field + "],value=[" + value + "]");
        return flag;
    }
}