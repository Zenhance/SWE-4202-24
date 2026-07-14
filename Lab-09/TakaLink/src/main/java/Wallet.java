
    public class Wallet {

        private String id;
        private double balance;
        private boolean frozen;
        private double spentToday;
        private String pin;


        public Wallet(String id, double balance, String pin) {
            if (id == null) throw new NullPointerException("Must provide an ID");
            if(balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
            if(pin == null) throw new NullPointerException("Must provide pin");

            spentToday = 0.0;
            this.balance = balance;
            this.id = id;
            this.pin = pin;
        }

        public void debit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be over 0, got" + amount);
            if (amount > balance) throw new IllegalStateException("Your balance (currently :" + balance + ")too low for withdrawal amount: " + amount);

            spentToday += amount;
            balance -= amount;
        }

        public void credit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be above 0.0, got" + amount);

            balance += amount;
        }

        public boolean verifyPin(String number) {
            return pin.equals(number);
        }

        public void freeze() {
            this.frozen = true;
        }

        public double balance() {
            return balance;
        }


        public final boolean isFrozen() {
            return frozen;
        }


        public final void unfreeze() {
            this.frozen = false;
        }

        public final String id() {
            return id;
        }



    }
