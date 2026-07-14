public class CashOut extends Transaction {
    private String fromId;
    private String toId;
    private String pin;
    private double amount;
    private final double fee = 0.0185;

    public CashOut(String type, double amount, String fromId, String toId, String pin) {
        this.fromId = fromId;
        this.toId = toId;
        this.pin = pin;
    }


}
