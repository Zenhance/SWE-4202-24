public class Outbox {
    private static final int MAX_CAPACITY = 1000;
    private final Message[] queue;
    private int count;

    public Outbox() {
        this.queue = new Message[MAX_CAPACITY];
        this.count = 0;
    }

    public void enqueue(Message message) {
        if (count >= MAX_CAPACITY) {
            throw new IllegalStateException("Outbox queue is entirely full");
        }
        queue[count] = message;
        count++;
    }
}