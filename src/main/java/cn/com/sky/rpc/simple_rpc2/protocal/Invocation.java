package cn.com.sky.rpc.simple_rpc2.protocal;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 调用实例
 */
public class Invocation implements Serializable {
	/** 
     *  
     */
	private static final long serialVersionUID = 1L;
	/** 接口 */
	private Class<?> interfaces;
	/** 方法 */
	private Method method;
	/** 参数数组 */
	private Object[] params;
	/** 结果 */
	private Object result;

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the interfaces
	 */
	public Class<?> getInterfaces() {
		return interfaces;
	}

	/**
	 * @param interfaces
	 *            the interfaces to set
	 */
	public void setInterfaces(Class<?> interfaces) {
		this.interfaces = interfaces;
	}

	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(Method method) {
		this.method = method;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return interfaces.getName() + "." + method.getMethodName() + "(" + Arrays.toString(params) + ")";
	}

}