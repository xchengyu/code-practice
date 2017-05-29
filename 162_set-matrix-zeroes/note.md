```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/set-matrix-zeroes
@Language: Markdown
@Datetime: 17-01-20 06:08
```

if (matrix == null || matrix.length == 0) {
            return;
        }
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;
        int l=0;
        // First row and col has zero?
        while (k < n && matrix[0][k] != 0) {
            ++k;
        }
        while (l < m && matrix[l][0] != 0) {
            ++l;
        }
        // Use first row/column as marker, scan the matrix
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        // Set the zeros
        for (int i = 1; i < m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                }
            }
        }
        // Set the zeros for the first row
        if (k < n) {
            Arrays.fill(matrix[0], 0);
        }
        if (l < m) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return;