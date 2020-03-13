package yzh.algorithm.face;

import java.util.Stack;

public class No_41_MedianFinder {
    /**
     * initialize your data structure here.
     */

    private Stack<Integer> stackOne = new Stack<>();  // 存放数据
    private Stack<Integer> stackTwo = new Stack<>();  // 辅助数据
    private int medianIndex = 0;  // 记录位置
    private double medianNum = 0;
    private boolean parityFlag = true; //默认偶数
    private boolean helpFlag = false; // 辅助判断偶数个数时，计算中位值

    public No_41_MedianFinder() {

    }

    public void addNum(int num) {
        if (parityFlag) {
            medianIndex++;
            parityFlag = false;
        } else {
            parityFlag = true;
        }
        if (stackOne.size() == 0 && stackTwo.size() == 0) {
            medianNum = num;
            stackOne.push(num);
        } else {
            if (stackOne.size() > 0) exchange(stackOne, stackTwo, num, true);
            else exchange(stackTwo, stackOne, num, false);
        }
    }

    public void exchange(Stack<Integer> one, Stack<Integer> two, int num, boolean reverse) {
        int length = one.size();
        int i = 1;  // 遍历，倒退stack
        int index = 0; // 记录入栈数量
        boolean flag = true;
        medianNum = Integer.MIN_VALUE;
        helpFlag = false;
        while (i <= length) {
            int temp = one.pop();
            if (flag && ((reverse && (num > temp)) || (!reverse && (num < temp)))) {
                two.push(num);
                flag = false;
                index++;
            }
            updateMedianNum(index, num);
            two.push(temp);
            index++;
            updateMedianNum(index, temp);
            if (flag && i == length) {
                two.push(num);
                index++;
                updateMedianNum(index, num);
            }
            i++;
        }
    }

    public void updateMedianNum(int index, int num) {
        if (index == medianIndex && medianNum == Integer.MIN_VALUE) {
            medianNum = num;
        } else if (parityFlag && index == medianIndex + 1 && !helpFlag) {
            medianNum = (medianNum + num) * 1.0 / 2;
            helpFlag = true;
        }
    }

    public double findMedian() {
        return medianNum;
    }

    public static void main(String[] args) {
        String[] inputString = {"MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"};
        int[][] inputNum = {{}, {1}, {}, {2}, {}, {3}, {}, {4}, {}, {5}, {}, {6}, {}, {7}, {}, {8}, {}, {9}, {}, {10}, {}};

        No_41_MedianFinder medianFinder = new No_41_MedianFinder();
        for (int i = 0; i < inputString.length; i++) {
            if ("MedianFinder".equals(inputString[i]) || "findMedian".equals(inputString[i])) {
                System.out.println(medianFinder.stackOne.size() != 0 ? medianFinder.stackOne.toString() : medianFinder.stackTwo.toString());
                System.out.println(medianFinder.findMedian());
            } else {
                medianFinder.addNum(inputNum[i][0]);
            }
        }

    }
}
