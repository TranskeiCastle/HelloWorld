package date;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.HttpUtil;

public class CalculateFinishDate {
    @Test
    public void calcfinishDate() {
        
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
     * @param startDate
     *            起点日期
     * @param period
     *            预计所需工作日天数
     * @return 预计完成日期
     * 
     * @since 1.7
     * 
     * @author 黄嘉明
     * @version 2017-05-26
     */
    public static LocalDate getEndWorkDate(Date startDate, int period) {
        if (null == startDate) {
            startDate = new Date();
        }
        if (1 > period) {
            System.out.println("所需工作日至少是1天，即当天完成");
            return null;
        }
        if (365 < period) {
            System.out.println("业务办理期限过长");
            return null;
        }
        if (1 == period) {
            return new LocalDate(startDate);
        }
        
        // 外部接口
        String dateApi = "http://www.easybots.cn/api/holiday.php";
        // 开始日期
        LocalDate start = LocalDate.fromDateFields(startDate);
        boolean loop = true;
        // 大致估算所需天数
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
            // System.out.println("test output==============:" + result);
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
