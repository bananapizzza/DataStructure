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

    //There are 3 different modifiable ways: 1. Delete one letter, 2. Insert one letter, 3. Change one letter
    //Check if one string is just one modification away from another string
    public boolean isOneAway(String s1, String s2) {
        String ls;
        String ss;

        //Set longer string to ls, and shorter string to ss
        if (s1.length() > s2.length()) {
            ls = s1;
            ss = s2;
        } else {
            ls = s2;
            ss = s1;
        }

        //If the length difference of two strings is more than 2, it means it is modified more than 2 times
        if (ls.length() - ss.length() > 1) {
            return false;
        }

        boolean isDifferent = false;
        for (int i = 0, j = 0; i < ss.length(); ) {
            if (ss.charAt(i) != ls.charAt(j)) {
                //If it is modified just once, it's fine. But if it's modified more than 2, it returns false
                if (!isDifferent) {
                    isDifferent = true;
                } else {
                    return false;
                }

                //If the string lengths of are different, only increase the longer string's index
                if (ss.length() != ls.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    //Compress the string with repetitive letters (Assume that the string is sorted)
    //The compressed form should be Letter+The number of the letter
    //eg. aabbbbcccddd -> a2b4c3d3
    //If the compressed string is longer than the original string, return the original string
    //In this solution, tried to avoid recreating char array when the string length is getting longer than the current array size
    //Therefore, it calculates the compressed string size first, and declare StringBuilder with the size
    public String compressString(String str) {
        String newstring = compress(str);
        return newstring.length() > str.length() ? str : newstring;
    }

    private String compress(String str) {
        StringBuilder sb = new StringBuilder(getCompressedLength(str));
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }

    private int getCompressedLength(String str) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                total += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return total;
    }

    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return isSubstring(s1 + s1, s2);
    }

    private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    //The number of alphabet
    private static final int ALPHABET = 26;

    public static int checkSortedString(int k) {
        if (k == 0) {
            return 0;
        }
        return checkSortedString(k, "");
    }

    private static int checkSortedString(int k, String prefix) {
        if (k == 0) {
            //If the string is sorted, increase the number of sorted strings
            if (isInOrder(prefix)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            //Make combinations start from a to z
            int count = 0;
            for (int i = 0; i < ALPHABET; i++) {
                char c = getIthChar(i);
                count += checkSortedString(k - 1, prefix + c);
            }
            return count;
        }
    }

    //Check if the string is sorted
    private static boolean isInOrder(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) > str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static char getIthChar(int i) {
        return (char) (i + 'a');
    }
}
