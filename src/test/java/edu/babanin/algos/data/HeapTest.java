package edu.babanin.algos.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {
    Heap heap;

    @BeforeEach
    void init(){
        heap = new Heap();
    }

    @Test
    void add(){
        new Random(1).ints(0, 10)
                .limit(20)
                .forEach(i -> heap.add(i));

        int[] ints = new Random(1).ints(0, 10)
                .limit(20)
                .sorted()
                .toArray();

        for (int i = 0; i < ints.length; i++) {
            assertEquals(ints[i], heap.getMin());
            heap.removeMin();
        }
    }
}