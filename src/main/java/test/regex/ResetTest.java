package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResetTest {
	public static void main(String[] args) {
		String[] mails = { 
				"castle@163.com", 
				"transkei@gmail.com", 
				"bnuz.edu.cn", 
				"ABC@abc.xx" };
		String regex = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		for (String mail : mails) {
			if (matcher == null) {
				matcher = pattern.matcher(mail);
			} else {
				matcher.reset(mail);
			}
			String result = mail + 
					(matcher.matches() ? " 是": " 不是") + "一个有效的邮箱地址";
			System.out.println(result);
		}
	}
}
