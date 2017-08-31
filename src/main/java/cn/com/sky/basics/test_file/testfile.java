package cn.com.sky.basics.test_file;
import java.io.*;
public class testfile {
	public static void main(String args[]){
		int b=0;
		FileInputStream in=null;
		FileOutputStream out=null;
		try{
			in=new FileInputStream("a.txt");
			out=new FileOutputStream("b.txt");
			while((b=in.read())!=-1){
				out.write(b);
		
			}
			in.close();
			out.close();
		}catch(FileNotFoundException e){
			System.out.print("�Ҳ���ָ�����ļ� ");
			System.exit(-1);
		}catch(IOException e1){
			System.out.print("�ļ����ƴ���");
			System.exit(-1);
			}
		System.out.print("�ļ��Ѹ���");
	}

}
