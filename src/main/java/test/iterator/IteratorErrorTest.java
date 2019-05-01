package test.iterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 当使用iterator迭代访问Collection集合元素时，Collection集合里的元素不能被改变(但是通过Iterator的remove()
 * 方法删除上一次next()方法返回的集合元素是允许的)，否则将导致java.util.ConcurrentModificationException。
 * 
 * 
 * Iterator采用的是快速失败(fail-fast)机制，一旦在迭代过程中检测到集合已经被修改(通常是程序中的其他线程修改)，
 * 程序立即抛出ConcurrentModificationException，而不是显式修改后的结果，这样可以避免共享资源而引发的潜在问题。
 * 
 * @author Castle
 *
 */
public class IteratorErrorTest {
	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add("Twilight Saga");
		books.add("Spiderman");
		books.add("Glance");
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Glance")) {
				// 不会引发异常
				it.remove();
				// java.util.ConcurrentModificationException
				// books.remove(it.next());
				// java.util.ConcurrentModificationException
				// books.remove("Glance");
			}
		}
		// 正常输出结果是[Twilight Saga, Spiderman]
		System.out.println(books);
	}
}
