public class Outbox {

    private static final int CAPACITY = 100;
    private final Notice[] notices;
    private int count;

    public Outbox() {
        this(CAPACITY);
    }

    public Outbox(int capacity) {
        notices = new Notice[capacity];
        count = 0;
    }

    public void queue(Notice notice) {
        queue(notice, 1);
    }

    public void queue(Notice notice, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            if (count >= notices.length) {
                throw new IllegalStateException("Outbox is full");
            }
            notices[count] = notice;
            count++;
        }
    }

    public String flush() {
        String log = "";
        for (int i = 0; i < count; i++) {
            log += notices[i].deliver();
            if (i < count - 1) {
                log += "\n";
            }
        }
        count = 0;
        return log;
    }

    public double totalCost() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += notices[i].cost();
        }
        return total;
    }
    public int waitingCount() {
        return count;
    }
}