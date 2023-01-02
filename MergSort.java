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
public class MergSort<T> {

    public void mergeSort(int list[], int left, int medium, int right) {
        int size1 = medium - left + 1;
        int size2 = right - medium;
        int Left[] = new int[size1];
        int Right[] = new int[size2];

        for (int CounterLeft = 0; CounterLeft < size1; CounterLeft++) {
            Left[CounterLeft] = list[left + CounterLeft];
        }

        for (int CounterRight = 0; CounterRight < size2; ++CounterRight) {
            Right[CounterRight] = list[medium + 1 + CounterRight];
        }

        int ICounter = 0, JCounter = 0;
        int counter = left;

        while (ICounter < size1 & JCounter < size2) {

            if (Left[ICounter] <= Right[JCounter]) {
                list[counter] = Left[ICounter];
                ICounter++;
            } else {
                list[counter] = Right[JCounter];
                JCounter++;
            }
            counter++;
        }
        while (ICounter < size1) {
            list[counter] = Left[ICounter];
            ICounter++;
            counter++;

        }
        while (JCounter < size2) {
            list[counter] = Right[JCounter];
            JCounter++;
            counter++;

        }
    }

    public void sort(int list[], int left, int right) {
        if (left < right) {
            int medium = left + (right - left) / 2;
            sort(list, left, medium);
            sort(list, medium + 1, right);
            mergeSort(list, left, medium, right);

        }
    }

    public void printArray(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
