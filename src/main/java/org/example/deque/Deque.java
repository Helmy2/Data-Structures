package org.example.deque;

import org.example.linked_list.DoublyLinkedList;

import java.util.NoSuchElementException;

public class Deque<T> {
    private final DoublyLinkedList<T> linkedList = new DoublyLinkedList<>();

    /**
     * @return The size of dequeue
     */
    public int getSize() {
        return linkedList.size;
    }

    /**
     * Adds the specified value to the start of the dequeue
     */
    public void enqueueHead(T value) {
        linkedList.addHead(value);
    }

    /**
     * Adds the specified value to the end of the dequeue
     */
    public void enqueueTail(T value) {
        linkedList.addTail(value);
    }

    /**
     * Removes the first value from the dequeue.
     *
     * @return the value which has been deleted
     */
    public T dequeueHead() {
        T temp = linkedList.getHead();
        linkedList.removeHead();
        return temp;
    }

    /**
     * Removes the last value from the dequeue.
     *
     * @return the value which has been deleted
     */
    public T dequeueTail() {
        T temp = linkedList.getTail();
        linkedList.removeTail();
        return temp;
    }

    /**
     * @return The last value
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T peekHead() {
        var temp = linkedList.getHead();
        if (temp == null)
            throw new NoSuchElementException();
        return temp;
    }

    /**
     * @return The first value
     * @throws NoSuchElementException if the dequeue is empty
     */
    public T peekTail() {
        var temp = linkedList.getTail();
        if (temp == null)
            throw new NoSuchElementException();
        return temp;
    }
}
