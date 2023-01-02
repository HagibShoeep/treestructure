/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

import java.util.*;

/**
 *
 * @author شعيب
 */
public class BSTreee<T> {

    public BSTreee() {
        root = null;
        size = 0;
    }

    public BSTNode<T> getRoot() {
        return root;
    }

    public T visit(BSTNode<T> root) {
        return root.getValue();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    //search algorthimes

    public boolean search(BSTNode<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (current.getValue() == value) {
            return true;
        } else if ((Integer) current.getValue() < (Integer) value) {
            return search(current.getLeft(), value);
        } else {
            return search(current.getRight(), value);
        }
    }

    public BSTNode<T> findParent(BSTNode<T> curent, T value) {
        if (curent.getValue() == value) {
            return null;
        }

        if ((Integer) value < (Integer) curent.getValue()) {
            if (curent.getLeft().getValue() == null) {
                return null;
            } else if (curent.getLeft().getValue() == value) {
                return curent;
            } else {
                return findParent(curent.getLeft(), value);
            }
        }//end if
        else {
            if (curent.getRight().getValue() == null) {
                return null;
            } else if ((Integer) value == (Integer) curent.getRight().getValue()) {
                return curent;
            } else {
                return findParent(curent.getRight(), value);
            }

        }//end else
    }

    public BSTNode<T> finedNode(BSTNode<T> curent, T value) {
        if (curent == null) {
            return null;
        }
        if (curent.getValue() == value) {
            return curent;
        } else if ((Integer) curent.getValue() > (Integer) value) {
            return finedNode(curent.getLeft(), value);
        } else {
            return finedNode(curent.getRight(), value);
        }
    }

    public void Preorder(BSTNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());

        Preorder(root.getLeft());

        Preorder(root.getRight());
    }

    public void PostOrder(BSTNode root) {
        if (root == null) {
            return;
        }

        PostOrder(root.getLeft());

        PostOrder(root.getRight());
        System.out.println(root.getValue());
    }

    public void Inorder(BSTNode<T> root) {
        if (root == null) {
            return;
        }

        Inorder(root.getLeft());

        System.out.println(root.getValue());

        Inorder(root.getRight());

    }

    public boolean removeValue(T value) {
        BSTNode<T> node = finedNode(getRoot(), value);

        if (node == null) {
            return false;
        }
        BSTNode<T> parent = findParent(getRoot(), value);
        if (size == 1) {
            root = null;
            return true;
        }
        if (node.getLeft() == null && node.getRight() == null) {//case 1
            if ((Integer) node.getValue() < (Integer) parent.getValue()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (node.getLeft() == null && node.getRight() != null) {
            if ((Integer) node.getValue() < (Integer) parent.getValue()) {
                parent.setLeft(node.getRight());
            } else {
                parent.setRight(node.getRight());
            }

        } else if (node.getLeft() != null && node.getRight() == null) {
            if ((Integer) node.getValue() < (Integer) parent.getValue()) {
                parent.setLeft(node.getLeft());
            } else {
                parent.setRight(node.getLeft());
            }
        } else {
            BSTNode<T> largestValu = node.getLeft();
            while (largestValu.getRight() != null) {
                largestValu = largestValu.getRight();
            }
            findParent(getRoot(), largestValu.getValue()).setRight(null);
            node.setValue(largestValu.getValue());

        }
        size--;
        return true;
    }

    public T findMin(BSTNode<T> root) {
        if (root == null) {
            return (T) (Integer) 0;
        }
        if (root.getLeft() == null) {
            return root.getValue();
        }
        return findMin(root.getLeft());
    }

    public T findMax(BSTNode<T> root) {
        if (root == null) {
            return (T) (Integer) 0;
        }
        if (root.getRight() == null) {
            return root.getValue();
        }
        return findMax(root.getRight());
    }

    public void RightRotate(BSTNode<T> root) {
        BSTNode<T> LeftNode = root.getLeft();//left node 

        root.setLeft(LeftNode.getRight());
        LeftNode.setRight(root);
    }
    private int size;

    public void breadthFirst(BSTNode<T> root) {
        Queue<BSTNode<T>> q = new Queue(getSize());
        while (root != null) {
            System.out.println(root.getValue());
            if (root.getLeft() != null) {
                q.enqueq(root.getLeft());
            } else if (root.getRight() != null) {
                q.enqueq(root.getRight());
            }
            if (!q.isEmpty()) {
                root = q.dequeue();
            } else {
                root = null;
            }
        }

    }

    public void trversePerorder(BSTNode<T> root) {

        if (root == null) {

            return;
        }
        System.out.print(root.getValue() + "  ");

        trversePerorder(root.getLeft());
        trversePerorder(root.getRight());
        // System.out.print("\n/ \\\n");

    }

    public BSTNode<T> removeItem(T data) {
        BSTNode<T> tmp = root;
        if (root.getValue() == data) {
            deleteByMerging(tmp);

            return root;

        }

        while (tmp != null) {
            if ((Integer) data == (Integer) tmp.getValue()) {

                return tmp;
            }
            if ((Integer) data > (Integer) tmp.getValue()) {
                tmp = tmp.getRight();
            }
            if ((Integer) data < (Integer) tmp.getValue()) {
                tmp = tmp.getLeft();
            }

        }

        return null;
    }

    public void deleteByMerging(BSTNode<T> node) {
        BSTNode<T> tmp = node;
        if (node != null) {

            if (node.getRight() != null)// node has no right child: its left
            {
                node = node.getLeft(); // child (if any) is attached to its
            }// parent;
            else if (node.getLeft() == null) // node has no left child: its right
            {
                node = node.getRight(); // child is attached to its parent;
            } else { // be ready for merging subtrees;
                tmp = node.getLeft(); // 1. move left
                while (tmp.getRight() != null)// 2. and then right as far as
                {
                    tmp = tmp.getRight();
                }
                tmp.setRight(node.getRight());// 3. establish the link between
                // the rightmost node of the left
// subtree and the right subtree;
                tmp = node; // 4.
                node = node.getLeft(); // 5.
            }

            root = tmp.getRight();
            root.setLeft(tmp.getLeft());

            tmp = null;

        }
    }

    public void insert(T value1) {
        BSTNode<T> newNode = new BSTNode(value1);
        if (root == null) {
            root = newNode;
            setSize(getSize() + 1);
            return;
        }
        BSTNode<T> p = root;
        BSTNode<T> prev = root;
        while (p != null) {
            prev = p;
            if (((Integer) prev.getValue()) > ((Integer) value1)) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }

        if (((Integer) prev.getValue()) < ((Integer) value1)) {
            prev.setRight(newNode);
        } else {
            prev.setLeft(newNode);
        }
        setSize(getSize() + 1);
    }

    public void setRoot(BSTNode<T> root) {
        this.root = root;
    }

    BSTNode<T> root;

    public void findAndDeleteByMerging(T val) {
        BSTNode<T> node = root;
        BSTNode<T> prev = null;
        while (node != null) {
            if (node.getValue() == val) {
                break;
            }
            prev = node;
            if ((Integer) val < (Integer) node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        if (node != null && node.getValue() == val) {
            if (node == root) {
                deleteByMerging(root);
            } else if (prev.getLeft() == node) {
                deleteByMerging(prev.getLeft());
            } else {
                deleteByMerging(prev.getRight());
            }
        } else if (root != null) {
            System.out.println("  el is not in the tree\n");
        } else {
            System.out.println("the tree is empty\n");
        }

    }

    class BSTNode<T> {

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public BSTNode<T> getLeft() {
            return left;
        }

        public void setLeft(BSTNode<T> left) {
            this.left = left;
        }

        public BSTNode<T> getRight() {
            return right;
        }

        public void setRight(BSTNode<T> right) {
            this.right = right;
        }
        T value;
        BSTNode<T> left, right;

        public BSTNode(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
