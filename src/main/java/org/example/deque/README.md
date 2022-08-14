### Doubly Ended Queue (deque)

A queue-like container which is both First-in, First-out and Last-in, Last-out.

#### Usage
- Deque is based on [Doubly Linked List](../linked_list/README.md)
- [Deque implementation](Deque.java)
- [Deque Test](DequeTest.java)
- Create
    ```java
  Deque<Integer> deque = new Deque<>();
    ```

- getSize
  ```java
  int size = deque.getSize();
  ```
  > return the size of dequeue

  > Complexity **O(1)**

- enqueueHead
  ```java        
  Integer value = 10;
  deque.addHead(value);
  ```
  > Adds the specified value to the start of the dequeue

  > Complexity **O(1)**

- enqueueHead
  ```java
  Integer value = 10;
  deque.enqueueTail(value);
  ```
  > Adds the specified value to the end of the dequeue

  > Complexity **O(1)**

- dequeueHead
  ```java
  deque.dequeueHead();
  ```
  > Removes the first value from the dequeue.

  > Complexity **O(1)**

- dequeueTail
  ```java
  deque.dequeueTail();
  ```
  > Removes the last value from the dequeue.

  > Complexity **O(1)**

- peekHead
  ```java
  deque.peekHead();
  ```
  > return the first value from the dequeue.
  throws NoSuchElementException if the dequeue is empty

  > Complexity **O(1)**


- peekTail
  ```java
  deque.peekTail();
  ```
  > return the last value from the dequeue.
  throws NoSuchElementException if the dequeue is empty

  > Complexity **O(1)**
