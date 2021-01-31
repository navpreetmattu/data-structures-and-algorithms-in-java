package com.navpreet.demo;

import java.util.Arrays;

import com.navpreet.demo.hashtable.FirstRecurringCharacter;
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
        ls.insert(4, 113);
        System.out.println(ls.size());
        System.out.println(ls);
        // ls.remove(0);
        // ls.remove(5);
        // System.out.println(ls.remove(Integer.valueOf(1199)));
        System.out.println(ls);

        for(Integer i : ls) {
            System.out.println(i);
        }
    }
}