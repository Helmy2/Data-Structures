## Hash Table

An associative array container that provides O(1) insert, delete and search operations.
![Deque](../images/hash.webp)

### Applications of Hash Table

- constant time lookup and insertion is required
- cryptographic applications
- indexing data is required

### Usage

- [Hash Table implementation](../src/main/java/org/example/hash_table/HashTable.java)
- Create
    ```java
  HashTable<String,Integer> hashTable = new HashTable<>();
    ```

- add
  ```java
  Sting key = "Key";
  int value = 1;
  hashTable.add(key,value);
  ```
  > return the size of dequeue

  > Complexity **O(1)**

- getValue
  ```java
  Sting key = "Key";
  int value = hashTable.getValue(key,value);
  ```
  > Finds and returns the value for the specified key.

  > Complexity **O(1)**

- setValue
  ```java
  Sting key = "Key";
  int newValue = 19;
  int value = hashTable.getValue(key,newValue);
  ```
  > Sets the value with the specified key

  > Complexity **O(1)**

- remove
  ```java
  hashTable.remove(key);
  ```
  > Removes the item from the hash table whose key matches
  > the specified key.

  > Complexity **O(1)**
