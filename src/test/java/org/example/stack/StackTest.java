package org.example.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    @Test
    void emptyTest() {
        Stack<Integer> stack = new Stack<>();

        var size = stack.getSize();

        assertEquals(0, size);
    }

    @Test
    void exceptionTest() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void enqueueHeadTest() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 10; i++) {
            stack.push(i);
        }
        for (int i = 10; i > 0; i--) {
            assertEquals(i, stack.peek());
            assertEquals(i, stack.pop());
        }
    }
}