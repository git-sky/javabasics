package cn.com.todo.test_httpclientJsoup;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author swimming.xu
 *
 */
public class DownloadImage {
	private static String DIR	=	"F:\\TEMP\\";
	private static String URL	=	"http://www.th38.com/nvlangtuku/";
	private static String PIC	=	".jpg";
	private static String FILENAME	=	"jpg";
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity =response.getEntity();
		StringBuilder builder = new StringBuilder();
		if(entity != null){
			InputStream inputStream = entity.getContent();
			byte[] temp = new byte[2048];
			while((inputStream.read(temp))!=-1){
				builder.append(new String(temp));
			}
			
		}
		ArrayList<String> imgs = analyseImgs(builder.toString());
		savetodisk(imgs,makedir(DownloadImage.URL));
	}
	
	
	/**
	 * ����URL����Ŀ¼
	 * @param url
	 */
	private static String makedir(String url) {
		String dirname = url.substring(url.indexOf(".")+1,url.lastIndexOf("."));
		File file = new File(DownloadImage.DIR+dirname);
		if(!file.exists()){
			file.mkdirs();
		}
		return file.getPath();
	}
	
	
	/**
	 * �洢ͼƬ��Ӳ��
	 * @param imgs
	 * @param diskuri
	 */
	private static void savetodisk(ArrayList<String> imgs,String diskuri) {
		for(String tt:imgs){
			System.out.println("ͼƬ��ַ: "+tt);
			DownloadImage.writeImageLocal(diskuri+tt.substring(tt.lastIndexOf("/"),tt.lastIndexOf(PIC))+PIC, DownloadImage.loadImageUrl(tt));
		}
	}


	/**
	 * ���ݻ�ȡ����HTMLҳ�����ͼƬ
	 * @param string
	 * @return
	 */
	private static ArrayList<String> analyseImgs(String string) {
		ArrayList<String> list = new ArrayList<String>();
		String[] temp = string.split(PIC);
		for(String a:temp){
			list.add(a.substring(a.lastIndexOf("http://"))+PIC);
		}
		return list;
	}



	/**
	 * ͨ��URL��ַ��ȡͼƬ
	 * @param imgName
	 * @return
	 */
	public static BufferedImage loadImageUrl(String imgName)     
	{     
	    try    
	    {     
	        URL url = new URL(imgName);     
	        return ImageIO.read(url);     
	    } catch (IOException e)     
	    {     
	        System.out.println(e.getMessage());     
	    }     
	    return null;     
	}     
	    
	/**   
	* ������ͼƬ������   
	*/    
	public static void writeImageLocal(String newImage, BufferedImage img)     
	{     
	    if (newImage != null && img != null)     
	    {     
	        try    
	        {     
	            File outputfile = new File(newImage);     
	            ImageIO.write(img, FILENAME, outputfile); 
	            System.out.println("one jpg saved");
	        } catch (IOException e)     
	        {     
	            System.out.println(e.getMessage());     
	        }     
	    }     
	}     
	
}

