package test.iterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 再次输出集合，可以看到赋值语句不起作用——当使用Iterator遍历集合时，Iterator并不是把集合元素本身传给迭代变量，
 * 而是把集合元素的值复制给了迭代变量，所以修改迭代变量的值对集合元素本身没有任何影响
 * 
 * @author Castle
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add("Twilight Saga");
		books.add("Spiderman");
		books.add("Glance");
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			String book = it.next();
			if (book.equals("Glance")) {
				book = "Bible";
			}
		}
		// [Glance, Twilight Saga, Spiderman]
		System.out.println(books);
	}
}
