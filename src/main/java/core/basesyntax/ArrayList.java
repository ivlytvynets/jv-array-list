package core.basesyntax;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData;
    private int size;

    public ArrayList() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private int newCapacity(int oldCapacity) {
        return (int) (oldCapacity * 1.5);
    }

    private T[] grow() {
        return Arrays.copyOf(elementData, newCapacity(size));
    }

    @Override
    public void add(T value) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (size == elementData.length) {
            grow();
        }
        if (index == size) {
            add(value);
        } else {
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
        }
    }

    @Override
    public void addAll(List<T> list) {
        while (list.size() + size > elementData.length) {
            grow();
        }
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new RuntimeException("Index out of size");
        }
        return elementData[index];
    }

    @Override
    public void set(T value, int index) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T remove(T t) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
