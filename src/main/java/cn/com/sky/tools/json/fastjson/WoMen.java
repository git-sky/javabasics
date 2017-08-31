package cn.com.sky.tools.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * fastjson解析有下划线的对象会有问题，需要用@JSONField(name="_name")解决。
 */
public class WoMen {

	private String _3name;
	private int _3age;

	public int get_3age() {
		return _3age;
	}

	public void set_3age(int _3age) {
		this._3age = _3age;
	}

	public String get_3name() {
		return _3name;
	}

	public void set_3name(String _3name) {
		this._3name = _3name;
	}

}
