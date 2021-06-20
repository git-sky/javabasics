package cn.com.todo.test_basic;

public class TestDeclare {

	//arr1��arr2���ɹ�������������
	int[] arr1,arr2; 
	{
		System.out.println("aaaaaaaaaaaa");
	}
	
	//ֻ��arr3�ɹ������������飬arr4��int���Ͷ�����������
	int arr3[],arr4;
	
	public static void main(String args[]){
		System.out.println("main............");
		new TestDeclare().print();
		System.out.println("after print............");
	}
	public void print(){
		arr1=new int[5];
		arr2=new int[5];
		arr3=new int[5];
		//arr4=new int[5];
		System.out.println(arr1.getClass().isArray());
		System.out.println(arr2.getClass().isArray());
		System.out.println(arr3.getClass().isArray());
		//System.out.println(arr4.getClass().isArray());
	}
}
