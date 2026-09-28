import java.util.Random;

public class Broker {

    private static final int MAX_RETRIES = 3;

    private QueueInterface<Message> queue;
    private QueueInterface<Message> deadLetterQueue;
    private Random random;

    public Broker() {
        queue = new LinkedQueue<>();
        deadLetterQueue = new LinkedQueue<>();
        random = new Random();
    }

    public void enqueueMessage(Message message) {
        try {
            queue.enqueue(message);
        } catch (QueueOverflowException e) {
            System.out.println("Could not enqueue message.");
        }
    }

    public void processBatch() {
        while (!queue.isEmpty()) {
            try {
                Message message = queue.dequeue();

                int roll = random.nextInt(100);

                if (roll < message.getSuccessChance()) {
                    System.out.println("SUCCESS: " + message);
                } else {
                    message.incrementRetryCount();

                    if (message.getRetryCount() >= MAX_RETRIES) {
                        deadLetterQueue.enqueue(message);
                        System.out.println("MOVED TO DLQ: " + message);
                    } else {
                        queue.enqueue(message);
                        System.out.println("FAILED: " + message);
                    }
                }

            } catch (QueueUnderflowException | QueueOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayAndClearDLQ() {
        System.out.println("\nDead-Letter Queue:");

        if (deadLetterQueue.isEmpty()) {
            System.out.println("DLQ is empty.");
            return;
        }

        try {
            while (!deadLetterQueue.isEmpty()) {
                System.out.println(deadLetterQueue.dequeue());
            }
        } catch (QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}