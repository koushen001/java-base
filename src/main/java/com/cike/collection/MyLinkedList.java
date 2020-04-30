package com.cike.collection;

/**
 * @Author Kou
 * 自定义链表
 **/
public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public void add(int index, Object obj) {
        Node newNode = new Node(obj);
        Node temp = getNode(index);
        if (temp != null) {
            if (index == size - 1) {
                temp.next = newNode;
                last = newNode;
                size++;
                return;
            }
            Node up = temp.previous;
            if (up != null) {
                up.next = newNode;
            } else {
                first = newNode;
            }
            newNode.previous = up;

            newNode.next = temp;
            temp.previous = newNode;
            size++;
        }
    }

    public void remove(int index) {
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }
            if (index == 0) {
                first = down;
            }
            if (index == size - 1) {
                last = up;
            }
            size--;
        }

    }

    public Object get(int index) {
        return getNode(index).element;

    }

    public Node getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp;
        if (index <= size >> 1) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }

        return temp;

    }

    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element);
            sb.append(",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(0);
        System.out.println(list);
        list.add(1, "ff");
        System.out.println(list);
    }
}
