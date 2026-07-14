public class TopUp extends Transaction{

    PersonalWallet p;
    AgentWallet g;


    public TopUp(Wallet p, Wallet g, double amount, String pin) {
        super(p, g, amount, pin);
        this.a = p;
        this.b = g;
    }

    @Override
    public void settle() throws Exception {
        try {
            PersonalWallet pw = (PersonalWallet) a;
            AgentWallet aw = (AgentWallet) b;
        } catch (ClassCastException e) {
            throw new OperationNotAllowedException("Transaction NOT possible between these accounts");
        }

        super.settle();

    }
}
