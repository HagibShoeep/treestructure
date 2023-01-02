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
public class SingleLinkedList {

    public SingleLinkedList() {
        head = null;
    }

    class Node {

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
        Node next;
        private String data;

        public Node(String data) {
            this.data = data;
            next = null;
        }

    }
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {

            head = newNode;

            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAttail(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {

            head = newNode;

            return;
        }
        Node travers = head;

        while (travers.getNext() != null) {
            travers = travers.getNext();
        }
        travers.setNext(newNode);
    }

    public void travers() {
        if (isEmpty()) {
            return;
        }
        Node node = head;
        while (node.getNext() != null) {
            System.out.print(node.getData() + "-->");
            node = node.getNext();
        }
        System.out.print(node.getData() + "\n");
    }

    public boolean search(String item) {
        if (isEmpty()) {
            return false;
        }
        if (head.getData() == item) {

            return true;
        }

        Node count = head;

        while (count.getData() != item & count.getNext() != null) {

            count = count.getNext();
        }
        if (count.getData() == item) {
            return true;
        }
        return false;
    }

    public String removeItem(String item) {

        if (isEmpty()) {
            return null;
        }
        if (head.getData() == item) {
            head = head.getNext();
            return item;
        }

        Node count = head;
        Node prev = head;

        count = count.getNext();
        while (count.getData() != item & count.getNext() != null) {
            prev = count;
            count = count.getNext();
        }
        String retval = null;
        if (count.getData() == item) {
            retval = count.getData();
            prev.setNext(count.getNext());
            count = null;

        }
        return retval;
    }

}
