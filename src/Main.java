public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        broker.enqueueMessage(new Message("M001", "First message", 90));
        broker.enqueueMessage(new Message("M002", "Second message", 50));
        broker.enqueueMessage(new Message("M003", "Third message", 20));

        System.out.println("Processing batch:");

        broker.processBatch();
    }
}