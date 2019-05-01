package annotation;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

import javax.swing.JFrame;

/**
 * Type Annotation可以让编译器执行更严格的代码检查，从而提高程序的健壮性
 * 
 * @author Castle
 *
 */
@NotNull
public class TypeAnnotationTest implements @NotNull Serializable {
	public static void main(@NotNull String[] args) throws @NotNull FileNotFoundException {
		Object obj = "fkjava.org";
		String str = (@NotNull String) obj;
		Object win = new @NotNull JFrame("java");
	}

	public void foo(List<@NotNull String> info) {

	}
}

@Target(ElementType.TYPE_USE)
@interface NotNull {

}