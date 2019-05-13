package com.minseungkwon.datastructure.String;

public class SimpleStringBuilder {
    int index;
    int size;
    char[] value;

    SimpleStringBuilder() {
        index = 0;
        size = 0;
        value = new char[size];
    }

    public void append(String str) {
        if (str == null) {
            return;
        }
        ensureCapacity(str);
        for (int i = 0; i < str.length(); i++) {
            value[index++] = str.charAt(i);
        }
    }

    private void ensureCapacity(String str) {
        if ((str.length() + index) > size) {
            size = (str.length() + size) * 2;

            char[] newValue = new char[size];
            for (int i = 0; i < index; i++) {
                newValue[i] = value[i];
            }
            value = newValue;
        }
    }

    public String toString() {
        return new String(value, 0, index);
    }
}
