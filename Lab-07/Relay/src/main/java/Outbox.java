public class Outbox {
    private final Message[] queue;
    private int size;

    public Outbox() {
        this.queue = new Message[100];
    }

    public void enqueue(Message m) {
        enqueue(m, 1);
    }

    public void enqueue(Message m, int repeat) {
        for (int i = 0; i < repeat; i++) {
            queue[size++] = m;
        }
    }

    public int size() { return size; }

    public double totalCost() {
        double total = 0;
        for (int i = 0; i < size; i++) total += queue[i].cost();
        return total;
    }

    public String flush() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append("\n");
            sb.append(queue[i].deliver());
        }
        size = 0;
        return sb.toString();
    }
}
