package com.minseungkwon.datastructure.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckStringTest {
    @Test
    public void test_isUniqueUsingArray() {
        String str1 = "abcdefgghijk";
        String str2 = "abcdefghijk";

        CheckString cs = new CheckString();
        assertFalse(cs.isUniqueUsingArray(str1));
        assertTrue(cs.isUniqueUsingArray(str2));
    }

    @Test
    public void test_isUniqueUsingHashSet() {
        String str1 = "abcdefgghijk";
        String str2 = "abcdefghijk";

        CheckString cs = new CheckString();
        assertFalse(cs.isUniqueUsingHashSet(str1));
        assertTrue(cs.isUniqueUsingHashSet(str2));
    }

    @Test
    public void test_isUniqueUsingBitOperatort() {
        String str1 = "abcdefgghijk";
        String str2 = "abcdefghijk";

        CheckString cs = new CheckString();
        assertFalse(cs.isUniqueUsingBitOperator(str1));
        assertTrue(cs.isUniqueUsingBitOperator(str2));
    }

    @Test
    public void test_permutationUsingSort() {
        CheckString cs = new CheckString();
        assertTrue(cs.permutationUsingSort("ABC", "BCA"));
        assertFalse(cs.permutationUsingSort("ABC", "BDA"));
    }

    @Test
    public void test_permutationUsingArray() {
        CheckString cs = new CheckString();
        assertTrue(cs.permutationUsingArray("ABC", "BCA"));
        assertFalse(cs.permutationUsingArray("ABC", "BDA"));
    }

    @Test
    public void test_urlify() {
        CheckString cs = new CheckString();
        assertEquals("Mr%20John%20Smith", cs.urlify("Mr John Smith    ", 13));
    }

    @Test
    public void test_isPermutationOfPalindrome() {
        CheckString cs = new CheckString();
        assertTrue(cs.isPermutationOfPalindrome("aa bb cc dd"));
        assertTrue(cs.isPermutationOfPalindrome("aa bb cc dd e"));
        assertFalse(cs.isPermutationOfPalindrome("aa bb cc dd e fff"));
    }

    @Test
    public void test_isPermutationOfPalindromeWithoutRepetition() {
        CheckString cs = new CheckString();
        assertTrue(cs.isPermutationOfPalindromeWithoutRepetition("aa bb cc dd"));
        assertTrue(cs.isPermutationOfPalindromeWithoutRepetition("aa bb cc dd e"));
        assertFalse(cs.isPermutationOfPalindromeWithoutRepetition("aa bb cc dd e fff"));
    }

    @Test
    public void test_isPermutationOfPalindromeUsingBitOperator() {
        CheckString cs = new CheckString();
        assertTrue(cs.isPermutationOfPalindromeUsingBitOperator("aa bb cc dd"));
        assertTrue(cs.isPermutationOfPalindromeUsingBitOperator("aa bb cc dd e"));
        assertFalse(cs.isPermutationOfPalindromeUsingBitOperator("aa bb cc dd e fff"));
    }

    @Test
    public void test_isOneAway() {
        CheckString cs = new CheckString();
        assertTrue(cs.isOneAway("pal", "pale"));
        assertTrue(cs.isOneAway("pale", "pal"));
        assertTrue(cs.isOneAway("pale", "bale"));
        assertFalse(cs.isOneAway("pal", "pales"));
        assertFalse(cs.isOneAway("pale", "pel"));
        assertFalse(cs.isOneAway("pale", "bake"));
        assertFalse(cs.isOneAway("pple", "ale"));
    }

    @Test
    public void test_compressString() {
        CheckString cs = new CheckString();
        assertEquals("a2b4c3d3", cs.compressString("aabbbbcccddd"));
        assertEquals("abcd", cs.compressString("abcd"));
    }

    @Test
    public void test_isRotation() {
        CheckString cs = new CheckString();
        assertTrue(cs.isRotation("string", "ringst"));
        assertTrue(cs.isRotation("string", "ingstr"));
        assertFalse(cs.isRotation("string", "ingstn"));
        assertFalse(cs.isRotation("string", "ringstr"));
    }

    @Test
    public void test_checkSortedString() {
        assertEquals(351, CheckString.checkSortedString(2));
    }
}