```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Markdown
@Datetime: 16-08-29 05:52
```

首先我们看一下下面的例子：

 



height的内容是 [5,6,7,8,3]，特点是除了最后一个，前面全部保持递增，且最后一个立柱的高度小于前面所有立柱高度。

对于这种特点的柱状图，如果使用上面所说的“挨个使用每一个柱状图的高度作为矩形的高度，求面积”的方法，还需要用嵌套循环吗？

我们知道除了最后一个，从第一个到倒数第二个立柱的高度都在升高，那么如果挨个使用每一个柱的高度作为矩形的高度，那么依次能得到的矩形的宽度就可以直接算出来：使用5作为高度可以使用前四个立柱组成 4*5的矩形，高度6可以组成3*6的矩形... 因此只需要遍历一次，选出最大面积即可。

对于这种类型的柱状图，最大矩形面积的时间复杂度是O(n)。

我们将这种特点的柱状图称为“波峰图”。

 

下面介绍新的解法的步骤：

(1) 在height尾部添加一个0，也就是一个高度为0的立柱。作用是在最后也能凑成上面提的那种“波峰图”。

(2) 定义了一个stack，然后遍历时如果height[i] 大于stack.top()，进栈。反之，出栈直到栈顶元素小于height[i]。

由于出栈的这些元素高度都是递增的，我们可以求出这些立柱中所围成的最大矩形。更妙的是，由于这些被弹出的立柱处于“波峰”之上(比如弹出i 到 i+k，那么所有这些立柱的高度都高于 i-1和 i+k+1的高度)，因此，如果我们使用之前所提的“左右延伸找立柱”的思路解，以这些立柱的高度作为整个矩形的高度时，左右延伸出的矩形所包含的立柱不会超出这段“波峰”，因为波峰外的立柱高度都比他们低。“波峰图”其实就是求解最大矩形的“孤岛”，它不会干扰到外部。

(3) 由于比height[i]大的元素都出完了，height[i]又比栈顶元素大了，因此再次进栈。如此往复，直到遍历到最后那个高度为0的柱，触发最后的弹出以及最后一次面积的计算，此后stack为空。

(4) 返回面积最大值。

栈中存的不是高度，而是height的索引，这样做的好处是不会影响宽度的计算，索引值相减 = 宽度。

自己实现代码如下，虽然是二重循环，但时间复杂度实际  2N，故为O(N)
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();//我们将使这个栈成为一个递增栈
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= curt) {
                int h = height[stack.pop()];//height
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;//width (p.s.index为i说明是第i+1个柱子)
                //如果stack为空，则说明刚刚从stack中弹出的柱子高度是前i个柱子中最低的（stack是递增栈）
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
