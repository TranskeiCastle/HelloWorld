package util;

import java.text.DecimalFormat;

/**
 * 传入两组经纬度，计算它们之间的距离。南纬是负数，东经是正数
 * 
 *  计算结果可以与百度地图工具比较，地址是http://lbsyun.baidu.com/jsdemo.htm#a6_1
 */

/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two locations using GeoDataSource (TM) prodducts  :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    South latitudes are negative, east longitudes are positive           :*/
/*::                                                                         :*/
/*::  Passed to function:                                                    :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles                                  :*/
/*::  Worldwide cities and other features databases with latitude longitude  :*/
/*::  are available at https://www.geodatasource.com                          :*/
/*::                                                                         :*/
/*::  For enquiries, please contact sales@geodatasource.com                  :*/
/*::                                                                         :*/
/*::  Official Web site: https://www.geodatasource.com                        :*/
/*::                                                                         :*/
/*::           GeoDataSource.com (C) All Rights Reserved 2017                :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
public class MapUtil {
    public static void main(String[] args){
        /*System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
        System.out.println(distance(22.368917, 113.557627, 32.130283, 115.100659, "K") + " Kilometers\n");
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");*/
        System.out.println(getDistance(22.37784, 113.581399, 22.378015, 113.58117, MapUtil.METER) + " meters\n");
       
    }
    // 原点经度
    public static final double ORIGINAL_LON = 115.100651;
    // 原点纬度
    public static final double ORIGINAL_LAT = 32.131013;
    // 有效距离
    public static final double AVAILABLE_DIST = 145.0;
    // 距离单位（支持米、千米、英里、海里）
    public static final String METER = "meter";
    public static final String KILOMETER = "kilometer";
    public static final String MILE = "mile"; 
    public static final String NAUTICAL_MILE = "nauticalMile";
    
    /**
     * @param lat1
     *            A点纬度
     * @param lon1
     *            A点经度
     * @param lat2
     *            B点纬度
     * @param lon2
     *            B点经度
     * @param unit
     *            距离单位，默认是英里mile
     * @return
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if(unit.equals("meter")) {
            dist = dist * 1609;
        }else if (unit.equals("kilometer")) {
            dist = dist * 1.609344;
        }else if (unit.equals("nauticalMile")) {
            dist = dist * 0.8684;
        }
        
        DecimalFormat df = new DecimalFormat("#.######");
        return Double.parseDouble(df.format(dist));
    }
    
    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
