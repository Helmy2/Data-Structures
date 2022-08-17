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
    public void remove_Leaf() {
        //          3
        //      1      4
        //        2
        BST tree = new BST();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);

        tree.remove(2);
        assertTreeInOrder(tree, new Integer[]{1, 3, 4});

        tree.remove(4);
        assertTreeInOrder(tree, new Integer[]{1, 3});

        tree.remove(1);
        assertTreeInOrder(tree, new Integer[]{3});
    }


    @Test
    public void remove_OneChild_Right() {
        //          3
        //      1      4
        //        2
        BST tree = new BST();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);

        tree.remove(1);
        assertTreeInOrder(tree, new Integer[]{2, 3, 4});
    }

    @Test
    public void remove_OneChild_Left() {
        //          3
        //      2      4
        //     1
        BST tree = new BST();
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(1);

        tree.remove(2);
        assertTreeInOrder(tree, new Integer[]{1, 3, 4});

    }

    @Test
    public void remove_TwoChild() {
        //          10
        //      5       11
        //     4  9
        //    3  7
        //        8
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(4);
        tree.add(9);
        tree.add(7);
        tree.add(8);
        tree.add(3);
        tree.add(11);

        //          10
        //      7       11
        //     4  9
        //    3  8
        //
        tree.remove(5);
        assertTreeInOrder(tree, new Integer[]{3, 4, 7, 8, 9, 10, 11});
    }

    @Test
    public void remove_Root_TwoChild() {
        //          10
        //      5        20
        //    4   6    15
        //           12
        //             13
        //               14
        BST tree = new BST();
        tree.add(10);
        tree.add(5);
        tree.add(4);
        tree.add(6);

        tree.add(20);
        tree.add(15);
        tree.add(12);
        tree.add(13);
        tree.add(14);

        //          12
        //      5        20
        //    4   6    15
        //           13
        //             14
        //
        tree.remove(10);
        assertTreeInOrder(tree, new Integer[]{4,5,6,12,13,14,15,20});


        //          13
        //      5        20
        //    4   6    15
        //           14
        //
        tree.remove(12);
        assertTreeInOrder(tree, new Integer[]{4,5,6,13,14,15,20});
    }

    @Test
    public void remove_Root_OneChild_Left() {
        //          3
        //      2
        //     1
        BST tree = new BST();
        tree.add(3);
        tree.add(2);
        tree.add(1);

        tree.remove(3);
        assertTreeInOrder(tree, new Integer[]{1,2});
    }

    @Test
    public void remove_Root_OneChild_Right() {
        //          3
        //            4
        //              5
        BST tree = new BST();
        tree.add(3);
        tree.add(4);
        tree.add(5);

        tree.remove(3);
        assertTreeInOrder(tree, new Integer[]{4,5});
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

    private void assertTreeInOrder(BST tree, Integer[] array) {
        var treeArray = new ArrayList<Integer>();
        tree.inOrderTraversal(treeArray::add);

        assertArrayEquals(array, treeArray.toArray());
    }
}