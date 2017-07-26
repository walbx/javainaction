package me.aloo.javainaction.action.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by walbx on 2017/7/26.
 */
public class QuickSort extends AbstractSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

    /**
     * 分治算法(Divide-and-ConquerMethod)，包含分解子问题，解决子问题，将子问题合并这三个步骤。选出一个pivot，大于它的放右边，小于它的放左边，称为两个partition，然后对两个partition递归
     * 原地分区
     * 算法时间复杂度：O(nlogn)
     * 最怀的情况下需要n^2次比较，，平均需要NlogN次比较，快排通常比其他O(nlogn)复杂度的算法明显更快
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        quick_sort_recursive(a, 0, a.length -1);
        LOGGER.info("QuickSort----------");
    }

    private void quick_sort_recursive(Comparable[] a, int left, int right) {
        if (left >= right) return;

        int i = left, j = right;
        Comparable mid = a[left];
        while (i < j) {
            // 从右向左找第一个小于mid的数
            while (i < j && less(mid, a[j])) {
                j--;
            }
            if(i < j)
                a[i++] = a[j];
            // 从左向右找第一个大于等于mid的数
            while (i < j && less(a[i], mid)) {
                i++;
            }
            if(i < j)
                a[j--] = a[i];
        }
        a[i] = mid;
        //分治
        quick_sort_recursive(a, left, i -1);
        quick_sort_recursive(a, i + 1, right);

    }
}
