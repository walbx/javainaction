package me.aloo.javainaction.action.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by walbx on 2017/7/23.
 */
public class SelectionSort extends AbstractSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(SelectionSort.class);

    /**
     * 原地(in-place)排序；算法平均时间复杂度O(n^2)；只需要O(1)的临时存储空间
     * 最少0次，最多N-1次交换；固定N(N-1)/2次比较。基础算法，不推荐
     * 优化：通过加入判断minIndex != i，避免无意义的交换
     * 样本：q,a,q,a,a,z,w,s,x,e,d,c,r,f,v,t,g,b,y,h,n,u,j,m,i,k,o,l,p,p,p
     * 加入了t用来计算比较次数
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int t = 0;
        LOGGER.info("SelectionSort----------");
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                t++;
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exch(a, i, minIndex);
            }
        }
        LOGGER.info("SelectionSort  time={}", t);
    }
}
