package date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

/**
 * JDK 1.8: java.util.Date 新增方法，通过它们进行新旧日期转换
 * 
 * public static Date from(Instant instant)
 * 
 * public Instant toInstant()
 * 
 * 由 LocalDateTime 很容易得到 LocalDate 和 LocalTime，使用 toLocalDate()和toLocalTime()
 */
public class DateNLocalDateTime {
    /**
     * Date 到 LocalDateTime
     */
    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * LocalDateTime 到 Date
     */
    @Test
    public void localDateTime2Date() {
        LocalDateTime ldt = LocalDateTime.now();
        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        Date fullDate = Date.from(instant);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(fullDate));
    }

    /**
     * LocalDate 到 Date，时分秒都是零
     * 
     * 要么是 LocalDateTime 到 Date，要么是 LocalDate 到 Date；不会有 LocalTime，因为它没有日期信息，只有时间
     */
    @Test
    public void localDate2Date() {
        LocalDate localDate = LocalDate.now();
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

}
