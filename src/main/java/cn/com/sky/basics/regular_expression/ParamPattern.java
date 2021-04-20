package cn.com.sky.basics.regular_expression;

/**
 * 参数属性
 */
public class ParamPattern {

    private String name;

    private String pattern;

    public ParamPattern() {
    }

    public ParamPattern(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "ParamPattern{" +
                "name='" + name + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}