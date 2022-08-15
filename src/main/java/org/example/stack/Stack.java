package org.example.stack;

import org.example.deque.Deque;

import java.util.NoSuchElementException;

public class Stack<T> {
    private final Deque<T> store = new Deque<>();

    /**
     * Add an element to the top of a stack
     *
     * @param value element to be added to the stack
     */
    public void push(T value) {
        store.enqueueHead(value);
    }

    /**
     * Remove an element from the top of a stack
     *
     * @return The top element
     */
    public T pop() {
        return store.dequeueHead();
    }

    /**
     * Get the value of the top element without removing it
     *
     * @return The top element
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T peek() {
        return store.peekHead();
    }


    /**
     * @return The size of the stack
     */
    public int getSize() {
        return store.getSize();
    }
}
