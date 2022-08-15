package org.example.queue;

import org.example.deque.Deque;

public class Queue<T> {
    private final Deque<T> store = new Deque<>();

    /**
     * Add an element to the end of the queue
     *
     * @param value element to be added to the queue
     */
    public void enqueue(T value) {
        store.enqueueTail(value);
    }

    /**
     * Remove an element from the front of the queue
     *
     * @return The front element
     */
    public T dequeue() {
        return store.dequeueHead();
    }

    /**
     * Get the value of the front of the queue without removing it
     *
     * @return The front element
     */
    public T peek() {
        return store.peekHead();
    }

    /**
     * @return The size of the queue
     */
    public int getSize() {
        return store.getSize();
    }
}
