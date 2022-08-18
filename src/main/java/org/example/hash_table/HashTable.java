package org.example.hash_table;


import java.util.NoSuchElementException;

/**
 * @param <TKey>   The key type of the key/value pair
 * @param <TValue> The value type of the key/value pair
 */
public class HashTable<TKey, TValue> {
    // If the array exceeds this fill percentage it will grow
    // In this example the fill factor is the total number of items
    // regardless of whether they are collisions or not.
    private static final double fillFactor = 0.75;

    // the maximum number of items to store before growing.
    // This is just a cached value of the fill factor calculation
    private int maxItemsAtCurrentSize;

    // the number of items in the hash table
    private int size;

    // The array where the items are stored.
    HashTableArray<TKey, TValue> array;

    /**
     * Constructs a hash table with the specified capacity
     */
    public HashTable() {
        this(1000);
    }

    public HashTable(int initialCapacity) {
        if (initialCapacity < 1)
            throw new ExceptionInInitializerError("initialCapacity");

        array = new HashTableArray<>(initialCapacity);

        // when the count exceeds this value, the next Add will cause the
        // array to grow
        maxItemsAtCurrentSize = (int) (initialCapacity * fillFactor) + 1;
    }


    /**
     * Adds the key/value pair to the hash table.  If the key already exists in the
     * hash table an ArgumentException will be thrown
     *
     * @param key   The key of the item being added
     * @param value The value of the item being added
     */
    public void add(TKey key, TValue value) {
        if (key == null) {
            throw new NullPointerException();
        }

        // if we are at capacity, the array needs to grow
        if (size >= maxItemsAtCurrentSize) {
            // allocate a larger array
            HashTableArray<TKey, TValue> largerArray =
                    new HashTableArray<>(array.getSize() * 2);

            // and re-add each item to the new array
            for (HashTableArrayNode<TKey, TValue> items : array) {
                for (HashTableNodePair<TKey, TValue> item : items) {
                    largerArray.add(item.getKey(), item.getValue());
                }
            }

            // the larger array is now the hash table storage
            array = largerArray;

            // update the new max items cached value
            maxItemsAtCurrentSize = (int) (array.getSize() * fillFactor) + 1;
        }

        array.add(key, value);
        size++;
    }

    /**
     * Finds and returns the value for the specified key.
     *
     * @param key The key whose value is sought
     * @return The value associated with the specified key, null otherwise.
     */
    public TValue getValue(TKey key) {
        return array.getValue(key);
    }

    /**
     * Sets the value with the specified key
     *
     * @param key      The key of the value to retrieve
     * @param newValue The key of the value to retrieve
     */
    public void setValue(TKey key, TValue newValue) {
        TValue value = array.getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        array.update(key, newValue);
    }

    /**
     * Removes the item from the hash table whose key matches
     * the specified key.
     *
     * @param key The key of the item to remove
     * @return True if the item was removed, false otherwise.
     */
    public boolean remove(TKey key) {
        boolean removed = array.remove(key);
        if (removed)
            size--;

        return removed;
    }
}
