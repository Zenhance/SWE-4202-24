import java.security.PublicKey;

public class Outbox {
    private Message[] messages;
    private int messageCount;

    public Outbox() {
        messages = new Message[20];
    }
    public void enqueue(Message m) {
        messages[messageCount++] = m;
    }
    public void enqueue(Message m, int qty) {
        messages[messageCount++] = m;
    }

    public int size() {
        return messageCount;
    }

    public double totalCost() {
        return 0.0;
    }

    public String flush() {
        messageCount = 0;
        return "Ok";
    }
}
