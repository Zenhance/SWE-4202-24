public class Outbox {
    private static final int DEFAULT_CAPACITY = 100;
    private final Message[] messages;
    private int count;

    public Outbox() {
        this.messages = new Message[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public void enqueue(Message message) {
        enqueue(message, 1);
    }

    public void enqueue(Message message, int repeats) {
        if (message == null || repeats < 1) {
            throw new IllegalArgumentException("Invalid message or repeat count");
        }
        for (int i = 0; i < repeats; i++) {
            if (count >= messages.length) {
                throw new IllegalStateException("Outbox is full");
            }
            messages[count++] = message;
        }
    }

    public String flush() {
        StringBuilder log = new StringBuilder();
        for (int i = 0; i < count; i++) {
            log.append(messages[i].deliver()).append("\n");
        }
        String result = log.toString().trim();
        count = 0;
        return result;
    }

    public double totalCost() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += messages[i].cost();
        }
        return total;
    }
    public int size() {
        return count;
    }
}