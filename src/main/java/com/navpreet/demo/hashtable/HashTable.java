package com.navpreet.demo.hashtable;

public class HashTable<K, V> {

    private Entry<K, V>[] entry;

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
