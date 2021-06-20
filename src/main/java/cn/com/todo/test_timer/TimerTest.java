package cn.com.todo.test_timer;

import java.util.Timer;

class TimerTaskTest extends java.util.TimerTask {
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("start....");
		System.out.println(System.currentTimeMillis());
	}
}

// //�����Ǽ��ֵ���task�ķ�����
// timer.schedule(task, time);
// // timeΪDate���ͣ���ָ��ʱ��ִ��һ�Ρ�
// timer.schedule(task, firstTime, period);
// // firstTimeΪDate����,periodΪlong
// // ��firstTimeʱ�̿�ʼ��ÿ��period����ִ��һ�Ρ�
// timer.schedule(task, delay)
// // delay Ϊlong���ͣ����������delay����ִ��һ��
// timer.schedule(task, delay, period)
// // delayΪlong,periodΪlong�����������delay�����Ժ�ÿ��period
// // ����ִ��һ�Ρ�

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTaskTest(), 1000, 1000);

		// timer.scheduleAtFixedRate(new TimerTaskTest(), 1000,1000);
		// ###˵�����÷�����schedule����ͬ�����İ汾���ƣ���ͬ���ǣ������������ΪĳЩԭ�����������ռ������ӳ�ִ�У���ô������������ᾡ���ܵĿ���ִ�У��Ը����ض���ʱ��㡣
	}
}
