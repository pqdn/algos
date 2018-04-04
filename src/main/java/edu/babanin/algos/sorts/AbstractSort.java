package edu.babanin.algos.sorts;

public abstract class AbstractSort implements ISort{
    private SelectSort simpleSort = new SelectSort();
    protected final int minBlockSize = 16;

    protected void simpleSort(int[] arr, int i0, int len){
        simpleSort.sortInPlace(arr, i0, len);
    }

    protected void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length){
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    @Override
    public void sortInPlace(int[] ints) {
        throw new UnsupportedOperationException();
    }
}
