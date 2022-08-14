package org.example.deque;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DequeTest {
    @Test
    void emptyTest() {
        Deque<Integer> deque = new Deque<>();

        var size = deque.getSize();

        assertEquals(0, size);
    }

    @Test
    void exceptionTest() {
        Deque<Integer> deque = new Deque<>();
        assertThrows(NoSuchElementException.class, deque::peekHead);
    }

    @Test
    void enqueueHeadTest() {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i <= 10; i++) {
            deque.enqueueTail(i);
        }
        for (int i = 0; i <= 10; i++) {
            assertEquals(i, deque.peekHead());
            assertEquals(i, deque.dequeueHead());
        }
    }

    @Test
    void enqueueTailTest() {
        Deque<Integer> deque = new Deque<>();

        for (int i = 0; i <= 10; i++) {
            deque.enqueueHead(i);
        }
        for (int i = 0; i <= 10; i++) {
            assertEquals(i, deque.peekTail());
            assertEquals(i, deque.dequeueTail());
        }
    }

}
