package test;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * MobileOlineController.java Base64 编码解码
 * 
 * @author Castle
 *
 */
public class PuppyBase64 {
    private void saveImg(HttpServletRequest request, String fileFullPath) {
        OutputStream out = null;
        try {
            String file = request.getParameter("file");
            file = file.replaceAll("\r|\n", "");
            file = file.replaceAll(" ", "+");
            BASE64Decoder decoder = new BASE64Decoder();

            byte[] b = decoder.decodeBuffer(file);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out = new FileOutputStream(fileFullPath);
            out.write(b);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out)
                    out.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }
}
