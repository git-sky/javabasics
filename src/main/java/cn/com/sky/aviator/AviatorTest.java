package cn.com.sky.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AviatorTest {

    @Test
    public void filterTest(){
        //如果想查看每个表达式生成的字节码，可以通过打开 Trace 选项：
        AviatorEvaluator.setOption(Options.TRACE_EVAL, true);
        String goodsRule = "(goodsSource == 2 && averagePrice == originalPrice) || goodsSource == 1";
        //预编译
        Expression compiledExp = AviatorEvaluator.compile(goodsRule);

        Map<String, Object> zlInvalid = new HashMap<>(3);
        zlInvalid.put("goodsSource", 2);
        zlInvalid.put("averagePrice", 25000);
        zlInvalid.put("originalPrice", 31000);
        zlInvalid.put("goodsId", 9932);

        Map<String, Object> zlValid = new HashMap<>(3);
        zlValid.put("goodsSource", 2);
        zlValid.put("averagePrice", 31000);
        zlValid.put("originalPrice", 31000);
        zlInvalid.put("goodsId", 9935);

        Map<String, Object> yfValid = new HashMap<>(3);
        yfValid.put("goodsSource", 1);
        yfValid.put("averagePrice", 25000);
        yfValid.put("originalPrice", 31000);
        zlInvalid.put("goodsId", 9934);

        Boolean zlInvalidResult = (Boolean) compiledExp.execute(zlInvalid);
        Boolean zlValidResult = (Boolean) compiledExp.execute(zlValid);
        Boolean yfValidResult = (Boolean) compiledExp.execute(yfValid);

        Assert.assertFalse("过滤活动房失败", zlInvalidResult.booleanValue());
        Assert.assertTrue("过滤直连正价失败", zlValidResult.booleanValue());
        Assert.assertTrue("过滤预付失败", yfValidResult.booleanValue());
    }
}