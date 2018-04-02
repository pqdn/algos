package edu.babanin.algos.sorts;

public interface ISort {
    int[] sort(int[] ints);

    default boolean isSimple(){
        return false;
    }
}
