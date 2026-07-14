public class TopUp extends Transaction {
    private String toId;
    private String pin;

    public TopUp(String type, double amount, String fromId, String toId, String pin) {
        this.toId = toId;
        this.pin = pin;
    }
}
