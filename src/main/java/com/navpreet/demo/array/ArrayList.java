package com.navpreet.demo.array;

import static java.lang.System.arraycopy;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E extends Comparable<E>> implements Iterable<E> {

    private Object[] array;
    private int capacity;
    private int length;

    public ArrayList() {
        this(16);
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.length = 0;
    }

    public void add(E item) {
        ensureCapacity();
        this.array[length++] = item;
    }

    private void ensureCapacity() {
        if (this.length == this.array.length) {
            this.capacity *= 2;
            Object[] tempArray = new Object[this.capacity];
            arraycopy(this.array, 0, tempArray, 0, this.array.length);
            this.array = tempArray;
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0) {
            return null;
        }
        E item = (E) this.array[index];
        for (int i = index; i < this.length; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.length - 1] = null;
        this.length--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public E remove(E item) {
        int itemIndex = -1;
        for (int i = 0; i < this.length; i++) {
            if (item.compareTo((E) this.array[i]) == 0) {
                itemIndex = i;
                break;
            }
        }
        remove(itemIndex);
        return item;
    }

    public void shift(int index, E item) {
        ensureCapacity();
        for (int i = this.length - 1; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }
        this.array[index] = item;
        this.length++;
    }

    public void set(int index, E item) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Array index out of bounds: " + index);
        }
        this.array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Array index out of bounds: " + index);
        }
        return (E) this.array[index];
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString() {
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder("[ ");
        for (E e : this) {
            sb.append(isFirst ? "" : ", ").append(e);
            isFirst = false;
        }
        return sb.append(" ]").toString();
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int currentIndex = 0;
            final int size = ArrayList.this.length;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (currentIndex == size) {
                    throw new NoSuchElementException("No Element Found");
                }
                return (E) ArrayList.this.array[currentIndex++];
            }
        };
    }
}
