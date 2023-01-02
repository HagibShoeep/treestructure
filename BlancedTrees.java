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
public class BlancedTrees<T> {

    public int Hight(Node<T> curent) {

        return 0;
    }

    class Node<T> {

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    Node<T> root;

    public void insertValue(T value) {
        if (root == null) {
            root = new Node(value);
            return;
        } else {
            insertNode(root, value);
        }
    }

    public void insertNode(Node<T> root, T value) {
        if ((Integer) value < (Integer) root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(new Node(value));
            } else {
                insertNode(root.getLeft(), value);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node(value));
            } else {
                insertNode(root.getRight(), value);
            }
        }

    }

    public void checkBlance(Node<T> current) {
    }

    public void RightRotate(Node<T> root) {
        Node<T> LeftNode = root.getLeft();//left node 

        root.setLeft(LeftNode.getRight());
        LeftNode.setRight(root);
    }

    public void LeftRotate(Node<T> root) {
        Node<T> RightNode = root.getRight();

        root.setRight(RightNode.getLeft());
        RightNode.setLeft(root);
    }

}
