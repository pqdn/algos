package edu.babanin.algos.sorts;

import java.util.Arrays;

/**
 * down to top
 */
public class MergeSort2 extends AbstractSort {

    @Override
    public int[] sort(int[] ints) {
        int[] ints1 = Arrays.copyOf(ints, ints.length);
        int[] buffer = new int[ints.length];

        for (int i = 0; i < ints.length; i+= minBlockSize) {
            int ie = calcRightBound(i, ints.length, minBlockSize);
            simpleSort(ints1, i, ie);
        }

        if(minBlockSize >= ints.length){
            return ints1;
        }

        int blockSize = minBlockSize;
        while (blockSize < ints.length){
            blockSize *=2;
            for (int i = 0; i < ints.length; i+= blockSize) {
                int ie = calcRightBound(i, ints.length, blockSize);
                int j0 = calcRightBound(i, ints.length, blockSize/2);
                slice(ints1, i, i + j0, i + ie, buffer);
            }
        }

        return ints1;
    }

    @SuppressWarnings("Duplicates")
    private void slice(int[] arr, int i0, int j0, int ie, int[] buffer){
        int len = ie - i0;

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

    private int calcRightBound(int left, int maxLen, int blockSize){
        return left + blockSize < maxLen ? blockSize : maxLen - left;
    }
}
