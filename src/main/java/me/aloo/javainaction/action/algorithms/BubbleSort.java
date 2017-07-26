package me.aloo.javainaction.action.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by walbx on 2017/7/25.
 */
public class BubbleSort extends AbstractSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * 算法平均时间复杂度O(n^2)；只需要O(1)的临时存储空间
     * 最坏的情况需要n^2次交换，加入flag后，降低到n次
     * 优化：通过加入flag，保证当循环中途排序就已经完成的情况下，不会在继续执行无意义的对比遍历；基础算法，不推荐
     * 相比插入排序，冒泡排序的比较次数相同，不同点在于交换次数
     * 样本:q,a,q,a,a,z,w,s,x,e,d,c,r,f,v,t,g,b,y,h,n,u,j,m,i,k,o,l,p,p,p
     * 加入了t用来计算比较次数
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int t = 0;
        boolean flag;
        int OUTER = a.length - 1; //外层循环次数
        for (int i = 0; i < OUTER; i++) {
            flag = false;
            int INNER = OUTER - i;
            for (int j = 1; j <= INNER; j++) {
                t++;
                if (less(a[j], a[j -1])) {
                    exch(a, j, j-1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        LOGGER.info("BubbleSort  time={}", t);
    }
}
