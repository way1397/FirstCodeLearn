package com.wsf.algorithms;

class BubbleSort {
    // 冒泡排序，a表示数组，n表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            // j<n-i-1:每排一遍都会有一个数被排列到正确的位置，比如数据{3,2,1,6,5,4},第一遍6肯定会被排到列表最后，第二遍5肯定会被排到列表倒二
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }
}
