package com.navpreet.demo.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;

    public LinkedList(E item) {
        this.head = new Node<>(item);
        this.tail = this.head;
        this.length++;
    }

    public void append(E item) {
        var newNode = new Node<>(item);
        this.tail.next = newNode;
        this.tail = this.tail.next;
        this.length++;
    }

    public void prepend(E item) {
        var newNode = new Node<>(item);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void insert(int index, E item) {
        if (index > length) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        if (index == length) {
            this.append(item);
            return;
        }
        if (index == 0) {
            this.prepend(item);
            return;
        }

        var previousNode = findPreviousNode(index);
        var newNode = new Node<>(item);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        length++;
    }

    public E remove(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        E removedItem = null;
        if (index == 0) {
            removedItem = this.head.item;
            this.head = this.head.next;
            this.length--;
            return removedItem;
        }

        var previousNode = findPreviousNode(index);

        removedItem = previousNode.next.item;
        previousNode.next = previousNode.next.next;
        this.length--;
        return removedItem;
    }

    public boolean remove(E item) {
        if (this.head.item.equals(item)) {
            this.head = this.head.next;
            this.length--;
            return true;
        }

        var previousNode = findPreviousNode(item);
        if (previousNode == null) {
            return false;
        }
        previousNode.next = previousNode.next.next;
        this.length--;
        return true;
    }

    private Node<E> findPreviousNode(E item) {
        var currentNode = this.head.next;
        var previousNode = this.head;
        while (currentNode != null && !currentNode.item.equals(item)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return currentNode == null ? null : previousNode;
    }

    private Node<E> findPreviousNode(int index) {
        var currentNode = this.head.next;
        var previousNode = this.head;
        var currentIndex = 1;
        while (currentIndex < index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        return previousNode;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString() {
        var isFirst = true;
        var sb = new StringBuilder("[ ");
        var currentNode = this.head;
        while (currentNode != null) {
            sb.append(isFirst ? "" : ", ").append(currentNode.item);
            isFirst = false;
            currentNode = currentNode.next;
        }
        return sb.append(" ]").toString();
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> node = LinkedList.this.head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (node == null) {
                    throw new NoSuchElementException("Out of Range");
                }
                var item = node.item;
                node = node.next;
                return item;
            }

        };
    }
}
