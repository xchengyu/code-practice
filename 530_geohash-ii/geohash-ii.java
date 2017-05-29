/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/geohash-ii
@Language: Java
@Datetime: 17-01-15 08:35
*/

public class GeoHash {
    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        double[] lat = {-90.0, 90.0};
        double[] lng = {-180.0, 180};
        int[] mask = {16, 8, 4, 2, 1};
        boolean iseven = true;
        for (int i = 0; i < geohash.length(); i++) {
            int index = _base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < mask.length; j++) {
                if (iseven) {
                    refineInterval(lng, index, mask[j]);
                } else {
                    refineInterval(lat, index, mask[j]);
                }
                iseven = !iseven;
            }
        }
        double[] res = new double[2];
        res[0] = lat[0] + (lat[1] - lat[0]) / 2.0;
        res[1] = lng[0] + (lng[1] - lng[0]) / 2.0;
        return res;
    }
    public void refineInterval(double[] interval, int index, int mask) {
        double mid = interval[0] + (interval[1] - interval[0]) / 2.0;
        if ((index & mask) > 0) {
            interval[0] = mid;
        } else {
            interval[1] = mid;
        }
        return;
    }
}