/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/geohash
@Language: Java
@Datetime: 17-01-15 08:25
*/

public class GeoHash {
    /**
     * @param latitude, longitude a location coordinate pair 
     * @param precision an integer between 1 to 12
     * @return a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // Write your code here
        String base = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat_bin = getBin(latitude, -90.0, 90.0);
        String long_bin = getBin(longitude, -180.0, 180.0);
        StringBuilder radixOfTwo = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            radixOfTwo.append(long_bin.charAt(i));
            radixOfTwo.append(lat_bin.charAt(i));
        }
        StringBuilder hashes = new StringBuilder();
        for (int i = 0; i < 60; i += 5) {
            hashes.append(base.charAt(b2i(radixOfTwo.substring(i, i + 5))));
        }
        return hashes.toString().substring(0, precision);
    }
    public int b2i(String str) {
        return Integer.parseInt(str, 2);
    }
    public String getBin(double value, double left, double right) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            double mid = left + (right - left) / 2.0;
            if (value > mid) {
                str.append('1');
                left = mid;
            } else {
                str.append('0');
                right = mid;
            }
        }
        return str.toString();
    }
}