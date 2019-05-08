package com.minseungkwon.datastructure.String;

import java.util.HashSet;

public class CheckString {

    //When the string is made of only ASCII code
    public boolean isUniqueUsingArray(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] ascii = new boolean[128];
        for (char c : str.toCharArray()) {
            int num = c;
            if (ascii[num]) {
                return false;
            }
            ascii[num] = true;
        }
        return true;
    }

    //When the string is made of Unicode
    public boolean isUniqueUsingHashSet(String str) {
        HashSet<Integer> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            int num = c;
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }

    //When the string is made of all in lower case
    public boolean isUniqueUsingBitOperator(String str) {
        int check = 0;
        for (char c : str.toCharArray()) {
            int num = c - 'a';
            if ((check & 1 << num) > 0) {
                return false;
            }
            check |= 1 << num;
        }
        return true;
    }
}
