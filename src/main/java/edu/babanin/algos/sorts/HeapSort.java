package edu.babanin.algos.sorts;

import edu.babanin.algos.data.Heap;

public class HeapSort extends AbstractSort {
    @Override
    public int[] sort(int[] ints) {
        Heap heap = new Heap();
        for (int i = 0; i < ints.length; i++) {
            heap.add(ints[i]);
        }

        int[] arr = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            arr[i] = heap.getMin();
            heap.removeMin();
        }
        return arr;
    }
}
