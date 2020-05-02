package com.cike.collection;

public class MyHashMap<K,V> {
    MapNode[] table;
    int size;

    public MyHashMap() {
        table = new MapNode[16];
    }

    public void put(K key, V value) {
        MapNode node = new MapNode();
        node.hash = myHash(key.hashCode(), table.length);
        node.key = key;
        node.value = value;
        node.next = null;
        MapNode temp = table[node.hash];
        MapNode last = null;
        if (temp == null) {
            table[node.hash] = node;
        } else {
            while (temp != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    last = null;
                    break;
                } else {
                    last = temp;
                    temp = temp.next;
                }
            }
            if (last != null) {
                last.next = node;
                size++;
            }

        }
    }

    public int myHash(int v, int length) {
        return v & (length - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < table.length; i++) {
            MapNode temp = table[i];
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }

        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null) {
            MapNode temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = (V)temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(10, "aa");
        map.put(20, "bb");
        map.put(30, "cc");
        map.put(69, "hh");
        map.put(85, "kk");
        System.out.println(map);
        System.out.println(map.get(85));

    }
}
