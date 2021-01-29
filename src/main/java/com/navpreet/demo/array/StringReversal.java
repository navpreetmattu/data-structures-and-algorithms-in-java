package com.navpreet.demo.array;

public class StringReversal {

    private StringReversal() {
    }

    public static String reverse(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        var array = input.split("");
        var length = array.length;
        var arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = array[length - i - 1];
        }
        return String.join("", arr);
    }

    public static String reverseFast(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        var array = input.split("");
        var length = array.length;
        for (int i = 0; i < length / 2; i++) {
            var temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
        return String.join("", array);
    }
}
