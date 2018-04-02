package edu.babanin.algos.sorts;

public abstract class AbstractSort implements ISort{
    private ISort simpleSort = new BubbleSort();

    protected void simpleSort(int[] arr, int i0, int len){
        int[] buf = new int[len];
        arraycopy(arr, i0, buf, 0, len);
        buf = simpleSort.sort(buf);
        arraycopy(buf, 0, arr, i0, len);
    }

    protected void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length){
        System.arraycopy(src, srcPos, dest, destPos, length);
    }
}
