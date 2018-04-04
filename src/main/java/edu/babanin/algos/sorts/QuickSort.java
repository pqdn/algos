package edu.babanin.algos.sorts;

import java.util.Arrays;
import java.util.Random;

public class QuickSort extends AbstractSort {
    private Random random = new Random();

    @Override
    public int[] sort(int[] ints) {
        int[] arr = Arrays.copyOf(ints, ints.length);
        sortInPlace(arr);
        return arr;
    }

    @Override
    public void sortInPlace(int[] arr) {
        quick(arr, 0, arr.length);
    }

    private void quick(int[] arr, int start, int end) {
        int len = end - start;
        if(len > minBlockSize){
            int startB = partition(arr, start, end);
            quick(arr, start, startB);
            quick(arr,startB,end);
        }else {
            simpleSort(arr, start, len);
        }

    }

    /**
     * Lumuto partition с балансировкой
     */
    private int partition(int[] arr, int start, int end) {
        int pivot = findPivot(arr, start, end);

        int startB = start;
        boolean balanced = false;
        for (int i = start; i < end; i++) {
            if(arr[i] == pivot && (i - startB) > (startB - start)){
                balanced = true;
            }
            if (arr[i] < pivot || balanced) {
                int tmp = arr[i];
                arr[i] = arr[startB];
                arr[startB] = tmp;
                startB++;
                balanced = false;
            }
        }

        return startB;
    }

    private int findPivot(int[] arr, int start, int end) {
        int pivotIndex = Math.abs(random.nextInt())%(end-start)+start;
        return arr[pivotIndex];
    }
}
