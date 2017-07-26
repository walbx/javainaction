package me.aloo.javainaction.action.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by walbx on 2017/7/26.
 */
public class InsertionSort extends AbstractSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSort.class);

    /**
     * 原地(in-place)排序；算法平均时间复杂度O(n^2)；只需要O(1)的临时存储空间
     * 最好情况只需(n-1)次比较，最坏的情况，需要n(n-1)/2次比较，平均n*(n-1)/4次比较；在少量(千级以下)，是可选的算法；
     * 相比选择排序，插入排序每次新元素是和已排序的部分进行比较，往往只需要少量比较就完成插入，而选择排序每次新元素是和未排序的元素比较，
     * 必须完全遍历
     * 样本：q,a,q,a,a,z,w,s,x,e,d,c,r,f,v,t,g,b,y,h,n,u,j,m,i,k,o,l,p,p,p
     * 加入了t用来计算比较次数
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int t = 0;
        LOGGER.info("InsertionSort----------");
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                t++;
                if (less(a[j - 1], a[j])) {
                    break;
                }
                exch(a, j, j - 1);
            }
        }
        LOGGER.info("InsertionSort  time={}", t);

    }
}
