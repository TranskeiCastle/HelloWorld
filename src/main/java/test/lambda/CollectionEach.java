package test.lambda;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * interface Collection<E> extends Iterable<E>
 * 
 * Java 8 为Iterable接口新增了一个forEach(Consumer
 * action)默认方法，该方法所需参数的类型是一个函数式接口，而Collection接口继承了Iterable接口，
 * 因此Collection对象也可以调用forEach方法。正因为Consumer是函数式接口，因此可以使用Lambda表达式来遍历集合元素。
 * 
 * @author Castle
 *
 */
public class CollectionEach {
	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add("Twilight Saga");
		books.add("Spiderman");
		books.add("Glance");
		// 遍历方法一
		books.forEach(element -> System.out.println(element));

		// 遍历方式二
		Iterator<String> it = books.iterator();
		it.forEachRemaining(obj -> System.out.println(obj));
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}

		// 遍历方式三
		for(String str: books) {
			System.out.println(str);
		}
	}
}
