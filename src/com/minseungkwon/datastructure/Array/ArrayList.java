package com.minseungkwon.datastructure.Array;

public class ArrayList {
    int index;
    int size;
    Object[] data;

    ArrayList() {
        this.index = 0;
        this.size = 1;
        this.data = new Object[size];
    }

    public void add(Object obj) {
        if (index == this.size - 1) {
            doubling();
        }
        data[index++] = obj;
    }

    void doubling() {
        size *= 2;
        Object[] newData = new Object[size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void remove(int index) throws Exception {
        if (index < 0) {
            throw new Exception("NegativeValue");
        } else if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        this.index--;
    }

    public Object get(int index) throws Exception {
        if (index < 0) {
            throw new Exception("NegativeValue");
        } else if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        return data[index];
    }
}
