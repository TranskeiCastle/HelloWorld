package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
	public static void main(String[] args) {
		String str = "发件人：13750012345。你已为用户15050012345充值100元。收件人：18950012345";
		// 匹配13、15开头的手机号码
		String rex = "((13\\d)|(15\\d))\\d{8}";
		Matcher m = Pattern.compile(rex).matcher(str);
		// 程序输出13750012345/15050012345两个手机号码
		// 0000m.find(start)怎么用？
		while (m.find()) {
			System.out.println(m.group());
		}
		System.out.println(m.lookingAt());
	}
}