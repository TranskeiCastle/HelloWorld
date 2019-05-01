package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 
 * @author chenpu
 *
 */
public class ZipUtil {

	public static String makeZip(File[] files, String savePath, String zipName) {
		zipName += ".zip";
		byte[] buffer = new byte[1024];
		String zipPath = savePath + File.separator + zipName;
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath));
			for (int i = 0; i < files.length; i++) {
				FileInputStream fis = new FileInputStream(files[i]);
				out.putNextEntry(new ZipEntry(files[i].getName().substring(files[i].getName().lastIndexOf("@@") + 2)));
				// 设置压缩文件内的字符编码，不然会变成乱码
				//out.setEncoding("gbk");
				int len;
				// 读入需要下载的文件的内容，打包到zip文件
				while ((len = fis.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				out.closeEntry();
				fis.close();
			}
			out.close();
			// this.downFile(getResponse(), tmpFileName);
			return zipPath;
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		File[] files = {new File("c:/jQuery-EasyUI-1.4.2.chm"),new File("c:/jquery1.8.3_20121129.chm")};
		String savePath = "c:/";
		String zipName = "test";
		ZipUtil.makeZip(files, savePath, zipName);
	}
}