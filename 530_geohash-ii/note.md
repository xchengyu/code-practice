```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/geohash-ii
@Language: Markdown
@Datetime: 17-01-15 08:35
```

public class GeoHash {
    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        int[] mask = {16, 8, 4, 2, 1};
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        boolean is_even = true;
        for (int i = 0; i < geohash.length(); i++) {
            int value = _base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (is_even) {
                    refineInterval(lon, value, mask[j]);
                } else {
                    refineInterval(lat, value, mask[j]);
                }
                is_even = !is_even;
            }
        }
        double[] res = new double[2];
        res[0] = (lat[0] + lat[1]) / 2.0;
        res[1] = (lon[0] + lon[1]) / 2.0;
        return res;
    }
    public void refineInterval(double[] Interval, int value, int mask) {
        if ((value & mask) > 0) {
            Interval[0] = (Interval[0] + Interval[1]) / 2.0;
        } else {
            Interval[1] = (Interval[0] + Interval[1]) / 2.0;
        }
        return;
    }
}