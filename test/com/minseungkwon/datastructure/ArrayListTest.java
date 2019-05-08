package com.minseungkwon.datastructure;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void test_add(){
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);

        for(int i = 0; i<al.index; i++){
            try {
                assertEquals(i+1, al.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test_remove(){
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);
        try {
            al.remove(5);
            al.remove(5);
            al.remove(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(9, al.get(5));
            assertEquals(6, al.index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}