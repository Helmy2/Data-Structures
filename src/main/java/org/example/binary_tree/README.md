## Binary Search Tree

A binary tree where nodes with lessor values are placed to the left of the root, and nodes with equal or greater values
are placed to the right.
![BST image](../../../../../../images/bst-vs-not-bst.webp)
A tree having a right subtree with one value smaller than the root is shown to demonstrate that it is not a valid binary
search tree

### Time Complexity

|          | Worst case | Average Case |
|----------|------------|--------------|
| Search   | O(n)       | O(log n)     |
| Insert   | O(n)       | O(log n)     |
| Deletion | O(n)       | O(log n)     |

### Space Complexity

    O(n)

### Binary Search Tree Applications

- In multilevel indexing in the database
- For dynamic sorting
- For managing virtual memory areas in Unix kernel

### Usage

- [BST implementation](BST.java)
- [BST Test](../../../../../test/java/org/example/binary_tree/BSTTest.java)
- Create
    ```java
    BST bst = new BST();
    ```

- isEmpty
  ```java
  boolean empty = bst.isEmpty();
  ```
  > check if the BST is empty

  > Complexity **O(1)**

- getSize
  ```java
  int size = bst.getSize();
  ```
  > return The size of the BST

  > Complexity **O(1)**


- add
  ```java
  int value = 9;
  bst.add(value);
  ```
  > Adds the provided value to the BST.

  > Complexity **O(log n)**

- contains
  ```java
  int value = 9;
  boolean contain = bst.contains(value);
  ```
  > Determines if the specified value exists in the binary tree.

  > Complexity **O(log n)**

- clear
  ```java
  bst.clear();
  ```
  > Removes all items from the tree

  > Complexity **O(1)**

- remove
  ```java
  boolean removed = remove(value);
  ```
  > RRemoves the first occurrence of the specified value from the tree.

  > Complexity **O(n)**

- preOrderTraversal
  ```java
  bst.preOrderTraversal(value -> {});
  ```
  > Performs the provided action on each binary tree value in pre-order traversal order

  > Complexity **O(n)**

- inOrderTraversal
  ```java
  bst.inOrderTraversal(value -> {});
  ```
  > Performs the provided action on each binary tree value in in-order traversal order

  > Complexity **O(n)**

- postOrderTraversal
  ```java
  bst.postOrderTraversal(value -> {});
  ```
  > Performs the provided action on each binary tree value in post-order traversal order

  > Complexity **O(n)**
  