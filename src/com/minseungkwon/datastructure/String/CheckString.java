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

    //Using sort
    public boolean permutationUsingSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    private String sort(String str) {
        char[] c = str.toCharArray();
        java.util.Arrays.sort(c);
        return new String(c);
    }

    //Using array when the strings are made of ASCII code
    public boolean permutationUsingArray(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (char c : s1.toCharArray()) {
            letters[c]++;
        }
        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public String urlify(String str, int len) {
        return urlify(str.toCharArray(), len);
    }

    String urlify(char[] str, int len) {
        int blank = 0;
        for (int i = 0; i < len; i++) {
            char c = str[i];
            if (c == ' ') {
                blank++;
            }
        }
        int index = len + (blank * 2) - 1;
        for (int p = len - 1; p >= 0; p--) {
            if (str[p] == ' ') {
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            } else {
                str[index--] = str[p];
            }
        }
        return new String(str);
    }

    public boolean isPermutationOfPalindrome(String str) {
        int[] array = new int[26];
        for (char c : str.toCharArray()) {
            int index = getCharNumber(c);
            if (index != -1) {
                array[index]++;
            }
        }
        boolean isOnlyOneOdd = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && !isOnlyOneOdd) {
                isOnlyOneOdd = true;
            } else if (array[i] % 2 != 0 && isOnlyOneOdd) {
                return false;
            }
        }
        return true;
    }

    private int getCharNumber(char c) {
        if ('a' <= c && c <= 'z') {
            return (int) c - 'a';
        } else {
            return -1;
        }
    }

    public boolean isPermutationOfPalindromeWithoutRepetition(String str) {
        int[] array = new int[26];
        int numOfOdd = 0;
        for (char c : str.toCharArray()) {
            int index = getCharNumber(c);
            if (index != -1) {
                array[index]++;
                if (array[index] % 2 == 1) {
                    numOfOdd++;
                } else {
                    numOfOdd--;
                }
            }
        }
        return numOfOdd == 0 || numOfOdd == 1;
    }

    public boolean isPermutationOfPalindromeUsingBitOperator(String str) {
        int bitCheck = 0;
        for (char c : str.toCharArray()) {
            int num = getCharNumber(c);
            if (num != -1) {
                num = 1 << num;
                if ((bitCheck & num) == 0) {
                    bitCheck |= num;
                } else {
                    bitCheck &= ~num;
                }
            }
        }
        if (bitCheck == 0) {
            return true;
        } else {
            if (((bitCheck - 1) & bitCheck) != 0) {
                return false;
            }
        }
        return true;
    }
}
