package collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		// 向Properties添加属性
		prop.setProperty("username", "puppy");
		prop.setProperty("password", "123456");
		// 将配置保存到文件
		prop.store(new FileOutputStream("a.ini"), "comment statement");

		Properties prop2 = new Properties();
		// 使用put方法也可以
		prop2.setProperty("gender", "male");
		// 将文件内容追加到prop2
		prop2.load(new FileInputStream("a.ini"));
		// {password=123456, gender=male, username=puppy}
		System.out.println(prop2);
	}
}
