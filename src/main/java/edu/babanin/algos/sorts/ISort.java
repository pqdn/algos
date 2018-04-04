package edu.babanin.algos.sorts;

public interface ISort {
    int[] sort(int[] ints);
    void sortInPlace(int[] ints);

    default boolean isSimple(){
        return false;
    }


}
