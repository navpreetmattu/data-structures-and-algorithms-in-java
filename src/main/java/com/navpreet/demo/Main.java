package com.navpreet.demo;

import com.navpreet.demo.hashtable.HashTable;

public class Main {

    public static void main(String[] args) {
        var table = new HashTable<String, Integer>();
        table.put("Navpreet", 25);
        table.put("Singh", 34);

        System.out.println(table.get("Navpreet"));
        System.out.println(table.get("Singh"));
    }
}