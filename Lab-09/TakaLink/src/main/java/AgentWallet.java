public class AgentWallet extends Wallet{

    double limit = 500000;
    public double daily = limit;

    public AgentWallet(String name, double deposit, String pin){
        super(name, deposit, pin);
    }
}
