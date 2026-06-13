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

    public void enqueue(Message message, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            this.enqueue(message);
        }
    }

    public int size() {
        return count;
    }

    public double totalCost() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += queue[i].cost();
        }
        return total;
    }
}