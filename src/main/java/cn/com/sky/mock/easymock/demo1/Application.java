package cn.com.sky.mock.easymock.demo1;

public class Application {

	IService service = null;

	public Application() {

	}

	public String doMethod() {
		String a = service.doMethod1();
		String b = service.doMethod1();
		String c = service.doMethod1();
		String str2 = service.doMethod2();
		String str3 = service.doMethod3();
		return a + str2 + str3;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

}