package collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 生成“只读”的集合
 * 
 * @author Castle
 *
 */
public class UnmodifiableTest {
	public static void main(String[] args) {
		List<String> unmodifiableList = Collections.emptyList();
		Set<String> unmodifiableSet = Collections.singleton("Glance");
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Java", 86);
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(scores);
		// 下面任一行代码都将引发UnsupportedOperationException
		unmodifiableList.add("test element");
		unmodifiableSet.add("test elements");
		unmodifiableMap.put("Enlish", 99);
	}
}
