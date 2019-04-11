package com.minseungkwon.datastructure;

import java.util.LinkedList;

enum AnimalType {
    DOG, CAT
}

abstract class Animal {
    private AnimalType type;
    private String name;
    private int order;

    Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(AnimalType.CAT, name);
    }
}


public class AnimalShelter {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int dogCount = 0;
        int catCount = 0;
        Dog dog = dogs.get(dogCount);
        Cat cat = cats.get(catCount);

        for (int i = 1; i < order; i++) {
            if (dog.getOrder() == i) {
                s.append(dog.getName());
                if (dogCount < dogs.size() - 1) {
                    dog = dogs.get(++dogCount);
                }
            } else if (cat.getOrder() == i) {
                s.append(cat.getName());
                if (catCount < cats.size() - 1) {
                    cat = cats.get(++catCount);
                }
            } else {
                continue;
            }
            if (i < order - 1) {
                s.append(" ");
            }
        }
        return s.toString();
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueDog() {
        if (dogs.size() == 0) {
            return null;
        }
        return dogs.poll();
    }

    public Animal dequeueCat() {
        if (cats.size() == 0) {
            return null;
        }
        return cats.poll();
    }

    public Animal dequeue() {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        } else if (dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }
        Animal dog = dogs.peek();
        Animal cat = cats.peek();

        if (dog.getOrder() > cat.getOrder()) {
            return cats.poll();
        } else {
            return dogs.poll();
        }
    }
}
