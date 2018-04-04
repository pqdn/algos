package edu.babanin.algos.sorts;

import java.util.Arrays;

/**
 * Расчитан на сортировку только положительных чисел
 *
 * Скорость работы зависит от разрядности MAX(inputArray) во входной последовательности
 */
public class RadixSortLSD extends AbstractSort {
    private final int maxNumInCategoty = 0xf;
    private final int systemNum = maxNumInCategoty + 1;
    private final int shift;
    {
        int tmp = 0;
        for (int i = 0; i < 32; i++) {
            int num = maxNumInCategoty & (1 << i);
            if (num != 0) {
                tmp++;
            } else {
                break;
            }
        }
        shift = tmp;
    }

    @Override
    public int[] sort(int[] ints) {
        int[] arr = Arrays.copyOf(ints, ints.length);
        int[] buf = new int[ints.length];
        int max = findMax(arr);
        int cap = calcCapacity(max);

        for (int i = 0; i < cap; i++) {
            int[] indexes = calcIndexes(arr, i);

            for (int j = 0; j < arr.length; j++) {
                int category = getNumOnPosition(arr[j], i);
                buf[indexes[category]++] = arr[j];
            }

            int[] tmp = arr;
            arr = buf;
            buf = tmp;
        }

        return arr;
    }

    private int[] calcIndexes(int[] arr, int index) {
        int[] indexes = new int[systemNum];
        for (int i = 0; i < arr.length; i++) {
            indexes[getNumOnPosition(arr[i], index)]++;
        }

        int tmp = indexes[0];
        indexes[0] = 0;
        for (int i = 1; i < systemNum; i++) {
            int count = indexes[i];
            indexes[i] = indexes[i-1] + tmp;
            tmp = count;
        }

        return indexes;
    }

    private int getNumOnPosition(int value, int index){
        value = value & (maxNumInCategoty << (index * shift));
        return value >> (index * shift);
    }

    private int calcCapacity(int number) {
        int capacity = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            capacity++;
            number &= ~(maxNumInCategoty << (i * shift));
            if(number == 0){
                break;
            }
        }
        return capacity;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
