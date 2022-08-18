## Stack

A Last-in, First-out (LIFO) data container.

![Stack image](../images/stack.webp)

### Applications of Stack Data Structure

- To reverse a word - Put all the letters in a stack and pop them out. Because of the LIFO order of stack, you will get
  the letters in reverse order.
- In compilers - Compilers use the stack to calculate the value of expressions like 2 + 4 / 5 * (7 - 9) by converting
  the expression to prefix or postfix form.
- In browsers - The back button in a browser saves all the URLs you have visited previously in a stack. Each time you
  visit a new page, it is added on top of the stack. When you press the back button, the current URL is removed from the
  stack, and the previous URL is accessed.

### Usage

- Deque is based on [Deque](DEQUQ.md)
- [Stack implementation](../src/main/java/org/example/stack/Stack.java)
- [Stack Test](../src/test/java/org/example/stack/StackTest.java)
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
  