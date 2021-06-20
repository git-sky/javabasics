package cn.com.sky.property_copy.beancopy;

import org.springframework.cglib.beans.BeanCopier;

/**
 * Spring中BeanCopier.copy结合lombok遇到的坑
 * <p>
 * https://my.oschina.net/619517865/blog/4657118
 */
public class BeanCopyMain {

    public static void main(String[] args) {
        OrderDTO orderDTO = new OrderDTO();
        //C端渠道
        orderDTO.setChannel(1001);
        //B端渠道
        orderDTO.setbNchannel(2001);

        OrderDO orderDO = new OrderDO();
        beanCopy(orderDTO, orderDO);

        System.out.println(orderDO);
    }

    /**
     * 对象之间拷贝
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void beanCopy(Object source, Object target) {
        if (null == source) {
            return;
        }
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }
}