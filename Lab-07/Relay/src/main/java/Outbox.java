public class Outbox {
    private static final int MAX_CAPACITY = 1000;
    private final Message[] queue;
    private int count;

    public Outbox() {
        this.queue = new Message[MAX_CAPACITY];
        this.count = 0;
    }
}