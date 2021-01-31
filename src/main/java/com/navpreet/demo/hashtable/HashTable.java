package com.navpreet.demo.hashtable;

public class HashTable<K, V> {

    private static final int DEFAULT_BUCKET_SIZE = 16;

    private Entry<K, V>[] entry;
    private int length = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.entry = new Entry[DEFAULT_BUCKET_SIZE];
    }

    public void put(K key, V value) {
        int bucket = hashCode(key);
        this.entry[bucket] = new Entry<>(key, value);
        this.length++;
    }

    public V get(K key) {
        var bucket = hashCode(key);
        var en = this.entry[bucket];
        if (en != null && en.getKey().equals(key)) {
            return en.getValue();
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    public K[] keys() {
        int j = 0;
        Object[] arr = new Object[this.entry.length];
        for (int i = 0; i < this.entry.length; i++) {
            if (this.entry[i] != null) {
                arr[j]=this.entry[i].getKey();
                j++;
            }
        }
        Object[] obj = new Object[j];
        System.arraycopy(arr, 0, obj, 0, j);
        return (K[]) obj;
    }

    private int hashCode(K key) {
        return Math.abs(1 * key.hashCode()) % DEFAULT_BUCKET_SIZE;
    }

    static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return this.value;
        }
    }
}
