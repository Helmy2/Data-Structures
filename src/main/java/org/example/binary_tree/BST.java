package org.example.binary_tree;

public class BST {
    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
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
     * Adds the provided key to the BST.
     *
     * @param key provided key
     */
    public void add(int key) {
        if (isEmpty())
            root = new Node(key);
        else
            addTo(root, key);
        size++;
    }

    // Recursive add algorithm
    private void addTo(Node node, int key) {
        if (key < node.key) {
            if (node.left == null)
                node.left = new Node(key);
            else
                addTo(node.left, key);
        } else {
            if (node.right == null)
                node.right = new Node(key);
            else
                addTo(node.right, key);
        }
    }


    /**
     * Determines if the specified key exists in the binary tree.
     *
     * @param key The key to search for.
     * @return True if the tree contains the key, false otherwise
     */
    public Boolean contains(int key) {
        return findWithParent(key, root) != null;
    }

    private Node findWithParent(int key, Node parent) {
        if (parent == null)
            return null;
        if (key < parent.key) {
            findWithParent(key, parent.left);
        } else if (key > parent.key) {
            findWithParent(key, parent.right);
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
     * Removes the first occurrence of the specified key from the tree.
     *
     * @param key The key to remove
     * @return True if the key was removed, false otherwise<
     */
    boolean remove(int key) {
        var temp = removeRec(root, key);
        if (temp == null)
            return false;
        else {
            size--;
            root = temp;
            return true;
        }
    }

    Node removeRec(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.key)
            node.left = removeRec(node.left, key);
        else if (key > node.key)
            node.right = removeRec(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.key = minValue(node.right);

            node.right = removeRec(node.right, node.key);
        }
        return node;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }


    /**
     * Performs the provided action on each binary tree key in pre-order traversal order
     *
     * @param action The action to perform
     */
    public void preOrderTraversal(Action<Integer> action) {
        preOrderTraversal(action, root);
    }

    private void preOrderTraversal(Action<Integer> action, Node node) {
        if (node != null) {
            action.accept(node.key);
            preOrderTraversal(action, node.left);
            preOrderTraversal(action, node.right);
        }
    }


    /**
     * Performs the provided action on each binary tree key in in-order traversal order
     *
     * @param action The action to perform
     */
    public void inOrderTraversal(Action<Integer> action) {
        inOrderTraversal(action, root);
    }

    private void inOrderTraversal(Action<Integer> action, Node node) {
        if (node != null) {
            inOrderTraversal(action, node.left);
            action.accept(node.key);
            inOrderTraversal(action, node.right);
        }
    }


    /**
     * Performs the provided action on each binary tree key in post-order traversal order
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
            action.accept(node.key);
        }
    }

    @FunctionalInterface
    public interface Action<T> {
        void accept(T var1);
    }
}
