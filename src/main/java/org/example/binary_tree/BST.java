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
     * Removes the first occurrence of the specified value from the tree.
     *
     * @param value The value to remove
     * @return True if the value was removed, false otherwise<
     */
    boolean remove(int value) {
        var temp = remove(root, value);
        if (temp == null)
            return false;
        else {
            size--;
            root = temp;
            return true;
        }
    }

    // Function to delete a node from a BST
    private Node remove(Node root, int key) {
        Node parent = null;

        Node curr = root;

        // search key in the BST and set its parent pointer
        while (curr != null && curr.value != key) {
            parent = curr;
            if (key < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // return if the key is not found in the tree
        if (curr == null) {
            return root;
        }

        // Case 1: node to be deleted has no children, i.e., it is a leaf node
        if (curr.left == null && curr.right == null) {
            // if the node to be deleted is not a root node, then set its
            // parent left/right child to null
            if (curr != root) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // if the tree has only a root node, set it to null
            else {
                root = null;
            }
        }

        // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null) {
            // find its inorder successor node
            Node successor = getMinimumKey(curr.right);

            // store successor value
            int val = successor.value;

            // recursively delete the successor. Note that the successor
            // will have at most one child (right child)
            remove(root, successor.value);

            // copy value of the successor to the current node
            curr.value = val;
        }

        // Case 3: node to be deleted has only one child
        else {
            // choose a child node
            Node child = (curr.left != null) ? curr.left : curr.right;

            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (curr != root) {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }

            // if the node to be deleted is a root node, then set the root to the child
            else {
                root = child;
            }
        }

        return root;
    }

    public static Node getMinimumKey(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
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
