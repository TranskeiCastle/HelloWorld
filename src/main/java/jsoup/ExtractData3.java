package jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractData3 {
	public static void main(String[] args) throws IOException, ParseException {
		String userAgent = "Chrome/39 Mozilla/5.0 (Windows NT 6.2; WOW64)  AppleWebKit/26.0.1400.0  Safari/7.0.5 (9537.77.4)";
		// 北京卫视
		String url = "http://epg.tvsou.com/programys/TV_1/Channel_16/W1.htm";
		long start = System.currentTimeMillis();
		Document doc = Jsoup.connect(url).timeout(60000).header("user-agent", userAgent).get();
		// 播放日期
		String dateAndWeek = doc.select("div#epg_m3").first().text();
		String dateAndWeek2 = dateAndWeek.split(" ")[1].trim();// 2013年1月3日
		System.out.println("提取出来的日期: " + dateAndWeek2);
		String dateAndWeek3 = dateAndWeek2.replaceAll("[\u4e00-\u9fff]", "-").substring(1, dateAndWeek2.length() - 2);// 2013-1-3
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateAndWeek3);
		String dateAndWeek4 = sdf.format(date);
		System.out.println("转换成数据库格式: " + dateAndWeek4);
		// 时间、节目名称
		Elements timeAndName = doc.select("div#con2").select("div#PMT1, div#PMT2");
		System.out.println("播放时间\t\t节目名称: ");
		for (Element e : timeAndName) {
			System.out.println(e.select("b").text() + "\t\t" + e.select("div#e2").text());
			String url2 = e.select("div#e2").first().getElementsByTag("a").attr("href");
			System.out.println("url2:" + url2);
			if (url2.length() == 0) {
				continue;
			} else {
				Document doc2 = Jsoup.connect(url2).timeout(60000).get();
				// 剧照
				String pictureUrl = doc2.select("table.img2").select("img").attr("src");
				System.out.println("pictureUrl:" + pictureUrl);
				// 类型
				Elements type = doc2.select("div#bcxx");
				String typeInfo = type.text();
				if (typeInfo.contains("类型")) {
					System.out.println("类型======================" + typeInfo.split(" ")[1]);
				}
				// 简介
				Elements summary = doc2.select("div#content").select("table:eq(1)").select("tr:eq(1)")
						.select("td:eq(2)").select("table:eq(2)");
				String s1 = summary.text();
				String s2 = summary.select("a").text();
				String summaryInfo = s1.substring(0, s1.indexOf(s2));
				System.out.println("简介>>>>>>>>>>>>>>>>>>>>>>>>>" + summaryInfo);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("costs: " + (end - start) + "ms");
	}
}
