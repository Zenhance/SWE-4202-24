public class TopUp extends Transaction {

    public TopUp(String type,double amount, Wallet fromId, Wallet toId,String pin){
        super(type,amount,fromId,toId,pin);
    }

    public TopUp(PersonalWallet a, AgentWallet b, double v, String number) {
        this.fromId = a;
        this.toId = b;
        this.amount = v;
        this.pin = number;
    }

    public double fee() {
        return 0.0;
    }


    public void settle() {

    }
}