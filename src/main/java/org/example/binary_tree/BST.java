package org.example.binary_tree;

public class BST {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;

    /**
     * @return The size of the BST
     */
    public int getSize() {
        return size;
    }


    /**
     * check if the BST is empty
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Adds the provided value to the BST.
     *
     * @param value provided value
     */
    public void add(int value) {
        if (isEmpty())
            root = new Node(value);
        else
            addTo(root, value);
        size++;
    }

    // Recursive add algorithm
    private void addTo(Node node, int value) {
        if (value < node.value) {
            if (node.left == null)
                node.left = new Node(value);
            else
                addTo(node.left, value);
        } else {
            if (node.right == null)
                node.right = new Node(value);
            else
                addTo(node.right, value);
        }
    }


    /**
     * Determines if the specified value exists in the binary tree.
     *
     * @param value The value to search for.
     * @return True if the tree contains the value, false otherwise
     */
    public Boolean contains(int value) {
        return findWithParent(value, root) != null;
    }

    private Node findWithParent(int value, Node parent) {
        if (parent == null)
            return null;
        if (value < parent.value) {
            findWithParent(value, parent.left);
        } else if (value > parent.value) {
            findWithParent(value, parent.right);
        }
        return null;
    }

    /**
     * Removes all items from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Performs the provided action on each binary tree value in pre-order traversal order
     *
     * @param action The action to perform
     */
    public void preOrderTraversal(Action<Integer> action) {
        preOrderTraversal(action, root);
    }

    private void preOrderTraversal(Action<Integer> action, Node node) {
        if (node != null) {
            action.accept(node.value);
            preOrderTraversal(action, node.left);
            preOrderTraversal(action, node.right);
        }
    }


    /**
     * Performs the provided action on each binary tree value in in-order traversal order
     *
     * @param action The action to perform
     */
    public void inOrderTraversal(Action<Integer> action) {
        inOrderTraversal(action, root);
    }

    private void inOrderTraversal(Action<Integer> action, Node node) {
        if (node != null) {
            inOrderTraversal(action, node.left);
            action.accept(node.value);
            inOrderTraversal(action, node.right);
        }
    }


    /**
     * Performs the provided action on each binary tree value in post-order traversal order
     *
     * @param action The action to perform
     */
    public void postOrderTraversal(Action<Integer> action) {
        postOrderTraversal(action, root);
    }

    private void postOrderTraversal(Action<Integer> action, Node node) {
        if (node != null) {
            postOrderTraversal(action, node.left);
            postOrderTraversal(action, node.right);
            action.accept(node.value);
        }
    }

    @FunctionalInterface
    public interface Action<T> {
        void accept(T var1);
    }
}
