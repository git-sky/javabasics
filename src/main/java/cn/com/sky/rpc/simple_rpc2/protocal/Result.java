package cn.com.sky.rpc.simple_rpc2.protocal;

import java.io.Serializable;

/**
 * 停止服务器结果
 * 
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 是否允许停止 */
	private boolean isStop;
	/** 错误信息 */
	private String msg;

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}