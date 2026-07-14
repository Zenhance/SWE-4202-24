public class SendMoney extends Transaction {
    private String fromId;
    private String toId;
    private String pin;
    private String amount;
    private String type;
    private final double fee = 5.0;

    public SendMoney(String type, double amount, String fromId, String toId, String pin) {
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
        this.fee = fee;
    }
}
