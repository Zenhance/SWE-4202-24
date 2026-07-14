public class Wallet {
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


}
