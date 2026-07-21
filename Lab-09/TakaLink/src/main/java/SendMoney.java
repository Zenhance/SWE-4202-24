public class SendMoney extends Transaction {

    public SendMoney(
            Wallet payer,
            Wallet receiver,
            double amount,
            String offeredPin
    ) {
        super(payer, receiver, amount, offeredPin);
    }

    @Override
    public double fee() {
        return 5.0;
    }
}