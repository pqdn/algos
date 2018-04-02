package edu.babanin.algos.sorts;

import java.util.Arrays;

/**
 * Top to down mergesort
 */
public class MergeSort extends AbstractSort {
    private final int minBlockSize  = 16;


    @Override
    public int[] sort(int[] ints) {
        int[] ints1 = Arrays.copyOf(ints, ints.length);
        int[] buffer = new int[ints.length];
        slice(ints1, 0, ints.length, buffer);
        return ints1;
    }

    @SuppressWarnings("Duplicates")
    private void slice(int[] arr, int i0, int ie, int[] buffer){
        int j0 = (ie + i0)/2;
        int len = ie - i0;

        if(len <= minBlockSize){
            simpleSort(arr, i0, len);
            return;
        }else{
            slice(arr, i0 , j0, buffer);
            slice(arr, j0 , ie, buffer);
        }

        int i = i0;
        int j = j0;
        int k = i0;
        while(i < j0 && j < ie){
            if(arr[i]< arr[j]){
                buffer[k] = arr[i++];
            }else{
                buffer[k] = arr[j++];
            }
            k++;
        }

        if(i < j0){
            arraycopy(arr, i, buffer, k, j0 - i);
        } else if (j < ie) {
            arraycopy(arr, j, buffer, k, ie - j);
        }

        arraycopy(buffer, i0, arr, i0, len);
    }
}
