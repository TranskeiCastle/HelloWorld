package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Repeatable(FkTags.class)定义了一个重复注解
 * 
 * 其中@FkTag，它的“容器”是FkTags
 * 
 * @author Castle
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(FkTags.class)
public @interface FkTag {
	String name() default "dog";

	int age();
}
