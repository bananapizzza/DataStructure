package com.minseungkwon.datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalShelterTest {

    @Test
    public void test_enqueue() {
        Dog d1 = new Dog("chals");
        Dog d2 = new Dog("july");
        Dog d3 = new Dog("mungmung");
        Cat c1 = new Cat("meow");
        Cat c2 = new Cat("jjokko");
        Cat c3 = new Cat("kkaebi");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        assertEquals("chals meow july jjokko mungmung kkaebi", as.toString());
    }

    @Test
    public void test_dequeueDog() {
        Dog d1 = new Dog("chals");
        Dog d2 = new Dog("july");
        Dog d3 = new Dog("mungmung");
        Cat c1 = new Cat("meow");
        Cat c2 = new Cat("jjokko");
        Cat c3 = new Cat("kkaebi");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        assertEquals("chals", as.dequeueDog().getName());
        assertEquals("july", as.dequeueDog().getName());
        assertEquals("mungmung", as.dequeueDog().getName());
    }

    @Test
    public void test_dequeueCat() {
        Dog d1 = new Dog("chals");
        Dog d2 = new Dog("july");
        Dog d3 = new Dog("mungmung");
        Cat c1 = new Cat("meow");
        Cat c2 = new Cat("jjokko");
        Cat c3 = new Cat("kkaebi");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        assertEquals("meow", as.dequeueCat().getName());
        assertEquals("jjokko", as.dequeueCat().getName());
        assertEquals("kkaebi", as.dequeueCat().getName());
    }

    @Test
    public void test_dequeue() {
        Dog d1 = new Dog("chals");
        Dog d2 = new Dog("july");
        Dog d3 = new Dog("mungmung");
        Cat c1 = new Cat("meow");
        Cat c2 = new Cat("jjokko");
        Cat c3 = new Cat("kkaebi");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        assertEquals("chals", as.dequeue().getName());
        assertEquals("meow", as.dequeue().getName());
        assertEquals("july", as.dequeue().getName());
        assertEquals("jjokko", as.dequeue().getName());
        assertEquals("mungmung", as.dequeue().getName());
        assertEquals("kkaebi", as.dequeue().getName());
    }
}