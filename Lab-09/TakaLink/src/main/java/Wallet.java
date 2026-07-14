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


}
