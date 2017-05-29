```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/geohash
@Language: Markdown
@Datetime: 17-01-15 08:25
```

public class GeoHash {
    /**
     * @param latitude, longitude a location coordinate pair 
     * @param precision an integer between 1 to 12
     * @return a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // Write your code here
        String base = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat_bin = getBin(latitude, -90, 90);
        String lng_bin = getBin(longitude, -180, 180);
        StringBuilder radixOfTwo = new StringBuilder();
        for (int i = 0; i < 30; i++) {//precision is 12, so we need 60 bits total, so latitude has 30 bits, same as longitude
            radixOfTwo.append(lng_bin.charAt(i));
            radixOfTwo.append(lat_bin.charAt(i));
        }
        StringBuilder hashes = new StringBuilder();
        for (int i = 0; i < 60; i += 5) {//5 bits represent one character
            hashes.append(base.charAt(b2i(radixOfTwo.substring(i, i + 5))));
        }
        return hashes.toString().substring(0, precision);//precision is 12, so we need 60 bits total
    }
    public int b2i(String str) {
        return Integer.parseInt(str, 2);
    }
    public String getBin(double value, double left, double right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            double mid = left + (right - left) / 2.0;
            if (value > mid) {
                sb.append("1");
                left = mid;
            } else {
                sb.append("0");
                right = mid;
            }
        }
        return sb.toString();
    }
}