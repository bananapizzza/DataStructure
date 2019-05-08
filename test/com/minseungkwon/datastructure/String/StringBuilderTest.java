package com.minseungkwon.datastructure.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderTest {
    @Test
    public void test_append(){
        StringBuilder sb = new StringBuilder();
        sb.append("sung");
        sb.append(" is");
        sb.append(" pretty");

        String s = "sung is pretty";

        assertEquals(s, sb.toString());
    }
}