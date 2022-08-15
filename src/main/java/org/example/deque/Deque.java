package org.example.deque;

import org.example.linked_list.DoublyLinkedList;

import java.util.NoSuchElementException;

public class Deque<T> {
    private final DoublyLinkedList<T> store = new DoublyLinkedList<>();

    /**
     * @return The size of dequeue
     */
    public int getSize() {
        return store.size;
    }

    /**
     * Adds the specified value to the start of the dequeue
     */
    public void enqueueHead(T value) {
        store.addHead(value);
    }

    /**
     * Adds the specified value to the end of the dequeue
     */
    public void enqueueTail(T value) {
        store.addTail(value);
    }

    /**
     * Removes the first value from the dequeue.
     *
     * @return the value which has been deleted
     */
    public T dequeueHead() {
        T temp = store.getHead();
        store.removeHead();
        return temp;
    }

    /**
     * Removes the last value from the dequeue.
     *
     * @return the value which has been deleted
     */
    public T dequeueTail() {
        T temp = store.getTail();
        store.removeTail();
        return temp;
    }

    /**
     * @return The last value
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T peekHead() {
        var temp = store.getHead();
        if (temp == null)
            throw new NoSuchElementException();
        return temp;
    }

    /**
     * @return The first value
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T peekTail() {
        var temp = store.getTail();
        if (temp == null)
            throw new NoSuchElementException();
        return temp;
    }
}
