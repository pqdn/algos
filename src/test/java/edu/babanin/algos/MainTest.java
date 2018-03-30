package edu.babanin.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void sayOk() {
        String s = new Main().sayOk();
        assertEquals(s, "ok");
    }
}