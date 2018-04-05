package edu.babanin.algos.data;

import java.util.EmptyStackException;

/**
 * Двоичная куча
 */
public class Heap {
    private int size = 0;
    private int capacity = 2;
    private int arr[] = new int[capacity];

    public void add(int num){
        if (size >= capacity) {
            capacity = capacity*2;
            int[] tmp = new int[capacity];
            arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        }

        arr[size] = num;
        balance2Top(size);
        size++;
    }

    private void balance2Top(int i) {
        if(i == 0){
            return;
        }

        int bi =  log2(i + 1);
        int startIndex = (1 << bi) - 1;

        int bi2 = bi - 1;
        int startIndex2 = (1 << bi2) - 1;

        int i2 = startIndex2 + (i - startIndex) / 2;

        if(arr[i] < arr[i2]){
            int tmp = arr[i];
            arr[i] = arr[i2];
            arr[i2] = tmp;
            balance2Top(i2);
        }
    }

    private int log2(int num) {
        return (int) (Math.log(num) / Math.log(2.0));
    }

    public int getMin(){
        if (size == 0) {
            throw new EmptyStackException();
        }
        return arr[0];
    }

    public void removeMin(){
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        arr[0] = arr[size];
        balance2Bot(0);
    }

    private void balance2Bot(int i) {
        int bi =  log2(i + 1);
        int startIndex = (1 << bi) - 1;

        int bi2 = bi + 1;
        int startIndex2 = (1 << bi2) - 1;

        int i2 = startIndex2 + (i - startIndex) * 2;

        if (i2 >= size) {
            return;
        }

        if (i2 + 1 < size) {
            i2 = arr[i2] < arr[i2 + 1] ? i2 : i2 + 1;
        }


        if(arr[i] > arr[i2]){
            int tmp = arr[i];
            arr[i] = arr[i2];
            arr[i2] = tmp;
            balance2Bot(i2);
        }
    }

    protected void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length){
        System.arraycopy(src, srcPos, dest, destPos, length);
    }
}
