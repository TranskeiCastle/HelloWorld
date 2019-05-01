package lambdaMethodRef;

/**
 * 我发现这个接口加不加 @FunctionalInterface 都可以呢。
 * 
 * 加上注解，添加另一个抽象方法，编译错误：
 * 
 * Invalid '@FunctionalInterface' annotation; Convert is not a functional
 * interface
 * 
 * 应该是加了就代表这个类只能有一个抽象方法。
 * 
 * @author Castle
 *
 */
public interface Convert {
    Integer convert(String from);
}
