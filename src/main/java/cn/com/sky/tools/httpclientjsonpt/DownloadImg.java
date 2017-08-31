package cn.com.sky.tools.httpclientjsonpt;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadImg {

	private static final Log log = LogFactory.getLog(DownloadImg.class);
	
	/**
	 * ץȡͼƬ���Ŀ¼
	 */
	private static final String PIC_DIR = "f:/pic";
	
	/**
	 * ���ӳ�ʱ
	 */
	private static final int TIME_OUT = 5000;
	
	static void go3(String url) throws Exception {
        Connection conn= Jsoup.connect(url);
        Document doc = conn.get();
        Elements links = doc.select("div.piclist img[src]");
        for(int i=0;i<links.size();i++){
            Element element = links.get(i);
            final String imgUrl = element.attr("src");
            log.info(imgUrl);
            Thread.sleep(500);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        save(imgUrl);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
	
	static void go2(String url) throws Exception {
	    Connection conn= Jsoup.connect(url);
	    Document doc = conn.get();
	    Elements links = doc.select("div.cc a[href]");
	    for(int i=0;i<links.size();i++){
	        Element element = links.get(i);
	        final String dirUrl = "http://www.3lian.com"+element.attr("href");
	        log.info(dirUrl);
	        Thread.sleep(500);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Connection conn= Jsoup.connect(dirUrl);
                        Document doc = conn.get();
                        Elements images = doc.select("div.mb_jjnr img[src]");
                        for(int j=0;j<images.size();j++){
                            Element img = images.get(j);
                            String imgUrl = img.attr("src");
                            log.info(imgUrl);
                            save(imgUrl);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
	    }
    }
	
	/**
	 * ��������URL
	 * @param url
	 * @throws Exception
	 */
	static void go(String url) throws Exception {
		// JSOP��������
		Connection conn = Jsoup.connect(url);
		// ���󷵻�����ĵ�����
		Document doc = conn.post();
		// ѡ������class=zoom ��img��ǩ����
		Elements imgs = doc.select("img[class=zoom]");
		// ѭ��ÿ��img��ǩ
		for (int i = 0; i < imgs.size(); i++) {
			Element img = imgs.get(i);
			// ȡ��ͼƬ�����ص�ַ
			String picURL = doc.baseUri() + img.attr("file");
			log.info(picURL);
			// ����ͼƬ
			save(picURL);
		}
	}
	
	//<img src="static/image/common/none.gif" file="data/attachment/forum/201105/08/174412nz3jq4z90s33s2t0.jpg" width="770" class="zoom" onclick="zoom(this, this.src)" id="aimg_180565" onmouseover="showMenu({'ctrlid':this.id,'pos':'12'})" alt="img_src_29620.jpg" title="img_src_29620.jpg" />
	//doc.select("img[class=zoom]")
	/**
	 * ����ͼƬ
	 * @param url
	 * @param i
	 * @throws Exception
	 */
	static void save(String url) throws Exception {
		String fileName = url.substring(url.lastIndexOf("/"));
		String filePath = PIC_DIR + "/" + fileName;
		BufferedOutputStream out = null;
		byte[] bit = getByte(url);
		if (bit.length > 0) {
			try {
				out = new BufferedOutputStream(new FileOutputStream(filePath));
				out.write(bit);
				out.flush();
				log.info("Create File success! [" + filePath + "]");
			} finally {
				if (out != null)
					out.close();
			}
		}
	}
	
	/**
	 * ��ȡͼƬ�ֽ���
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	static byte[] getByte(String uri) throws Exception {
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIME_OUT);
		HttpGet get = new HttpGet(uri);
		get.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIME_OUT);
		try {
			HttpResponse resonse = client.execute(get);
			if (resonse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = resonse.getEntity();
				if (entity != null) {
					return EntityUtils.toByteArray(entity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return new byte[0];
	}

	public static void main(String[] args) throws Exception {
		// ��ʼץȡͼƬ
	    go2("http://www.3lian.com/gif/more/03/0301.html");
		//go3("http://www.ivsky.com/tupian/nvxing_gouwu_qingjing_v6969/");
	}
}