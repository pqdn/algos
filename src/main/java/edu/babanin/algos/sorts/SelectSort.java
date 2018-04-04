package edu.babanin.algos.sorts;

import java.util.Arrays;

public class SelectSort implements ISort {
    @Override
    public int[] sort(int[] ints) {
        int[] a = Arrays.copyOf(ints, ints.length);
        sortInPlace(a);
        return a;
    }

    @Override
    public void sortInPlace(int[] a) {
        sortInPlace(a, 0, a.length);
    }

    public void sortInPlace(int[] a, int start, int len) {
        int end = len + start;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    @Override
    public boolean isSimple() {
        return true;
    }
}
