package edu.babanin.algos.sorts;

import java.util.Arrays;

public class BubbleSort implements ISort {
    @Override
    public int[] sort(int[] ints) {
        int[] a = Arrays.copyOf(ints, ints.length);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }

    @Override
    public boolean isSimple() {
        return true;
    }
}
