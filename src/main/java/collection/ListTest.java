package collection;

import java.util.Arrays;
import java.util.List;

/**
 * 固定长度的List
 * 
 * @author Castle
 *
 */
public class ListTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Glance", "Bible", "Android");
		// class java.util.Arrays$ArrayList
		System.out.println(list.getClass());
		list.forEach(obj -> System.out.println(obj));
		// Runtime exception: UnsupportedOperationException
		list.add("a new book");
		list.remove("Android");
	}
}
