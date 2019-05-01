package edu.bnuz;

/**
 * JLS 4.8 Raw Types A raw type is defined to be one of:
 * 
 * (1)The reference type that is formed by taking the name of a generic type
 * declaration without an accompanying type argument list.
 * 
 * (2)An array type whose element type is a raw type.
 * 
 * (3)A non-static member type of a raw type R that is not inherited from a
 * superclass or superinterface of R.
 * 
 * @author Castle
 *
 * @param <E>
 */
public class MyType_06<E> {
	class Inner {
	}

	static class Nested {
	}

	public static void main(String[] args) {
		MyType_06 mt; // warning: MyType_06 is a raw type
		MyType_06.Inner inn; // warning: MyType_06.Inner is a raw type

		MyType_06.Nested nest; // no warning: not parameterized type
		MyType_06<Object> mt1; // no warning: type parameter given
		MyType_06<?> mt2; // no warning: type parameter given (wildcard OK!)
	}
}

/**
 * Here, MyType<E> is a parameterized type (JLS 4.5). It is common to
 * colloquially refer to this type as simply MyType for short, but technically
 * the name is MyType<E>.
 * 
 * mt has a raw type (and generates a compilation warning) by the first bullet
 * point in the above definition; inn also has a raw type by the second bullet
 * point.
 * 
 * MyType.Nested is not a parameterized type, even though it's a member type of
 * a parameterized type MyType<E>, because it's static.
 * 
 * mt1, and mt2 are both declared with actual type parameters, so they're not
 * raw types.
 */