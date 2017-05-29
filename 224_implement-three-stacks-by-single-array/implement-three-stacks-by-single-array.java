/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-three-stacks-by-single-array
@Language: Java
@Datetime: 16-12-19 10:35
*/

public class ThreeStacks {
    private int[] buffer;
    private int[] stackPointer;
    
    public ThreeStacks(int size) {
        // do intialization if necessary
        buffer = new int[size * 3];
        stackPointer = new int[3];
        stackPointer[0] = -3;
        stackPointer[1] = -2;
        stackPointer[2] = -1;
    }

    public void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        int index = stackPointer[stackNum];
        index += 3;
        stackPointer[stackNum] = index;
        buffer[index] = value;
    }
    
    public int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        if (isEmpty(stackNum)) {
            return 0;
        }
        int index = stackPointer[stackNum];
        int result = buffer[index];
        index -= 3;
        stackPointer[stackNum] = index;
        return result;
    }

    public int peek(int stackNum) {
        // Write your code here
        // Return the top element
        int index = stackPointer[stackNum];
        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        // Write your code here
        return stackPointer[stackNum] < 0;
    }
}