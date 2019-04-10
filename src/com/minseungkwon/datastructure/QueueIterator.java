package com.minseungkwon.datastructure;

import java.util.Iterator;

public interface QueueIterator<T> extends Iterator<T> {
    boolean hasNext();
    T next();
}
