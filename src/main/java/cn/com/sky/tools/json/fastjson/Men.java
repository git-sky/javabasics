package cn.com.sky.tools.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * fastjson解析有下划线的对象会有问题，需要用@JSONField(name="_name")解决。
 */
public class Men {

	private String _name;
	private int _age;

//	@JSONField(name="_name") 
	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

//	@JSONField(name="_age") 
	public int get_age() {
		return _age;
	}

	public void set_age(int _age) {
		this._age = _age;
	}
	@Override
	public String toString() {
		return this.get_name()+":"+this.get_age();
	}

}
