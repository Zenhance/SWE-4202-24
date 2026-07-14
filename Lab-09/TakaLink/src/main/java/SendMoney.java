public class SendMoney extends Transaction {


    public SendMoney(String type, double amount, String fromId, String toId, String pin) {
        super(type, amount, fromId, toId, pin);
    }

    public void settle() {
    }
}
