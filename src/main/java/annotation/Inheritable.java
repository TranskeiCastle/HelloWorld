package annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 说明：注解@Inherited表明@Inheritable具有继承性，
 * 
 * 也就是说，如果某个类使用了@Inheritable修饰， 则该类的子类将自动使用@Inheritable修饰
 * 
 * 这样的写法——其他程序在使用注解的时候，用的是@Inheritable
 * 
 * @author Castle
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {

}
