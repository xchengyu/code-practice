```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/spiral-matrix
@Language: Markdown
@Datetime: 17-01-18 09:37
```

注意，读取顺序以及每一个方向上读取的个数都必须和标答一样才行，因为中间那个退出循环的地方的条件式与你读取顺序和每个方向上的个数有关，不信的话代入一个4*3的矩阵试一试就知道了。标答解法最优，别瞎想了    
		List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;//layer we have added
        while (count * 2 < row && count * 2 < col) {
            for (int j = count; j < col - count; j++) {// exp(i, j): (0, 0 ~ (col - 1))
                res.add(matrix[count][j]);
            }
            for (int i = count + 1; i < row - count; i++) {// exp(i, j): (1 ~ (row - 1), col - 1)  
                res.add(matrix[i][col - count - 1]);
            }
            if (count * 2 + 1 == row || count * 2 + 1 == col) {// if only one row /col remains and this row/ col has been added by one of the previous two operations 
                break;
            }
            for (int j = col - count - 2; j >= count; j--) {// exp(i, j): (row - 1, (col - 2) ~ 0)  
                res.add(matrix[row - count - 1][j]);
            }
            for (int i = row - count - 2; i >= count + 1; i--) {// exp(i, j): ((row - 2) ~ 1, 0)
                res.add(matrix[i][count]);
            }
            count++;
        }
        return res;