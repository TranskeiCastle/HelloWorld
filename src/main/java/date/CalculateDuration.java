package date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * 毫秒数到年月日时分秒的转换，即“办理时长”
 * 
 * @param duration
 * @return
 */
public class CalculateDuration {
    @Test
    public void met3() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse("2017-11-23 16:20:53", dtf);
        LocalDateTime endDate = LocalDateTime.parse("2018-02-11 07:50:03", dtf);
        Duration between = Duration.between(startDate, endDate);
        // Date#getTime()也是返回毫秒数，同样可用
        long duration = between.toMillis();
        System.out.println(getDurationFormat(duration));
    }

    public static String getDurationFormat(Long duration) {
        if (duration == null) {
            return "";
        }
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = duration;
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        String str = day + "天" + hour + "小时" + min + "分" + sec + "秒";
        if (str.contains("天0小时")) {
            str = str.replace("0小时", "");
        }
        if (str.startsWith("0天")) {
            str = str.replace("0天", "");
        }
        return str;
    }
}
