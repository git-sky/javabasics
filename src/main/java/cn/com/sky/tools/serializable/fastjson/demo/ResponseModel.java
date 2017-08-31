package cn.com.sky.tools.serializable.fastjson.demo;

import com.alibaba.fastjson.annotation.JSONField;

public class ResponseModel<T> {
	// 返回消息
	@JSONField(ordinal = 1)
	private String message = "";
	// 返回对象
	@JSONField(ordinal = 2)
	private T data;
	// debug模式，需要在配置开关，开发测试模式可以开启

	@JSONField(ordinal = 3)
	private T error;

	@JSONField(ordinal = 4)
	private String debug;

	@JSONField(ordinal = 5)
	private Boolean isGoods;

	public ResponseModel() {
	}

	public ResponseModel(T data) {
		this.data = data;
	}

	public ResponseModel(String message) {
		if (null != message) {
			this.message = message;
		}
	}

	public void setMessage(String message) {
		if (null != message) {
			this.message = message;
		}
	}

	public void setData(T data) {
		if (null != data) {
			this.data = data;
		}
	}

	public void setError(T error) {
		if (null != error) {
			this.error = error;
		}
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public T getError() {
		return error;
	}

	public Boolean getIsGoods() {
		return isGoods;
	}

	public void setIsGoods(Boolean isGoods) {
		this.isGoods = isGoods;
	}
}
