package org.example.hash_table;

/**
 * @param <TKey>   The key type of the key/value pair
 * @param <TValue> The value type of the key/value pair
 */
public class HashTableNodePair<TKey, TValue> {
    private final TKey key;
    private TValue value;

    public HashTableNodePair(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }
}
