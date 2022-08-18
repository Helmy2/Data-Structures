package org.example.hash_table;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @param <TKey>   The key type of the key/value pair
 * @param <TValue> The value type of the key/value pair
 */
public class HashTableArray<TKey, TValue> implements Iterable<HashTableArrayNode<TKey, TValue>> {

    private final ArrayList<HashTableArrayNode<TKey, TValue>> array;


    /**
     * Constructs a new hash table array with the specified capacity
     *
     * @param capacity The capacity of the array
     */
    public HashTableArray(int capacity) {
        array = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            array.set(i, new HashTableArrayNode<>());
        }
    }

    /**
     * Adds the key/value pair to the node.  If the key already exists in the
     * node array an ArgumentException will be thrown
     *
     * @param key   The key of the item being added
     * @param value The value of the item being added
     */
    public void add(TKey key, TValue value) {
        array.get(getIndex(key)).add(key, value);
    }

    /**
     * Updates the value of the existing key/value pair in the node array.
     * If the key does not exist in the array an ArgumentException
     * will be thrown.
     *
     * @param key   The key of the item being updated
     * @param value The updated value
     */
    /// <summary>
    public void update(TKey key, TValue value) {
        array.get(getIndex(key)).update(key, value);
    }

    /**
     * Removes the item from the node array whose key matches
     * the specified key.
     *
     * @param key The key of the item to remove
     * @return True if the item was removed, false otherwise.
     */
    public boolean remove(TKey key) {
        if (key == null)
            return false;


        return array.get(getIndex(key)).remove(key);
    }

    /**
     * Finds and returns the value for the specified key.
     *
     * @param key The key whose value is sought
     * @return The value if found, null otherwise
     */
    public TValue getValue(TKey key) {
        if (key == null)
            return null;

        return array.get(getIndex(key)).getValue(key);
    }

    /**
     * Removes every item from the hash table array
     */
    public void clear() {
        for (HashTableArrayNode<TKey, TValue> item : array) {
            item.clear();
        }
    }

    /**
     * @return The size of Hash Table
     */
    public int getSize() {
        return array.size();
    }

    // Maps a key to the array index based on hash code
    private int getIndex(TKey key) {
        return Math.abs(key.hashCode() % getSize());
    }


    @Override
    public Iterator<HashTableArrayNode<TKey, TValue>> iterator() {
        return array.iterator();
    }
}
