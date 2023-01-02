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
public class BinarArray {

    private int array[];
    private int size;

    public BinarArray(int size) {
        array = new int[size];

        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean delete(int value) {
        if (isEmpty()) {
            return false;
        }
        int j = find(value);
        if (j == size) // can’t find it
        {
            return false;
        } else // found it
        {
            for (int k = j; k < size; k++) // move bigger ones down
            {
                array[k] = array[k + 1];
            }
            size--; // decrement size
            return true;
        }
    } // end delete(

    public int find(int searchKey) {

        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (array[curIn] == searchKey) {
                return curIn; // found it
            } else if (lowerBound > upperBound) {
                return size; // can’t find it
            } else // divide range
            {
                if (array[curIn] < searchKey) {
                    lowerBound = curIn + 1; // it’s in upper half
                } else {
                    upperBound = curIn - 1; // it’s in lower half
                }
            } // end else divide range
        } // end while
    }

    public void insertBinary(int value) {
        if (isFull()) {
            System.out.println("over flow");
            return;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] > value) {
                break;
            }
        }
        for (int j = size; j > i; --j) {
            array[j] = array[j - 1];
        }
        array[i] = value;

    }
}
