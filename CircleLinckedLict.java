/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

public class CircleLinckedLict {

    class node {

        int data;
        node next;

        node(int data) {
            this.data = data;
            next = null;
        }
    }

    node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAthead(int value) {
        node newnode;
        newnode = new node(value);
        if (isEmpty()) {

            head = newnode;
            head.next = head;
            return;
        }

        newnode.next = head.next;

        head.next = newnode;

    }

    public void insertATail(int value) {
        node newnode;
        newnode = new node(value);
        if (isEmpty()) {

            head = newnode;
            head.next = head;
            return;
        }

        newnode.next = head.next;

        head.next = newnode;
        head = newnode;

    }

    public int removeItem(int item) {

        if (isEmpty()) {
            return -1;
        }
        node newNode = head.next;
        node befor = head;
        if (head.data == item) {

            head = head.next;
            return befor.data;
        }
        while (newNode.data != item && newNode.next != null) {
            befor = newNode;
            newNode = newNode.next;

        }
        int value = -1;
        if (newNode.data == item) {
            befor.next = newNode.next;
            newNode.next = null;
            value = newNode.data;
            newNode = null;
        }

        return value;

    }

    public boolean search(int value) {
        if (isEmpty()) {
            return false;
        }

        node nodeIterator = head;
        nodeIterator = nodeIterator.next;
        while (nodeIterator.data != value && nodeIterator != head) {

            nodeIterator = nodeIterator.next;
        }
        if (nodeIterator.data == value) {
            return true;
        }
        return false;
    }

    public void travers() {

        if (head == null) {
            return;
        }
        node newnode;
        newnode = head;
        newnode = newnode.next;
        while (newnode != head) {
            System.out.println(newnode.data);;
            newnode = newnode.next;
        }
        System.out.println(newnode.data);;
    }
}
