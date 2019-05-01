package jsoup;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 抓取电视猫网站上的节目单(一级页面)，节目封面、剧照、简介、类型(二级页面)
 * 
 * @author 黄嘉明
 * @version 2017年10月23日
 */
public class ExtractingData2 {
	public static void main(String[] args) throws IOException {
		String url = null;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		// dayOfWeek代表一周的第几天，case1是周日，case2是周一。。。
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w7.html";
			break;
		case 2:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w1.html";
			break;
		case 3:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w2.html";
			break;
		case 4:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w3.html";
			break;
		case 5:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w4.html";
			break;
		case 6:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w5.html";
			break;
		case 7:
			url = "http://www.tvmao.com/program/AHTV-AHTV1-w6.html";
			break;
		}
		// 标记开始时间
		long start = System.currentTimeMillis();
		// 将要解析的html对象
		Document doc = null;
		doc = Jsoup.connect(url).timeout(8000)
				.header("user-agent",
						"Chrome/39.0.2171.95 Mozilla/5.0 (Windows NT 6.2; WOW64)  AppleWebKit/26.0.1400.0  Safari/7.0.5 (9537.77.4)")
				.get();
		// 定位至上述html页面上的div/pgmain/h1标签
		// 得到电视台图标和名称
		Element logo = doc.select("div.pgmain").select("h1").select("img").first();
		System.out.println("电视台图标：" + logo.attr("src"));
		System.out.println("电视台名称：" + logo.attr("alt"));
		// 得到播放日期
		Elements date = doc.select("div.mt10").select("b");
		System.out.println("播放日期：" + date.text().split(" ")[0]);
		Elements items = doc.select("div.pgmain").select("li");
		for (Element item : items) {
			// 打印时间以及节目名称
			if (item.getElementsByTag("li").text().split(" ").length >= 2) {
				System.out.println("播出时间: " + item.getElementsByTag("span").text());
				System.out.println("节目名称: " + item.getElementsByTag("li").text().split(" ")[1]);
			} else
				;
			// 由每个item下的<a>标签得到节目的绝对路径url2，该节目的其余资源全部在此路径下
			String url2;
			Elements e = item.getElementsByTag("a");
			if (e.size() == 0) {
				continue;
			} else {
				url2 = e.first().absUrl("href");
				String tvSpecies = url2.split("./")[2];
				String tvCode = url2.split("./")[3];
				System.out.println("===============species：" + tvSpecies);
				System.out.println("===============code：" + tvCode);
			}
			/* docSummary表示概要，点击节目名字后跳到的界面：集数、主演、语言、年份等等，这里仅抽取“类别” */
			// ******************类别开始******************
			Document docSummary = Jsoup.connect(url2)
					.header("user-agent",
							"Chrome/39 Mozilla/5.0 (Windows NT 6.2; WOW64)  AppleWebKit/26.0.1400.0  Safari/7.0.5 (9537.77.4)")
					.timeout(8000).get();
			Elements itemsSummary = docSummary.select("div.lt").select("table").select("tr");
			for (Element itemSummary : itemsSummary) {
				if (itemSummary.getElementsContainingText("类别").size() > 0) {
					System.out.println("类别： " + itemSummary.text());
				}
			}
			// ******************类别结束******************
			// ******************简介开始******************
			Elements briefs = docSummary.select("div.lessmore").select("p");
			if (briefs.size() > 0) {
				System.out.println("简介：" + briefs.first().ownText());
			} else {
				System.out.println("简介：" + docSummary.select("article").select("p").text());
			}
			// ******************简介结束******************
			// 当item节点下包含“剧照”二字时，拼接剧照所在网址，循环打印图片全路径
			int picturesNum = item.getElementsContainingOwnText("剧照").size();
			System.out.println(picturesNum > 0 ? "是否包含图片？是" : "是否包含图片？否");
			while (picturesNum > 0) {
				System.out.println("图片地址为：" + url2 + "/picture");
				// 由节目路径拼接出剧照路径
				Document docOfPicture = Jsoup.connect(url2 + "/picture?start=0")
						.header("user-agent",
								"Chrome/39 Mozilla/5.0 (Windows NT 6.2; WOW64)  AppleWebKit/26.0.1400.0  Safari/7.0.5 (9537.77.4)")
						.timeout(8000).get();
				// 定位至<img>标签，找到剧照
				Elements items2 = docOfPicture.select("div.section-wrap").select("img");
				// 查找剧照分页信息，单页剧照与多页剧照的获得方式不同，多页剧照需要另外拼接地址获得
				Elements pageInfo = docOfPicture.select("div.page");
				// System.out.println(pageInfo.text());//共2页 1 2 下一页 最后页
				// 获取“共N页”信息，当超过1页时，势必出现“ ”，以此分割得到空格左边“共N页”信息
				String pageSum = pageInfo.text().split(" ")[0];
				if (pageSum.isEmpty()) {
					// 剧照只有单页
					System.out.println("缩略图页数：" + "仅1页～～～");
					for (Element item2 : items2) {
						System.out.println(item2.absUrl("src") + "\t" + item2.attr("alt"));
					}
				} else {
					// 剧照有多页
					System.out.println("缩略图页数：" + pageSum);
					// 得到页数
					int pages = Integer.parseInt(pageSum.substring(1, pageSum.length() - 1));
					// 根据缩略图页数拼接所有图片链接，每页28张图
					for (int n = 1; n <= pages; n++) {
						Document doc3 = Jsoup.connect(url2 + "/picture?start=" + (n - 1) * 28)
								.header("user-agent",
										"Chrome/39 Mozilla/5.0 (Windows NT 6.2; WOW64)  AppleWebKit/26.0.1400.0  Safari/7.0.5 (9537.77.4)")
								.timeout(8000).get();
						Elements items3 = doc3.select("div.section-wrap").select("img");
						for (Element item3 : items3) {
							System.out.println(item3.absUrl("src") + "\t" + item3.attr("alt"));
						}
					}
				}
				picturesNum--;
			}
		}
		// 标记结束时间
		long finish = System.currentTimeMillis();
		System.out.println("\n\nTotal items：" + items.size());
		System.out.println("Costs " + (finish - start) + "ms to fetch datas.");
	}
}