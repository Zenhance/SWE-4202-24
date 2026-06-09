public abstract class Message {
    Recipient recipient;
    String line;

    String deliver() {
        return null;
    }

    double cost() {
        return 0;
    }
}
