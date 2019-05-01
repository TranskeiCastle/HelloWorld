/**
 * 
 * JUnit 注解支持参数的，一个是 timeout，另一个是 throws，可以通过注解的 Java Doc 了解
 * 
 * 亏我以前写测试方法的时候都使用 main
 * 
 * JUnit @Test注解要求方法签名必须是public void的，当一个类包含多个测试用例的时候，右键-> Run as JUnit
 * Test，会执行所有用例；双击方法名，选中方法，右键-> Run as JUnit Test，只会执行选中的这个用例；控制台看得出来，Runs: 2/2
 * Errors:0 Failures: 0这样。
 * 
 * @author Castle
 *
 */
package date;