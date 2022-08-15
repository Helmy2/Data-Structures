### Stack
A Last-in, First-out (LIFO) data container.

#### Usage

- Deque is based on [Deque](../deque/README.md)
- [Stack implementation](Stack.java)
- [Stack Test](../../../../../test/java/org/example/stack/StackTest.java)
- Create
    ```java
    Stack<Integer> stack = new Stack<>();
    ```

- push
  ```java
  Integer value = 10;
  stack.push(i);
  ```
  > Add an element to the top of a stack

  > Complexity **O(1)**

- pop
  ```java
  stack.pop(i);
  ```
  > Remove an element from the top of a stack

  > Complexity **O(1)**
  
- peek
  ```java
  stack.peek(i);
  ```
  > Get the value of the top element without removing it

  > Complexity **O(1)**

- getSize
  ```java
  boolean empty = stack.isEmpty();
  ```
  > return The size of the stack

  > Complexity **O(1)**
  