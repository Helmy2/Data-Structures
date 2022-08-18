package org.example.hash_table;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @param <TKey>   The key type of the key/value pair
 * @param <TValue> The value type of the key/value pair
 */
public class HashTableArrayNode<TKey, TValue> implements Iterable<HashTableNodePair<TKey, TValue>> {
    LinkedList<HashTableNodePair<TKey, TValue>> items = null;

    public LinkedList<HashTableNodePair<TKey, TValue>> getItems() {
        return items;
    }

    /**
     * Adds the key/value pair to the node.  If the key already exists in the
     * list an ArgumentAccessException will be thrown
     *
     * @param key   The key of the item being added
     * @param value The value of the item being added
     */
    public void add(TKey key, TValue value) {
        if (items == null)
            items = new LinkedList<>();
        else {
            for (HashTableNodePair<TKey, TValue> item : items) {
                if (item.getKey() == key)
                    throw new ArgumentAccessException("The collection already contains the key");
            }
        }
        items.add(new HashTableNodePair<TKey, TValue>(key, value));
    }

    /**
     * Updates the value of the existing key/value pair in the list.
     * If the key does not exist in the list an ArgumentAccessException
     * will be thrown.
     *
     * @param key   The key of the item being updated
     * @param value The updated value
     */
    public void update(TKey key, TValue value) {
        boolean updated = false;
        if (items != null) {
            for (HashTableNodePair<TKey, TValue> item : items) {
                if (item.getKey() == key) {
                    item.setValue(value);
                    updated = true;
                }
            }
        }
        if (!updated)
            throw new ArgumentAccessException("The collection does not contain the key");
    }

    /**
     * Finds and returns the value for the specified key.
     *
     * @param key The key whose value is sought
     * @return The value if found, null otherwise
     */
    public TValue getValue(TKey key) {
        if (items != null) {
            for (HashTableNodePair<TKey, TValue> item : items) {
                if (item.getKey() == key)
                    return item.getValue();
            }
        }
        return null;
    }

    /**
     * Removes the item from the list whose key matches
     * the specified key.
     *
     * @param key The key of the item to remove
     * @return True if the item was removed, false otherwise.
     */
    public boolean remove(TKey key) {
        boolean removed = false;
        if (items != null) {
            HashTableNodePair<TKey, TValue> found = null;
            for (HashTableNodePair<TKey, TValue> item : items) {
                if (item.getKey() == key) {
                    found = item;
                    break;
                }
            }
            if (found != null) {
                items.remove(found);
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes all the items from the list
     */
    public void clear() {
        if (items != null)
            items.clear();
    }


    @Override
    public Iterator<HashTableNodePair<TKey, TValue>> iterator() {
        return items.iterator();
    }
}
