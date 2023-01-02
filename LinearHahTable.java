/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

/**
 *
 * @author شعيب
 */
public class LinearHahTable {

    private String[] keys;
    private String[] vals;
    private int cutrentSize, maxSize;

    public LinearHahTable(int copcity) {
        maxSize = copcity;
        cutrentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    public void makeEmpty() {
        cutrentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    public int getSize() {
        return cutrentSize;
    }

    public void printHashTable() {
        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null) {
                System.out.print("  " + keys[i] + "-->" + vals[i]);
            }
        }
    }

    public boolean isEmpty() {
        return cutrentSize == 0;
    }

    public void insert(String key, String val) {
        int temp = hash(key);
        int i = temp;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = val;
                cutrentSize++;
                return;
            }
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            i = (i + 1) % maxSize;

        } while (i != temp);
    }

    public void remove(String key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!keys.equals(keys[i])) {
            i = (i + 1) % maxSize;
        }
        keys[i] = vals[i] = null;
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
            String temp1 = keys[i], temp2 = vals[i];
            keys[i] = vals[i] = null;
            cutrentSize--;
            insert(temp1, temp2);
        }
        cutrentSize--;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    private int hash(String key) {
        return key.hashCode() % maxSize;
    }

    public String get(String key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
            i = (i + 1) % maxSize;
        }
        return null;
    }
}
