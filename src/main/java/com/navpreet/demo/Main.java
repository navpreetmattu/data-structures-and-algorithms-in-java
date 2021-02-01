package com.navpreet.demo;

import com.navpreet.demo.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {
        var ls = new LinkedList<Integer>(10);
        ls.append(9);
        ls.append(23);
        ls.append(11);
        ls.prepend(99);
        ls.prepend(101);
        ls.insert(0, 111);
        ls.insert(ls.size(), 112);
        ls.insert(1, 113);
        System.out.println(ls);
        ls.reverse();
        System.out.println(ls);
        for (int i : ls) {
            System.out.println(i);
        }
    }
}