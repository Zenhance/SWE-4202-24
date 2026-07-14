public abstract class Wallet {
        private final String id;
        private double balance;
        private final String pin;
        private boolean frozen;
        private double spentToday;

        public Wallet(String id, double openingBalance, String pin){
            if (id == null || id.isBlank()){
                throw new IllegalArgumentException("Wallet ID cannot be null or blank.");
            }
            if (pin == null){
                throw new IllegalArgumentException("PIN cannot be null.");
            }
            this.id=id;
            this.balance=openingBalance;
            this.pin=pin;
            this.frozen=false;
            this.spentToday=0.0;
        }
        public String id(){
            return id;
        }
        public double balance(){
            return balance;
        }
        public boolean verifyPin(String enteredPin){
            return pin.equals(enteredPin);
        }
        public boolean isFrozen(){
            return frozen;
        }
        public void freeze(){
            frozen = true;
        }
        public void debit(double amount) {
            throws InsufficientBalanceException {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Debit amount must be positive.");
                }
                if (amount > balance) {
                    throw new IllegalArgumentException("The wallet does not have enough balance.");
                }
                balance = balance - amount;
            }
                public void credit(double amount) {

                    if (amount <= 0) {
                        throw new IllegalArgumentException("Credit amount must be positive.");
                    }
                    balance = balance + amount;
                }
            }
            public double remainingLimit() {
                return dailyLimit() - spentToday;
            }
            protected void addSpent(double amount){
                spentToday = spentToday + amount;
            }
            public abstract double dailyLimit();
            public abstract boolean canSendMoney();
            public abstract boolean canCashOut();
            public abstract boolean canMakePayment();
            public abstract boolean canTopUp();
        }
