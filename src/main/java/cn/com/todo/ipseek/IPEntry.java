package cn.com.todo.ipseek;

/**
 * * һ��IP��Χ��¼�������������Һ�����Ҳ������ʼIP�ͽ���IP *
 */
public class IPEntry {
	public String beginIp;
	public String endIp;
	public String country;
	public String area;

	/**
	 * ���캯��
	 */
	public IPEntry() {
		beginIp = endIp = country = area = "";
	}

	public String toString() {
		return this.area + "  " + this.country + "IP��Χ:" + this.beginIp + "-"
				+ this.endIp;
	}
}
