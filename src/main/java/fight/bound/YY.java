package fight.bound;

/**
 * super.getClass()返回的是运行时类。YY继承了Date，在YY里，不管是this.getClass()还是super.getClass()，返回的都是YY——这个比Date更具体的类
 * 
 * @author BigBoss
 *
 */
public class YY extends java.util.Date {
    public static void main(String[] args) {
        new YY().yy();
    }

    public void yy() {
        // YY的全限定名
        System.out.println(this.getClass().getName());
        // YY的全限定名
        System.out.println(super.getClass().getName());
        // java.util.Date
        System.out.println(this.getClass().getSuperclass().getName());
        // java.util.Date
        System.out.println(super.getClass().getSuperclass().getName());
        // java.lang.Object，如果再getSuperClass()就报空指针了
        System.out.println(super.getClass().getSuperclass().getSuperclass().getName());
    }
}
