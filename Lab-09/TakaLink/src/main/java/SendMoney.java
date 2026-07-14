public class SendMoney extends Transaction {
    public SendMoney(PersonalWallet a, PersonalWallet b, double v, String number) {
        super();
    }

    public SendMoney(AgentWallet agent, PersonalWallet dest2, double v, String number) {
    }

    public SendMoney(PersonalWallet o, PersonalWallet b, double v, String number) {
    }


    public void settle() {

    }
}
