package org.example.binary_tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    //Tree
    //         100
    //      20     200
    //    10  30 150  300
    // Preorder
    // 100 , 20 , 10 , 30 , 200 , 150 , 300
    // Inorder
    // 10 , 20 , 30 , 100 , 150 , 200 , 300
    // Postorder
    // 10 , 30 , 20 , 150 , 300 , 200 , 100

    ArrayList<Integer> list = new ArrayList<>(List.of(100, 20, 10, 30, 200, 150, 300));
    ArrayList<Integer> preOrderList = new ArrayList<>(List.of(100, 20, 10, 30, 200, 150, 300));
    ArrayList<Integer> postOrderList = new ArrayList<>(List.of(10, 30, 20, 150, 300, 200, 100));
    ArrayList<Integer> inOrderList = new ArrayList<>(List.of(10, 20, 30, 100, 150, 200, 300));

    @Test
    void isEmpty_emptyBST_returnTrue() {
        var bst = new BST();

        var empty = bst.isEmpty();
        var size = bst.getSize();

        assertTrue(empty);
        assertEquals(0, size);
    }

    @Test
    void isEmpty_oneItemBST_returnFalse() {
        var bst = new BST();
        bst.add(10);

        var empty = bst.isEmpty();
        var size = bst.getSize();

        assertFalse(empty);
        assertEquals(1, size);
    }

    @Test
    void contain_emptyBST_returnFalse() {
        var bst = new BST();

        var contain = bst.contains(10);

        assertFalse(contain);
    }

    @Test
    void contain_twoItemBST_returnFalse() {
        var bst = new BST();
        bst.add(5);
        bst.add(3);

        var contain = bst.contains(10);

        assertFalse(contain);
    }

    @Test
    void contain_twoItemBST_returnTrue() {
        var bst = new BST();
        bst.add(5);
        bst.add(3);

        var contain = bst.contains(3);

        assertFalse(contain);
    }

    @Test
    void clear_twoItemBST_isEmptyReturnTrue() {
        var bst = new BST();
        bst.add(5);
        bst.add(3);

        bst.clear();
        var empty = bst.isEmpty();
        assertTrue(empty);
    }

    @Test
    void preOrderTraversalTest() {
        var bst = new BST();
        ArrayList<Integer> valuesList = new ArrayList<>();

        list.forEach(bst::add);
        bst.preOrderTraversal(valuesList::add);

        assert preOrderList.equals(valuesList);
    }


    @Test
    void inOrderTraversalTest() {
        var bst = new BST();
        ArrayList<Integer> valuesList = new ArrayList<>();

        list.forEach(bst::add);
        bst.inOrderTraversal(valuesList::add);

        assert inOrderList.equals(valuesList);
    }


    @Test
    void postOrderTraversalTest() {
        var bst = new BST();
        ArrayList<Integer> valuesList = new ArrayList<>();

        list.forEach(bst::add);
        bst.postOrderTraversal(valuesList::add);

        assert postOrderList.equals(valuesList);
    }
}