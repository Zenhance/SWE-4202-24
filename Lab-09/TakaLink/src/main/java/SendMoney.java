public class SendMoney extends Transaction {

        private static final double FLAT_FEE = 5.0;

    public SendMoney(Wallet sender, Wallet receiver, double amount, String pin) {
            super(sender, receiver, amount, pin);
        }

        @Override
        public double fee() {
            return FLAT_FEE;
        }

        @Override
        protected TransactionType type() {
            return TransactionType.SEND;
        }
    }

