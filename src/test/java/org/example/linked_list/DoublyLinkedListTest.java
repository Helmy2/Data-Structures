package org.example.linked_list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void before() {
        linkedList = new DoublyLinkedList<>();
    }

    @AfterEach
    void after() {
        linkedList = null;
    }

    @Test
    void isEmpty_emptyLinkedList_returnTrue() {
        var empty = linkedList.isEmpty();

        assertTrue(empty);
        assertEquals(0, linkedList.size);
    }

    @Test
    void isEmpty_oneItemLinkedList_returnFalse() {
        linkedList.addHead(10);

        var empty = linkedList.isEmpty();

        assertFalse(empty);
        assertEquals(1, linkedList.size);
    }

    @Test
    void getHead_emptyLinkedList_returnNull() {
        var result = linkedList.getHead();

        assertNull(result);
        assertEquals(0, linkedList.size);
    }

    @Test
    void getHead_oneItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);

        var result = linkedList.getHead();

        assertEquals(10, result);
        assertEquals(1, linkedList.size);
    }


    @Test
    void getHead_twoItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);

        var result = linkedList.getHead();

        assertEquals(30, result);
    }

    @Test
    void getHead_threeItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(4);

        var result = linkedList.getHead();

        assertEquals(4, result);
    }

    @Test
    void getTail_emptyLinkedList_returnNull() {
        var result = linkedList.getTail();

        assertNull(result);
    }

    @Test
    void getTail_oneItemLinkedList_returnTheTailItem() {
        linkedList.addHead(10);

        var result = linkedList.getTail();

        assertEquals(10, result);
    }

    @Test
    void getTail_twoItemLinkedList_returnTheTailItem() {
        linkedList.addTail(10);
        linkedList.addTail(30);

        var result = linkedList.getTail();

        assertEquals(30, result);
    }

    @Test
    void getTail_threeItemLinkedList_returnTheTailItem() {
        linkedList.addTail(10);
        linkedList.addTail(30);
        linkedList.addTail(8);

        var result = linkedList.getTail();

        assertEquals(8, result);
    }

    @Test
    void getHead_threeHeadItemTwoTailItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(8);
        linkedList.addTail(2);
        linkedList.addTail(0);

        var result = linkedList.getHead();

        assertEquals(8, result);
    }

    @Test
    void getTail_threeHeadItemTwoTailItemLinkedList_returnTheTailItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(8);
        linkedList.addTail(2);
        linkedList.addTail(0);

        var result = linkedList.getTail();

        assertEquals(0, result);
    }

    @Test
    void contain_emptyItemLinkedList_returnFalse() {
        var result = linkedList.contain(10);

        assertFalse(result);
    }


    @Test
    void contain_threeItemLinkedList_returnFalse() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(50);

        var result = linkedList.contain(6);

        assertFalse(result);
    }

    @Test
    void contain_fourItemLinkedList_returnTrue() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(50);
        linkedList.addHead(6);

        var result = linkedList.contain(6);

        assertTrue(result);
    }


    @Test
    void remove_emptyLinkedList_returnFalse() {
        var result = linkedList.remove(6);

        assertFalse(result);
    }


    @Test
    void remove_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.remove(6);
        var empty = linkedList.isEmpty();

        assertTrue(empty);
        assertTrue(result);
    }

    @Test
    void remove_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(6);

        var result = linkedList.remove(12);
        var size = linkedList.size;

        assertEquals(1, size);
        assertTrue(result);
    }

    @Test
    void removeHead_emptyLinkedList_returnFalse() {
        var result = linkedList.removeHead();

        assertFalse(result);
    }


    @Test
    void removeHead_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.removeHead();
        var empty = linkedList.isEmpty();

        assertTrue(empty);
        assertTrue(result);
    }

    @Test
    void removeHead_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);

        var result = linkedList.removeHead();
        var head = linkedList.getHead();
        var size = linkedList.size;

        assertEquals(12, head);
        assertEquals(1, size);
        assertTrue(result);
    }

    @Test
    void removeHead_oneFromThreeItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);
        linkedList.addHead(9);

        var result = linkedList.removeHead();
        var head = linkedList.getHead();
        var size = linkedList.size;

        assertEquals(5, head);
        assertEquals(2, size);
        assertTrue(result);
    }

    @Test
    void removeTail_emptyLinkedList_returnFalse() {
        var result = linkedList.removeTail();

        assertFalse(result);
    }


    @Test
    void removeTail_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.removeTail();
        var empty = linkedList.isEmpty();

        assertTrue(empty);
        assertTrue(result);
    }

    @Test
    void removeTail_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);

        var result = linkedList.removeTail();
        var head = linkedList.getHead();
        var size = linkedList.size;

        assertEquals(5, head);
        assertEquals(1, size);
        assertTrue(result);
    }

    @Test
    void removeTail_oneFromThreeItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);
        linkedList.addHead(9);

        var result = linkedList.removeTail();
        var head = linkedList.getTail();
        var size = linkedList.size;

        assertEquals(5, head);
        assertEquals(2, size);
        assertTrue(result);
    }


    @Test
    void iterator_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var results = linkedList.iterator();
        var size = linkedList.size;

        assertEquals(5, size);
        for (int i = 0; i < 5; i++) {
            var result = linkedList.getHead();
            linkedList.removeHead();
            assertEquals(result, results.next());
        }
    }

    @Test
    void reverseIterator_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var results = linkedList.reverseIterator();
        var size = linkedList.size;

        assertEquals(5, size);
        for (int i = 0; i < 5; i++) {
            var result = linkedList.getTail();
            linkedList.removeTail();
            assertEquals(result, results.next());
        }
    }

    @Test
    void forEach_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var size = linkedList.size;

        assertEquals(5, size);

        for (Integer integer : linkedList) {
            var result = linkedList.getHead();
            linkedList.removeHead();
            assertEquals(result, integer);
        }
    }

    @Test
    void clear_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        linkedList.clear();
        var empty = linkedList.isEmpty();

        assertTrue(empty);

    }
}