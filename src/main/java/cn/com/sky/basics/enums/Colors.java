package cn.com.sky.basics.enums;

public enum Colors {
	
	RED("红色", "1"), GREEN("绿色", "2_2"), BLANK("白色", "3"), YELLO("黄色", "4");
	
	// 成员变量
	private String name;
	private String index;

	// 构造方法
	private Colors(String name, String index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(String index) {
		for (Colors c : Colors.values()) {
			if (c.getIndex().equalsIgnoreCase(index)) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public static void main(String[] args) {
		// System.out.println(getName(1));
		for (Colors c : Colors.values()) {
			System.out.println(c.getIndex() + ":" + c.getName());
		}
	}
}