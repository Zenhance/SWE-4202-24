public class TopUp extends Transaction {
    public TopUp(Wallet w, AgentWallet a, double amount, String pin) {
        super(w, a, amount, pin);
    }

    public double fee() {
        return 0.0;
    }
}
