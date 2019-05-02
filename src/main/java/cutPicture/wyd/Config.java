package cutPicture.wyd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static Properties props = new Properties();
	// 加载配置文件
	static {
		try {
			InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties");
			props.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
