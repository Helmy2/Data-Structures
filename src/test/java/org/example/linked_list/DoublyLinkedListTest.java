package org.example.linked_list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        Assertions.assertTrue(empty);
        Assertions.assertEquals(0, linkedList.size);
    }

    @Test
    void isEmpty_oneItemLinkedList_returnFalse() {
        linkedList.addHead(10);

        var empty = linkedList.isEmpty();

        Assertions.assertFalse(empty);
        Assertions.assertEquals(1, linkedList.size);
    }

    @Test
    void getHead_emptyLinkedList_returnNull() {
        var result = linkedList.getHead();

        Assertions.assertNull(result);
        Assertions.assertEquals(0, linkedList.size);
    }

    @Test
    void getHead_oneItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);

        var result = linkedList.getHead();

        Assertions.assertEquals(10, result);
        Assertions.assertEquals(1, linkedList.size);
    }


    @Test
    void getHead_twoItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);

        var result = linkedList.getHead();

        Assertions.assertEquals(30, result);
    }

    @Test
    void getHead_threeItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(4);

        var result = linkedList.getHead();

        Assertions.assertEquals(4, result);
    }

    @Test
    void getTail_emptyLinkedList_returnNull() {
        var result = linkedList.getTail();

        Assertions.assertNull(result);
    }

    @Test
    void getTail_oneItemLinkedList_returnTheTailItem() {
        linkedList.addHead(10);

        var result = linkedList.getTail();

        Assertions.assertEquals(10, result);
    }

    @Test
    void getTail_twoItemLinkedList_returnTheTailItem() {
        linkedList.addTail(10);
        linkedList.addTail(30);

        var result = linkedList.getTail();

        Assertions.assertEquals(30, result);
    }

    @Test
    void getTail_threeItemLinkedList_returnTheTailItem() {
        linkedList.addTail(10);
        linkedList.addTail(30);
        linkedList.addTail(8);

        var result = linkedList.getTail();

        Assertions.assertEquals(8, result);
    }

    @Test
    void getHead_threeHeadItemTwoTailItemLinkedList_returnTheHeadItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(8);
        linkedList.addTail(2);
        linkedList.addTail(0);

        var result = linkedList.getHead();

        Assertions.assertEquals(8, result);
    }

    @Test
    void getTail_threeHeadItemTwoTailItemLinkedList_returnTheTailItem() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(8);
        linkedList.addTail(2);
        linkedList.addTail(0);

        var result = linkedList.getTail();

        Assertions.assertEquals(0, result);
    }

    @Test
    void contain_emptyItemLinkedList_returnFalse() {
        var result = linkedList.contain(10);

        Assertions.assertFalse(result);
    }


    @Test
    void contain_threeItemLinkedList_returnFalse() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(50);

        var result = linkedList.contain(6);

        Assertions.assertFalse(result);
    }

    @Test
    void contain_fourItemLinkedList_returnTrue() {
        linkedList.addHead(10);
        linkedList.addHead(30);
        linkedList.addHead(50);
        linkedList.addHead(6);

        var result = linkedList.contain(6);

        Assertions.assertTrue(result);
    }


    @Test
    void remove_emptyLinkedList_returnFalse() {
        var result = linkedList.remove(6);

        Assertions.assertFalse(result);
    }


    @Test
    void remove_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.remove(6);
        var empty = linkedList.isEmpty();

        Assertions.assertTrue(empty);
        Assertions.assertTrue(result);
    }

    @Test
    void remove_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(6);

        var result = linkedList.remove(12);
        var size = linkedList.size;

        Assertions.assertEquals(1, size);
        Assertions.assertTrue(result);
    }

    @Test
    void removeHead_emptyLinkedList_returnFalse() {
        var result = linkedList.removeHead();

        Assertions.assertFalse(result);
    }


    @Test
    void removeHead_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.removeHead();
        var empty = linkedList.isEmpty();

        Assertions.assertTrue(empty);
        Assertions.assertTrue(result);
    }

    @Test
    void removeHead_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);

        var result = linkedList.removeHead();
        var head = linkedList.getHead();
        var size = linkedList.size;

        Assertions.assertEquals(12, head);
        Assertions.assertEquals(1, size);
        Assertions.assertTrue(result);
    }

    @Test
    void removeHead_oneFromThreeItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);
        linkedList.addHead(9);

        var result = linkedList.removeHead();
        var head = linkedList.getHead();
        var size = linkedList.size;

        Assertions.assertEquals(5, head);
        Assertions.assertEquals(2, size);
        Assertions.assertTrue(result);
    }

    @Test
    void removeTail_emptyLinkedList_returnFalse() {
        var result = linkedList.removeTail();

        Assertions.assertFalse(result);
    }


    @Test
    void removeTail_oneFromOneItemLinkedList_returnTrue() {
        linkedList.addHead(6);

        var result = linkedList.removeTail();
        var empty = linkedList.isEmpty();

        Assertions.assertTrue(empty);
        Assertions.assertTrue(result);
    }

    @Test
    void removeTail_oneFromTwoItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);

        var result = linkedList.removeTail();
        var head = linkedList.getHead();
        var size = linkedList.size;

        Assertions.assertEquals(5, head);
        Assertions.assertEquals(1, size);
        Assertions.assertTrue(result);
    }

    @Test
    void removeTail_oneFromThreeItemLinkedList_returnTrue() {
        linkedList.addHead(12);
        linkedList.addHead(5);
        linkedList.addHead(9);

        var result = linkedList.removeTail();
        var head = linkedList.getTail();
        var size = linkedList.size;

        Assertions.assertEquals(5, head);
        Assertions.assertEquals(2, size);
        Assertions.assertTrue(result);
    }


    @Test
    void iterator_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var results = linkedList.iterator();
        var size = linkedList.size;

        Assertions.assertEquals(5, size);
        for (int i = 0; i < 5; i++) {
            var result = linkedList.getHead();
            linkedList.removeHead();
            Assertions.assertEquals(result, results.next());
        }
    }

    @Test
    void reverseIterator_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var results = linkedList.reverseIterator();
        var size = linkedList.size;

        Assertions.assertEquals(5, size);
        for (int i = 0; i < 5; i++) {
            var result = linkedList.getTail();
            linkedList.removeTail();
            Assertions.assertEquals(result, results.next());
        }
    }

    @Test
    void forEach_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        var size = linkedList.size;

        Assertions.assertEquals(5, size);

        for (Integer integer : linkedList) {
            var result = linkedList.getHead();
            linkedList.removeHead();
            Assertions.assertEquals(result, integer);
        }
    }

    @Test
    void clear_fiveItemLinkedList_returnTrue() {
        for (int i = 0; i < 5; i++)
            linkedList.addTail(i);

        linkedList.clear();
        var empty = linkedList.isEmpty();

        Assertions.assertTrue(empty);

    }
}