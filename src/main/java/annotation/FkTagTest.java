package annotation;

/**
 * 从API来理解好像方法getDeclaredAnnotation(annotationClass)是获取当前的、直接的注解元素，
 * 如果annotationClass不是当前类的注解的话就返回null
 * 
 * @author Castle
 *
 */
@FkTag(age = 5)
@FkTag(name = "cat", age = 9)
public class FkTagTest {
	public static void main(String[] args) {
		Class<FkTagTest> clazz = FkTagTest.class;
		FkTag[] tags = clazz.getDeclaredAnnotationsByType(FkTag.class);
		for (FkTag tag : tags) {
			System.out.println(tag.name() + "-->" + tag.age());
		}
		FkTags[] tagss = clazz.getDeclaredAnnotationsByType(FkTags.class);
		System.out.println(tagss.length);
		// 获取修饰FkTagTest类的@FkTags注解
		// 输出@test.annotation.FkTags(
		// value=[@test.annotation.FkTag(name=dog, age=5),
		// @test.annotation.FkTag(name=cat, age=9)])
		FkTags container = clazz.getDeclaredAnnotation(FkTags.class);
		System.out.println(container);
		// 输出null——该方法根据指定类型的Annotation尝试获取直接修饰该程序的元素，如果该类型的注解不存在，则返回null
		FkTag container2 = clazz.getDeclaredAnnotation(FkTag.class);
		System.out.println(container2);
	}
}
