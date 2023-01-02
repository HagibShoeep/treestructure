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
public class Heap<T> {

    T heap[];
    int count;
    int left;
    int right;

    public void add(T value) {
        heap[count] = value;
        count = count + 1;
        MinHeapfy();
    }

    public void MinHeapfy() {
        int i = count - 1;
        while (i > 0 && (Integer) heap[i] < (Integer) heap[(i - 1) / 2]) {
            Swape(heap[i], heap[(i - 1) / 2]);
            i = (i - 1) / 2;
        }
    }

    public T Parent(T heap1) {//not emplemented
        return heap[0];
    }

    public void Swape(T val, T val2) {
        T temp;
        temp = val;
        val = val2;
        val2 = temp;
    }

    public boolean removeHeap(T value) {
        int index = FinedIndex(heap, value);
        if (index < 0) {
            return false;
        }
        count = count - 1;
        heap[index] = heap[count];

        while (left < count & (Integer) heap[index] > (Integer) heap[left] || (Integer) heap[index] > (Integer) heap[right]) {
            if ((Integer) heap[left] < (Integer) heap[right]) {
                swap(heap, left, index);
                index = left;

            } else {
                swap(heap, right, index);
                index = right;
            }
        }
        return true;
    }

    public boolean search(T value) {
        int i = 0;
        while (i < count & heap[i] != value) {
            i++;

        }
        if (i < count) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchA(T value) {
        int start = 0;
        int node = 1;
        while (start < count) {

            start = node - 1;
            int end = start + node;
            while (start < count & count < end) {
                if (value == heap[start]) {
                    return true;
                } else if ((Integer) value > (Integer) Parent(heap[start]) & (Integer) value < (Integer) heap[start]) {
                    count = count + 1;
                }
                start = start + 1;
            }
            if (count == node) {
                return false;
            }
            node = node * 2;
        }
        return true;
    }

    private int FinedIndex(T[] heap, T value) {
        for (int i = 0; i < heap.length; i++) {
            if (heap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void swap(T[] heap, int left, int index) {

    }
}
