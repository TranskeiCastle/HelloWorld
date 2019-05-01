package date;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarDemo {
    @Test
    public void myTest() {
        Calendar calendar = Calendar.getInstance();
        // 当被修改的字段超出它允许的范围时，会发生进位，即上一级字段也会增大
        // 2003-8-23
        calendar.set(2003, 7, 23, 0, 0, 0);
        // 2003-8-23 => 2004-2-23
        calendar.add(Calendar.MONTH, 6);
        Date date = calendar.getTime();
        System.out.println(date);

        Calendar calendar2 = Calendar.getInstance();
        // 如果下一级字段也需要改变，那么该字段会修正到变化最小的值
        // 2003-8-31
        calendar2.set(2003, 7, 31, 0, 0, 0);
        // 2003-8-31 => 2004-2-29
        // 进位后月份变为2月，因为2月没有31号，并且2004年是闰年，于是变成29号
        calendar2.add(Calendar.MONTH, 6);
        Date date2 = calendar2.getTime();
        System.out.println(date2);

        Calendar calendar3 = Calendar.getInstance();
        // 当被修改的字段超出它允许的范围时，roll不会使上一级字段增大，但它进位了
        // 2003-8-23
        calendar3.set(2003, 7, 23, 0, 0, 0);
        // 2003-8-23 => 2003-2-23
        calendar3.roll(Calendar.MONTH, 6);
        Date date3 = calendar3.getTime();
        System.out.println(date3);

        Calendar calendar4 = Calendar.getInstance();
        // roll的下一级字段的处理方式与add()相似。
        // 2003-8-31
        calendar4.set(2003, 7, 31, 0, 0, 0);
        // 2003-8-31 => 2003-2-28
        // 2003年的2月份没有31号，与之最接近的是28号
        calendar4.roll(Calendar.MONTH, 6);
        Date date4 = calendar4.getTime();
        System.out.println(date4);

    }

    /**
     * Lenient 属性
     */
    @Test
    public void lenientTest() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 13);
        System.out.println(calendar.getTime());

        calendar.setLenient(false);
        calendar.set(Calendar.MONTH, 13);
        System.out.println(calendar.getTime());
    }

    /**
     * Lazy 属性
     */
    @Test
    public void la() {
        Calendar calendar = Calendar.getInstance();
        // 2003-8-31
        calendar.set(2003, 7, 31);
        // 将月份设为9，但9月31号不存在
        // 如果立即修改，系统会把日期调整到10月1号
        calendar.set(MONTH, 8);
        // 下面代码输出10月1号
        // System.out.println(calendar.getTime());// #1
        // 设置DATE字段为5
        calendar.set(DATE, 5);// #2
        System.out.println(calendar.getTime());// #3
    }
}