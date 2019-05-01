package jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class SetHeader {
    @Test
    public void setHeader() throws IOException {
        // Document parse = Jsoup.parse(new
        // URL("http://info.bet007.com/cn/team/Summary.aspx?TeamID=35"), 10000);
        // Document parse = Jsoup.parse(new URL("http://www.baidu.com"), 10000);
        // Connection connect = Jsoup.connect("http://www.bing.com/");
        Connection connect = Jsoup.connect("http://www.baidu.com");
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "http://info.bet007.com");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
        header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        header.put("Accept-Language", "zh-cn,zh;q=0.5");
        header.put("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
        header.put("Connection", "keep-alive");
        Connection data = connect.data(header);
        Document document = data.get();
        System.out.println(document.html());
    }
}
