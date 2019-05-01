package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsingLocalStr {
	public static void main(String[] args) {
		{
			StringBuilder html = new StringBuilder();
			html.append("<html>\n");
			html.append("	<body>\n");
			html.append("		<table>\n");
			html.append("			<tr>\n");
			html.append("				<td>1row，1column；</td>\n");
			html.append("				<td>1row，2column；</td>\n");
			html.append("			</tr>\n");
			html.append("			<tr>\n");
			html.append("				<td>2row，1column；</td>\n");
			html.append("				<td>2row，2column；</td>\n");
			html.append("			</tr>\n");
			html.append("		</table>\n");
			html.append("	</body>\n");
			html.append("</html>");
			Document doc = Jsoup.parse(html.toString());
			Elements es = doc.select("table").select("tr").select("td:eq(1)");// 1row，2column；
			Elements es2 = doc.select("table").select("tr:eq(1)").select("td:eq(1)");// 2row，2column；
			System.out.println("---------------->" + es.text());
			System.out.println("=========>>" + es2.text());
		}
	}
}
