public class SendMoney extends Transaction {
    private String fromId;
    private String toId;

    public SendMoney(String type, double amount, String fromId, String toId, String pin) {
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
        this.fee = fee;
    }
}
