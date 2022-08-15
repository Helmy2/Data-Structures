### Queue

A First-in, First-out (FIFO) container.

#### Usage

- Deque is based on [Deque](../deque/README.md)
- [Queue implementation](Queue.java)
- [Queue Test](../../../../../test/java/org/example/queue/QueueTest.java)
- Create
    ```java
    Queue<Integer> queue = new Queue<>();
    ```

- enqueue
  ```java
  Integer value = 10;
  queue.enqueue(i);
  ```
  > Add an element to the end of the queue

  > Complexity **O(1)**


- dequeue
  ```java
  queue.dequeue();
  ```
  > Remove an element from the front of the queue

  > Complexity **O(1)**

- peek
  ```java
  queue.peek();
  ```
  > Get the value of the front of the queue without removing it

  > Complexity **O(1)**

- getSize
  ```java
  boolean empty = queue.isEmpty();
  ```
  > return The size of the queue

  > Complexity **O(1)**
  