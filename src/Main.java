public class Main {
    public static void main(String[] args) {
        QueueInterface<Message> queue = new LinkedQueue<>();

        try {
            queue.enqueue(new Message("M001", "First message"));
            queue.enqueue(new Message("M002", "Second message"));
            queue.enqueue(new Message("M003", "Third message"));

            System.out.println("Dequeuing messages:");

            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }

        } catch (QueueOverflowException | QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}