package org.example.queue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void emptyTest() {
        Queue<Integer> queue = new Queue<>();

        var size = queue.getSize();

        assertEquals(0, size);
    }

    @Test
    void exceptionTest() {
        Queue<Integer> queue = new Queue<>();
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void naiveHeadTest() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i <= 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, queue.peek());
            assertEquals(i, queue.dequeue());
        }
    }

}