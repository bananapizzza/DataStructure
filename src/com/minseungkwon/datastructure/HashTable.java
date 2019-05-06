package com.minseungkwon.datastructure;

import java.util.LinkedList;

public class HashTable {
    class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] data;

    HashTable(int size) {
        data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }

    int getIndex(int hashcode) {
        return hashcode % data.length;
    }

    Node searchKey(LinkedList<Node> ll, String key) {
        if (ll == null) {
            return null;
        }
        for (Node n : ll) {
            if (n.key.equals(key)) {
                return n;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashcode = getHashCode(key);
        int index = getIndex(hashcode);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        Node n = searchKey(data[index], key);
        if (n == null) {
            data[index].addLast(new Node(key, value));
        } else {
            n.value = value;
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key);
        int index = getIndex(hashcode);
        Node n = searchKey(data[index], key);
        return n == null ? "Not found" : n.value;
    }
}
