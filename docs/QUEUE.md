## Queue

A First-in, First-out (FIFO) container.

![Queue image](../images/queue.webp)

### Complexity

The complexity of enqueue and dequeue operations in a queue using an array is O(1).
If you use pop(N) in python code, then the complexity might be O(n) depending on the position of the item to be popped.

### Applications of Queue

- CPU scheduling, Disk Scheduling
- When data is transferred asynchronously between two processes.The queue is used for synchronization. For example: IO
  Buffers, pipes, file IO, etc
- Handling of interrupts in real-time systems.
- Call Center phone systems use Queues to hold people calling them in order.

### Usage

- Deque is based on [Deque](DEQUQ.md)
- [Queue implementation](../src/main/java/org/example/queue/Queue.java)
- [Queue Test](../src/test/java/org/example/queue/QueueTest.java)
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
  