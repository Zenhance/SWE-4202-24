public class Outbox {
    private Message[] queue;
    private int count;

    public Outbox() {
        queue = new Message[100];
        count = 0;
    }

    public void enqueue(Message n) {
        queue[count] = n;
        count++;
    }

    public void enqueue(Message n, int times) {
        for(int i=0; i<times; i++) {
            queue[count] = n;
            count++;
        }
    }

    public int size() {
        return count;
    }

    public String flush() {
        String log = "";
        for(int i=0; i<count; i++) {
            log += queue[i].deliver();
        }
        return log;
    }

    public double totalCost() {
        double total = 0.0;
        for(int i=0; i<count; i++) {
            total += queue[i].cost();
        }
        return total;
    }









}
