public class TopUp extends Transaction{
    public TopUp(PersonalWallet a, AgentWallet operator, double v, String number) {
        super(a,operator,v,number);
    }

    public double fee() {
        return 0;
    }
}
