package cn.com.sky.basics.annotation;

/**
 * <pre>
 *
 * 一、四种元注解：
 *
 * 注解作用：每当你创建描述符性质的类或者接口时,一旦其中包含重复性的工作，就可以考虑使用注解来简化与自动化该过程。
 *
 * Java提供了四种元注解，专门负责新注解的创建工作。
 *
 * 元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，它们被用来提供对其它 annotation类型作说明。
 *
 * J2SE5.0版本在 java.lang.annotation 提供了四种元注解，专门注解其他的注解：
 *
 * @Retention –什么时候使用该注解
 * @Target? –注解用于什么地方
 * @Inherited – 是否允许子类继承该注解
 * @Documented –注解是否将包含在JavaDoc中
 *
 * 1.@Target,
 * @Target
 * 说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
 * 　作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 *    取值(ElementType)：
 * 　　　　1.CONSTRUCTOR:用于描述构造器
 * 　　　　2.FIELD:用于描述域
 * 　　　　3.LOCAL_VARIABLE:用于描述局部变量
 * 　　　　4.METHOD:用于描述方法
 * 　　　　5.PACKAGE:用于描述包
 * 　　　　6.PARAMETER:用于描述参数
 * 　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 *        8.ANNOTATION_TYPE:注解
 *
 * 2. @Retention,
 * @Retention
 * 定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。
 * 　　作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 　　取值（RetentionPoicy）：
 * 　　　　1.SOURCE:在源文件中有效（即源文件保留）
 * 　　　　2.CLASS:在class文件中有效（即class保留）
 * 　　　　3.RUNTIME:在运行时有效（即运行时保留）
 *
 * - SOURCE代表源码级别，注解只存在源码中，其功能是与编译器交互，用于代码检测，如@Override,@SuppressWarings，许多框架如Dragger就是使用这个级别的注解，这个级别的框架额外效率损耗发生在编译时。
 * - CLASS代表字节码级别，注解存在源码与字节码文件中，主要用于编译时生成而外的文件，如XML，Java文件等，这个级别需要添加JVM加载时候的代理（javaagent ），使用代理来动态修改字节码文件（由于Android虚拟机并不支持所以本专题不会再做介绍，在Android中可以使用aspectJ来实现类似这个级别的功能）。
 * - RUNTIME代表运行时级别，注解存在源码，字节码与Java虚拟机中，主要用于运行时反射获取相关信息，许多框架如OrmLite就是使用这个级别的注解，这个级别的框架额外的效率损耗发生在程序运行时。
 *
 *
 * 二、内建注解
 *
 * 也称为基本注解，位于Java.lang包下共有三个：@Override（检验重写父类方法） @Deprecated(标识方法过时)  @SurpressWarnings （取消编译器警告）；
 *
 * 三、自定义注解
 *
 * 使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
 * 在定义注解时，不能继承其他的注解或接口。@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。
 * 可以通过default来声明参数的默认值。
 *
 * 　　定义注解格式：
 * 　　public @interface 注解名 {定义体}
 * 　　注解参数的可支持数据类型：
 * 　　　　1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
 * 　　　　2.String类型
 * 　　　　3.Class类型
 * 　　　　4.enum类型
 * 　　　　5.Annotation类型
 * 　　　　6.以上所有类型的数组
 * 　　Annotation类型里面的参数该怎么设定:
 * 　　第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默认类型；
 * 　　第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和 String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如,String value();这里的参数成员就为String;
 * 　　第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号.例:下面的例子FruitName注解就只有一个参数成员。
 *
 * </pre>
 */
public class Annotations {


}