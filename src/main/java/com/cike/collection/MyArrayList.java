package com.cike.collection;

/**
 * 自己实现ArrayList
 **/
public class MyArrayList<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E obj) {
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size++] = obj;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
        return (E) elementData[index];
    }

    public void set(E elelent, int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
        elementData[index] = elelent;
    }

    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList s1 = new MyArrayList();
        for (int i = 0; i < 20; i++) {
            s1.add(i);
        }
        System.out.println(s1);
        System.out.println(s1.get(1));
        s1.remove(1);
        System.out.println(s1);
    }

}
