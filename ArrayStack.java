package treestructure;

public class ArrayStack<E> {

    public ArrayStack() {
        t = -1;
    }

    public static final int CAPACITY = 1000; // default array capacity
    private E[] data; // generic array used for storage
    private int t;
// index of the top element in stack
    // constructs stack with default capacity

    public ArrayStack(int capacity) {

        data = (E[]) new Object[capacity];

    }

    public int size() {
        return (t + 1);
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e; // increment t before storing new item
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }
}
