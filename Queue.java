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
public class Queue<T> {

    int front, rear;
    int size;

    T queu[];

    public Queue(int size) {
        front = rear = -1;
        this.size = size;

    }

    public boolean isFull() {
        return size == front + 1;
    }

    public void enqueq(T value) {
        if (isFull()) {
            return;
        }
        front++;
        size++;
        queu[front] = value;

    }

    boolean isEmpty() {
        return (front == rear);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        rear++;
        return queu[rear];
    }
}
