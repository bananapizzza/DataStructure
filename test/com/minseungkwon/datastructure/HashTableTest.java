package com.minseungkwon.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void test_getHashCode() {
        HashTable h = new HashTable(3);
        String s = "sung";
        assertEquals(445, h.getHashCode(s));
    }

    @Test
    public void test_putAndGet() {
        HashTable h = new HashTable(3);
        h.put("sung", "she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");

        assertEquals("she is pretty", h.get("sung"));
    }

    @Test
    public void test_putAndGetNotFound() {
        HashTable h = new HashTable(3);
        h.put("sung", "she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");

        assertEquals(null, h.get("jae"));
    }

    @Test
    public void test_putAndGetChangeValue() {
        HashTable h = new HashTable(3);
        h.put("sung", "she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");
        h.put("sung", "she is beautiful");

        assertEquals("she is beautiful", h.get("sung"));
    }
}