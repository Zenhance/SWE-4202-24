public class CashOut extends Transaction {
    public CashOut(PersonalWallet a, AgentWallet g, double v, String number) {
    }

    public CashOut(PersonalWallet a, PersonalWallet b, double v, String number) {

    }

    @Override
    public double getFee() {
        return 0;
    }

    public void settle() {
    }
}
