package cutPicture.wyd;

import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;

/**
 * 批量生成缩略图
 * 
 * @author 黄嘉明
 * @version 2016年10月24日
 */
public class ImageUtil {
	private static String	originFolder		= Config.props.getProperty("origin_folder");
	private static String	destinationFolder	= Config.props.getProperty("destination_folder");
	private static String	maxWidth			= Config.props.getProperty("max_width");
	private static String	maxHeight			= Config.props.getProperty("max_height");
	private static int		MAXWidth			= Integer.parseInt(maxWidth);
	private static int		MAXHeight			= Integer.parseInt(maxHeight);

	public static void main(String[] args) throws IOException {
		File folder = new File(originFolder);
		if (!folder.exists()) {
			throw new IOException("依据配置文件，初始文件夹 " + originFolder + " 找不到");
		}
		File[] listOfFiles = folder.listFiles();
		File folder2 = new File(destinationFolder);
		if (!folder2.exists()) {
			folder2.mkdir();
		}
		int count = listOfFiles.length;
		System.out.println("Total count of Files:" + count);
		for (int i = 0; i < count; i++) {
			System.out.print("Deal with " + (i + 1) + " of " + count + "\t");
			resize(listOfFiles[i], new File(destinationFolder + File.separator + listOfFiles[i].getName()), 1f);
			System.out.println("picture of " + (i + 1) + " complete");
		}
		System.out.println("missson complete.");
	}

	public static void resize(File originalFile, File resizedFile, float quality) throws IOException {
		if (quality > 1) {
			throw new IllegalArgumentException("Quality has to be between 0 and 1");
		}
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);// original image width
		int iHeight = i.getHeight(null);// original image height
		if (iWidth > MAXWidth && iHeight > MAXHeight) {
			int newWidth = 0;
			int newHeight = 0;
			if (iWidth > iHeight) {
				newWidth = MAXWidth;
				newHeight = (MAXWidth * iHeight) / iWidth;
			} else {
				newHeight = MAXHeight;
				newWidth = (MAXHeight * iWidth) / iHeight;
			}
			resizedImage = i.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			// This code ensures that all the pixels in the image are loaded.
			Image temp = new ImageIcon(resizedImage).getImage();
			// Create the buffered image.
			BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// Copy image to buffered image.
			Graphics g = bufferedImage.createGraphics();
			// Clear background and paint the image.
			g.setColor(Color.white);
			g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
			g.drawImage(temp, 0, 0, null);
			g.dispose();
			// Soften.
			float softenFactor = 0.05f;
			float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0,
					softenFactor, 0 };
			Kernel kernel = new Kernel(3, 3, softenArray);
			ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
			bufferedImage = cOp.filter(bufferedImage, null);
			// Write the jpeg to a file.
			FileOutputStream out = new FileOutputStream(resizedFile);
			// Encodes image as a JPEG data stream
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);
			param.setQuality(quality, true);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(bufferedImage);
		}
	}
}