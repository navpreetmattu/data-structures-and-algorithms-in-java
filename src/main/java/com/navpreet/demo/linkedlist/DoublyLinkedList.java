package com.navpreet.demo.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;

    public DoublyLinkedList(E item) {
        this.head = new Node<>(item);
        this.tail = this.head;
        this.length++;
    }

    public void append(E item) {
        var newNode = new Node<>(item);
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void prepend(E item) {
        var newNode = new Node<>(item);
        newNode.next = this.head;
        this.head.previous = newNode;
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

        var currentNode = index > size() / 2 ? findNodeFromEnd(index) : findNodeFromStart(index);
        var newNode = new Node<>(item);
        currentNode.previous.next = newNode;
        newNode.previous = currentNode.previous;
        currentNode.previous = newNode;
        newNode.next = currentNode;
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
            this.head.previous = null;
            this.length--;
            return removedItem;
        }

        var currentNode = index > size() / 2 ? findNodeFromEnd(index) : findNodeFromStart(index);

        removedItem = currentNode.item;
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        this.length--;
        return removedItem;
    }

    public boolean remove(E item) {
        if (this.head.item.equals(item)) {
            this.head = this.head.next;
            this.head.previous = null;
            this.length--;
            return true;
        }

        var currentNode = findCurrentNode(item);
        if (currentNode == null) {
            return false;
        }
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        this.length--;
        return true;
    }

    private Node<E> findCurrentNode(E item) {
        var currentNode = this.head.next;
        while (currentNode != null && !currentNode.item.equals(item)) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node<E> findNodeFromStart(int index) {
        var currentNode = this.head.next;
        var currentIndex = 1;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode;
    }

    private Node<E> findNodeFromEnd(int index) {
        var currentNode = this.tail.previous;
        var currentIndex = size() - 2;
        while (currentIndex > index) {
            currentNode = currentNode.previous;
            currentIndex--;
        }
        return currentNode;
    }

    public int size() {
        return this.length;
    }

    public String toStringReverse() {
        var sb = new StringBuilder("[ ");
        var isFirst = true;
        var currentNode = this.tail;
        while (currentNode != null) {
            sb.append(isFirst ? "" : ", ").append(currentNode.item);
            isFirst = false;
            currentNode = currentNode.previous;
        }
        return sb.append(" ]").toString();
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
        private Node<E> previous;

        public Node(E item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> node = DoublyLinkedList.this.head;

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
