package cn.com.sky.tools.test_zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public class ZipFileTool {
	public static void zip(String path, String out) throws IOException {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(out);
			zip(path, os);
		} finally {
			if (os != null)
				os.close();
		}
	}

	public static void zip(String path, OutputStream os) throws IOException {
		File f = new File(path);
		if (!f.exists())
			return;
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(os);
			zos.setEncoding(getSysCharset());
			zip(f, f.getName(), zos);
		} finally {
			if (zos != null)
				zos.close();
		}
	}

	/**
	 * @param parent
	 * @param entities
	 * @param base
	 * @param out
	 * @throws IOException
	 */
	public static void zip(String parent, List entities, String base, String out)
			throws IOException {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(out);
			ZipFileTool.zip(parent, entities, base, os);
		} finally {
			if (os != null)
				os.close();
		}
	}

	public static void zip(String parent, List entities, String base,
			OutputStream os) throws IOException {
		File p = new File(parent);
		if (!p.exists() || !p.isDirectory())
			return;// TODO:exception
		if (base == null)
			base = "";
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(os);
			zos.setEncoding(getSysCharset());

			for (int i = 0; i < entities.size(); i++) {
				String en = (String) entities.get(i);
				File enf = new File(parent + File.separator + en);
				if (!enf.exists())
					continue;
				zip(enf, base + en, zos);
			}
		} finally {
			if (zos != null)
				zos.close();
		}
	}

	private static void zip(File f, String name, ZipOutputStream os)
			throws IOException {
		if (f.isDirectory()) {
			ZipEntry ze = new ZipEntry(name + "/");
			os.putNextEntry(ze);
			File[] files = f.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					zip(files[i], name + "/" + files[i].getName(), os);
				}
			}
		} else {
			ZipEntry ze = new ZipEntry(name);
			os.putNextEntry(ze);
			writeStream(f, os);
		}
	}

	private static String getSeperator() {
		if (File.separator.equals("\\"))
			return "\\\\";
		else
			return File.separator;
	}

	public static void unZip(String zipFile, String outFolder)
			throws IOException {
		unZip(new File(zipFile), outFolder);
	}

	public static void unZip(File zipFile, String outFolder) throws IOException {
		ZipFile zip = null;
		try {
			zip = new ZipFile(zipFile);
			ZipEntry zen;
			Enumeration enu = zip.getEntries();
			while (enu.hasMoreElements()) {
				zen = (ZipEntry) enu.nextElement();
				String name = outFolder + File.separator
						+ getSysFileName(zen.getName());
				if (zen.isDirectory()) {
					File tf = new File(name);
					tf.mkdirs();
				} else {
					InputStream is = zip.getInputStream(zen);
					try {
						writeStream(is, name);
					} finally {
						if (is != null)
							is.close();
					}
				}
			}
		} finally {
			if (zip != null)
				zip.close();
		}
	}

	/**
	 * @param zipFile
	 * @return
	 * @throws IOException
	 */
	public static File unZip(File zipFile) throws IOException {
		File outf = new File(zipFile.getAbsolutePath() + "_temp");
		if (!outf.mkdir()) {
			throw new IOException("faild to create temporary folder:"
					+ zipFile.getAbsolutePath() + "_temp");
		}
		unZip(zipFile, outf.getAbsolutePath());
		return outf;
	}

	/**
	 * @param file
	 * @return
	 */
	private static boolean ensureParent(File file) {
		String ps = file.getParent();
		File parent = new File(ps);
		if (!(parent.exists() && parent.isDirectory()))
			return parent.mkdirs();
		return true;
	}

	public static int READ_BUFFER = 1024;

	/**
	 * @param is
	 * @param oFile
	 * @throws IOException
	 */
	private static void writeStream(InputStream is, String oFile)
			throws IOException {
		File outFile = new File(oFile);
		if (outFile.exists()) {
		}
		if (!ensureParent(outFile)) {
			throw new IOException(
					"faild while try to create directories the for the output file");
		}
		outFile.createNewFile();
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outFile);
			writeStream(is, new FileOutputStream(oFile));
		} finally {
			if (os != null)
				os.close();
		}
	}

	/**
	 * @param iFile
	 * @param os
	 * @throws IOException
	 */
	private static void writeStream(File iFile, OutputStream os)
			throws IOException {
		InputStream is = null;
		try {
			is = new FileInputStream(iFile);
			writeStream(is, os);
		} finally {
			if (is != null)
				is.close();
		}
	}

	public static void writeStream(InputStream is, OutputStream os)
			throws IOException {
		byte[] buff = new byte[READ_BUFFER];
		int rl;
		while ((rl = is.read(buff, 0, buff.length)) > 0) {
			os.write(buff, 0, rl);
		}
	}

	public static String getSysFileName(String oriFileName)
			throws UnsupportedEncodingException {
		String re = new String(oriFileName.getBytes(getSysCharset()));
		return re.replace('\\', '/');
	}

	public static String getSysCharset() {
		return System.getProperty("file.encoding");
	}

	public static void main(String[] args) throws IOException {
		// unZip("c:\\ua.zip", "c:\\temp");
		zip("f:\\temp", "f:\\temp.zip");

		// List subs=new ArrayList();
		// subs.add("temp");
		// subs.add("ua.zip");
		// zip("c:", subs, "", "c:\\xxx.zip");
	}
}
