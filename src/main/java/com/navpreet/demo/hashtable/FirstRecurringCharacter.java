package com.navpreet.demo.hashtable;

import java.util.HashSet;

public class FirstRecurringCharacter {

    private FirstRecurringCharacter() {
    }

    public static final Integer firstRecurringCharacter(int[] array) {
        var memory = new HashSet<Integer>();
        for (int val : array) {
            if (memory.contains(val)) {
                return val;
            }
            memory.add(val);
        }
        return null;
    }
}
