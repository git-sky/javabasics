package cn.com.sky.basics.anti_if.Inline;

/**
 * 模式4：将内联语句（Inline statements）转为表达式
 * <p>
 * <p>
 * 问题： 这种代码会导致开发者必须用大脑来模拟计算机对方法的处理。
 * <p>
 * 适用范围：很少有不适用的情况，像这样的代码可以合成一行，或者拆成不同的部分。
 * <p>
 * 解决方案： 将if语句树合成单个表达式。
 */
public class TestInlineStatements {


    public boolean horrible(boolean foo, boolean bar, boolean baz) {
        if (foo) {
            if (bar) {
                return true;
            }
        }

        if (baz) {
            return true;
        } else {
            return false;
        }

    }

    //解决方案： 将if语句树合成单个表达式。
//    public boolean horrible(boolean foo, boolean bar, boolean baz) {
//        return foo && bar || baz;
//    }
}