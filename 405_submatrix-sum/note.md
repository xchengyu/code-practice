```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/submatrix-sum
@Language: Markdown
@Datetime: 17-01-17 09:39
```

public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        // 和subarray sum 的思路一模一样，就是找一个大矩阵中是否包含一个和其sum相等并且长或宽相等的子矩阵。
        int[][] res = new int[2][2];
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0) {
            return res;
        }
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            sum[i][0] = 0;
        }
        for (int i = 0; i <= col; i++) {
            sum[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        for (int l = 0; l < row; l++) {
            for (int h = l + 1; h <= row; h++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j <= col; j++) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        res[0][0] = l;
                        res[0][1] = k;
                        res[1][0] = h - 1;
                        res[1][1] = j - 1;
                        return res;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return res;
    }