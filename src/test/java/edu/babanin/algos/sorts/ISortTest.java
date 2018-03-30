package edu.babanin.algos.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class ISortTest<T extends ISort> {
    private Class<T> aClass;
    private T sortAlgorithm;

    public ISortTest() {
        aClass = Optional.of(getClass())
                .map(Class::getGenericSuperclass)
                .filter(el -> el instanceof ParameterizedType)
                .map( el -> (ParameterizedType) el)
                .filter(el -> el.getActualTypeArguments().length > 0)
                .map(el -> el.getActualTypeArguments()[0])
                .filter(el -> el instanceof Class)
                .map(el -> (Class<T>) el)
                .orElse(null);
    }

    @BeforeEach
    void init() throws IllegalAccessException, InstantiationException {
        sortAlgorithm = aClass.newInstance();
    }

    @Test
    void sortTest() {
        assertNotNull(sortAlgorithm);
        int n = 10000;
        int[] ints = new Random().ints().limit(n).toArray();
        int[] sortInts = Arrays.stream(ints)
                .sorted()
                .toArray();

        int[] testSotrInts = sortAlgorithm.sort(ints);
        assertArrayEquals(sortInts, testSotrInts);
    }
}