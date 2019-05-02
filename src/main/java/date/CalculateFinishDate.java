package date;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.HttpUtil;

/**
 * 
 * @author Castle
 *
 */
public class CalculateFinishDate {
    @Test
    public void calcfinishDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 2019-05-27
        System.out.println(getEndWorkDate(sdf.parse("2019-05-20"), 6));
    }

    /**
     * 通过开始日期以及耗费工作日天数，得到完成日期
     * <p>
     * 接口示例：http://www.easybots.cn/api/holiday.php?d=20170527,20170528,20170529,
     * 20170530
     * <p>
     * 返回值示例：{"20170527":"0","20170528":"1","20170529":"1","20170530":"2"}
     * <p>
     * 其中：工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
     * 
     * @param startDate 起点日期
     * @param period    预计所需工作日天数
     * @return 预计完成日期
     * 
     * @since 1.8
     * 
     * @author 黄嘉明
     * @version 2017-05-26
     */
    public static LocalDate getEndWorkDate(Date startDate, int period) {
        assertNotNull("开始日期不得为空", startDate);
        assertNotNull("预计办理天数不得为空", period);
        LocalDateTime ldt = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDate start = ldt.toLocalDate();
        if (365 < period) {
            System.out.println("业务办理期限过长");
            return null;
        }
        if (period <= 1) {
            // 当天完成
            return start;
        }

        // 外部接口
        String dateApi = "http://www.easybots.cn/api/holiday.php";
        // 开始日期
        boolean loop = true;
        // 大致估算所需天数（通常每5个工作日就有2天周末，每次调用外部接口时查询的日期为：预计工作日加上N个周末）
        int estimateDays = period + (period / 5) * 2;
        // 精确的完成日期
        String target = "";
        while (loop) {
            StringBuilder sb = new StringBuilder();
            LocalDate temp = null;
            for (int i = 0; i < estimateDays; i++) {
                temp = start;
                temp = temp.plusDays(i);
                sb.append(temp.toString() + ",");
            }
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("d", sb.toString());
            String result = HttpUtil.sendPost(dateApi, paramMap);
            result = result.substring(1, result.length() - 1);
             System.out.println("test output==============:" + result);
            String[] resultSplit = result.split(",");
            // 调用外部接口返回结果中的工作日天数
            int workDayCount = 0;
            for (String str : resultSplit) {
                if (str.contains("\"0\"")) {
                    workDayCount++;
                    if (workDayCount == period) {
                        target = str.substring(1, str.length() - 5);
                        loop = false;
                        break;
                    }
                }
            }
            // 大致估算的天数内无法完成业务，再加7天
            estimateDays += 7;
        }
        target = target.substring(0, 4) + "-" + target.substring(4, 6) + "-" + target.substring(6, 8);
        return LocalDate.parse(target);
    }
}
