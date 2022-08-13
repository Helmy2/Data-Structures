package org.example.linked_list;

import java.util.Iterator;


public class DoublyLinkedList<T> implements Iterable<T> {
    int size = 0;
    Node head = null;
    Node tail = null;


    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * check if the list is empty
     *
     * @return True if the list is empty, false otherwise.
     */
    boolean isEmpty() {
        return head == null;
    }

    /**
     * @return The last node in the first or null if empty
     */
    T getHead() {
        if (isEmpty())
            return null;
        return head.value;
    }


    /**
     * @return The last node in the last or null if empty
     */
    T getTail() {
        if (isEmpty())
            return null;
        return tail.value;
    }


    /**
     * Adds the specified value to the start of the linked list
     *
     * @param value The value to add to the start of the list
     */
    void addHead(T value) {
        if (isEmpty())
            head = tail = new Node(value);
        else {
            head.prev = new Node(value, null, head);
            head = head.prev;
        }
        size++;
    }


    /**
     * Adds the specified value to the end of the linked list
     *
     * @param value The value to add to the end of the list
     */
    void addTail(T value) {
        if (isEmpty())
            head = tail = new Node(value);
        else {
            tail.next = new Node(value, tail, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Removes the first node from the list.
     *
     * @return True if the item is removed, false otherwise.
     */
    boolean removeHead() {
        if (isEmpty())
            return false;

        if (size == 1) {
            head = tail = null;
            size--;
            return true;
        }

        head = head.next;
        head.prev = null;
        size--;
        return true;
    }

    /**
     * Removes the end node from the list.
     *
     * @return True if the item is removed, false otherwise.
     */
    boolean removeTail() {
        if (isEmpty())
            return false;

        if (size == 1) {
            head = tail = null;
            size--;
            return true;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
        return true;
    }


    /**
     * Removes the first occurrence of the item from the list (searching
     * from Head to Tail).
     *
     * @param value item value to remove
     * @return True if the item is removed, false otherwise.
     */
    boolean remove(T value) {
        var found = find(value);
        if (found == null)
            return false;

        var prev = found.prev;
        var next = found.next;

        if (prev == null) {
            head = next;
            if (head != null)
                head.prev = null;
        } else
            prev.next = next;

        if (next == null) {
            tail = prev;
            if (tail != null)
                tail.next = null;
        } else
            next.prev = prev;

        size--;
        return true;
    }

    /**
     * Removes all the nodes from the list
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Check list to find a specified Node
     *
     * @param value The item to search for
     * @return The Item if the item is found, null otherwise.
     */
    private Node find(T value) {
        var current = head;
        while (current != null) {
            if (current.value == value)
                return current;
            current = current.next;
        }
        return null;
    }

    /**
     * Check list to find a specified item
     *
     * @param value The item to search for
     * @return True if the item is found, false otherwise.
     */
    boolean contain(T value) {
        return find(value) != null;
    }

    /**
     * Iterate over the linked list values from Head to Tail
     *
     * @return A Head to Tail Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    /**
     * Iterate over the linked list values from Tail to Head
     *
     * @return A Tail to Head Iterator
     */
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            private Node temp = tail;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T value = temp.value;
                temp = temp.prev;
                return value;
            }
        };
    }
}
