# 一级
## 二级
### 三级
**粗体**<br>
*斜体*<br />
***粗体加斜体***<hr>

普通文本：Java代码<br>
<!--加上编程语言的名字-->
```java
public static void main(String[] args) {
        System.out.println("Hello World");
    }
```
<!--两个空格表示换行-->
> 桃花坞里桃花庵，桃花庵下桃花仙；桃花仙人种桃树，又摘桃花卖酒钱。  
> 酒醒只在花前坐，酒醉还来花下眠；半醒半醉日复日，花落花开年复年。  

[点击前往谷歌](https://www.google.com)


![图片不见了](https://github.com/TranskeiCastle/HelloWorld/blob/master/boot.jpg)


<hr>
### JUnit 注解支持参数的，一个是 timeout，另一个是 throws，可以通过注解的 Java Doc 了解
#### 亏我以前写测试方法的时候都使用 main
#### JUnit @Test注解要求方法签名必须是public void的，在 Eclipse 里面当一个类包含多个测试用例的时候，
#### 右键-> Run as JUnit Test，会执行所有用例；
#### 双击方法名，选中方法，右键-> Run as JUnit Test，只会执行选中的这个用例；控制台看得出来，Runs: 2/2 Errors:0 Failures: 0这样。
