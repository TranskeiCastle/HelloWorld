package cutPicture.bnuz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 压缩图片
 * <p>
 * 通过修改 writeHighQuality 方法 setQuality 的参数修改缩略图的大小
 * 
 * @author 黄嘉明
 * @version 2017年10月23日
 */
public class NarrowImage {
	public static void main(String[] args) {
		// 原图全地址，要保证路径及文件真实存在
		String sourceObject = "sourceImgFolder/night.jpg";
		// 目标文件全地址，指定路径及文件名，路径必须存在，图片文件会由程序生成
		String targetObject = "targetImgFolder/smaller-night.jpg";
		File sourceFile = new File(sourceObject);
		if (!sourceFile.exists()) {
			System.out.println("原始文件不存在：" + sourceObject);
			return;
		}
		File targetFile = new File(targetObject.substring(0, targetObject.indexOf("/")));
		if (!targetFile.exists()) {
			System.out.println("目标文件夹不存在");
			return;
		}
		NarrowImage narrowImage = new NarrowImage();
		narrowImage.writeHighQuality(narrowImage.zoomImage(sourceObject), targetObject);
	}

	public boolean writeHighQuality(BufferedImage bufferedImage, String fileFullPath) {
		try {
			// 输出到文件流
			FileOutputStream newimage = new FileOutputStream(fileFullPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);
			// 压缩质量，直接影响图片大小
			jep.setQuality(0.25f, true);
			encoder.encode(bufferedImage, jep);
			newimage.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public BufferedImage zoomImage(String src) {
		// result代表处理后返回的图像
		BufferedImage result = null;
		try {
			File srcfile = new File(src);
			if (!srcfile.exists()) {
				System.out.println("文件不存在");
			}
			// bufferedImage代表原始图像
			BufferedImage bufferedImage = ImageIO.read(srcfile);
			// 原始图像的宽度和高度
			int realWidth = bufferedImage.getWidth();
			int realHeight = bufferedImage.getHeight();
			/**
			 * 压缩计算
			 */
			// 这个参数用于调整长宽
			float resizeTimes = 0.3f;
			// 调整后的图片的宽度和高度
			int toWidth = (int) (realWidth * resizeTimes);
			int toHeight = (int) (realHeight * resizeTimes);
			// 生成结果图片
			result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);
			result.getGraphics().drawImage(
					bufferedImage.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
		} catch (Exception e) {
			System.out.println("创建缩略图发生异常" + e.getMessage());
		}
		System.out.println("缩略图创建完成");
		return result;
	}
}
