```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Markdown
@Datetime: 16-12-29 10:42
```

http://www.cnblogs.com/x1957/p/3406448.html
从head到环开始的路程 ＝ 从相遇到环开始的路程
这其实是个数学问题，我的想法是这样的：先创建一个新节点，作为slow和fast的起点，相当于坐标系上的0点，数组的第0个元素，而head则是第1个；假设在slow指针指向环的起点之前，slow指针要走x步，设slow指针从环的开端走一圈要走y步，那么在slow走到环的起点时，fast指针已经走了2x步，这时两个指针都在环内，而fast每一次又比slow多走一步，所以这时可以看作一个追及问题；此时slow在fast前面（虽然实际上是在后面，但这是个环相当于slow在fast前面）(k * y + x) - 2x = k * y - x 步（k是一个大于等于1的正整数，因为y可能大于x），再加上slow在入环之前走的x步，此时slow已经走了k * y步，fast才与slow处于同一个节点；而slow想要重新回到环的起点则需要k * y + x步，也就是还要再走x步，而head本身已经在1的位置上了，所以只需要x - 1步就到达了环的起点