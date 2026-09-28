public class LinkedQueue<T> implements QueueInterface<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int numElements;

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        numElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T element = front.data;
        front = front.next;
        numElements--;

        if (numElements == 0) {
            rear = null;
        }

        return element;
    }

    @Override
    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        return front.data;
    }
}