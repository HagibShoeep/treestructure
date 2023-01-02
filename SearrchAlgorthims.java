/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

import java.util.ArrayList;

/**
 *
 * @author شعيب
 */
public class SearrchAlgorthims<T> {

    public void BubleSort(T array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((Integer) array[i] < (Integer) array[j]) {

                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    private ArrayList<T> merrgeOrder(ArrayList<T> left, ArrayList<T> right) {
        if ((Integer) left.get(0) > (Integer) right.get(0)) {
            for (int i = 0; i < right.size() - 1; i++) {
                left.add(right.get(i));
            }
            return left;
        } else {

            for (int i = 0; i < left.size() - 1; i++) {
                right.add(left.get(i));
            }
            return right;
        }

    }
}
