public interface QueueInterface<T> {
    boolean isEmpty();
    boolean isFull();
    int size();
    void enqueue(T element) throws QueueOverflowException;
    T dequeue() throws QueueUnderflowException;
    T peek() throws QueueUnderflowException;
}