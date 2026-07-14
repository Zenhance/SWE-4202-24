public abstract class Wallet {
        private final String id;
        private double balance;
        private final String pin;
        private boolean frozen;
        private double spentToday;
        protected Wallet(String id,String pin, double openingBalance){
if(id==null||id.isBlank()){
    throw new IllegalArguementException("Id can't be null or blank!");
        }
if(openingBalance<0.0){
    throw new IllegalArguementException("Opening balance can't be negative!");
            }
if(pin==null){
    throw new IllegalArguementException("Pin can't be null!");
            }
            this.id=id;
            this.balance=balance;
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
    public void debit(double amount)throws insufficientBalanceException{
        if(amount<=0.0){
            throw new IllegalArguementException("Debit must be a positive amount!");
    }
        if(balance<amount){
            throw new InsufficientBalanceExcption("Balance is not sufficient!");
        }
        balance-=amount;
    }
    public void credit(double amount){
        if(amount<=0.0){
            throw new IllegalArguementException("Credit must be a positive amount!");
        }
        balance+=amount;}
    public boolean verifyPin(String enPin){
            return pin.equals(enPin);
    }
    public boolean isFrozen(){
            return frozen;
    }
    public void freeze(){
            frozen=true;
    }
    public double remainingDailyLimit(){
            return Math.max(0.0,dailyLimit()-spentToday);
        }
        final void recordSpend(double amount){
            spentToday+=amount;
    }
    protected abstract double dailyLimit();
    public abstract boolean canSendMoney();
    public abstract boolean canCashOut();
    public abstract boolean canMakePayment();
    public abstract boolean canTopUp();
    public boolean canReceiveCashOut(){
    return false;}
public boolean canReceivePayment(){
    return false;
}
}
