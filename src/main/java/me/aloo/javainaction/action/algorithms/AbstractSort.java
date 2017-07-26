package me.aloo.javainaction.action.algorithms;

/**
 * Created by walbx on 2017/7/25.
 */
public abstract class AbstractSort {

    abstract void sort(Comparable[] a);

    //exchange
    void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
            return true;
        }
        return false;
    }

}
