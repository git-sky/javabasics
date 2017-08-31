package cn.com.sky.tools.serializable.fastjson.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alibaba.fastjson.serializer.NameFilter;

public class FastjsonNameFilter {
	/**
	 * 解决fastjson把实体中is开头的属性去掉的问题
	 */
	public static NameFilter nameFilter = new NameFilter() {
		@Override
		public String process(Object resource, String name, Object value) {
			if (value instanceof Boolean) {
				String nameIncludeIs = "is" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
				Method method = null;
				Field filed = null;
				try {
					method = resource.getClass().getMethod(nameIncludeIs);
					filed = resource.getClass().getDeclaredField(nameIncludeIs);
				} catch (Exception ignored) {
				} finally {
					if (method != null && filed != null) {
						System.out.println("出现以is开头的boolean变量{}" + nameIncludeIs);
						return nameIncludeIs;
					}
				}
			}
			return name;
		}
	};
}
