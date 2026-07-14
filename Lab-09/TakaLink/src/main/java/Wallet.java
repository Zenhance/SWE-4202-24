public abstract class Wallet {

    protected boolean frozen = false;
    String name;
    protected double balance;
    String pin;
    protected double limit;
    public double daily = limit;

    public Wallet(String name, double balance, String pin){
        if(name==null || name.isBlank() || pin==null || balance <0){
            throw new IllegalArgumentException("Wrong Input! Please try again :)");
        }
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean verifyPin(String p){
        if(p.equals(pin)) return true;
        return false;
    }

    public void debit (double tk) throws Exception {
        if(tk <= 0 ){
            throw new IllegalArgumentException("The amount cannot be debited");
        }
        if(tk > balance)
            throw new InsufficientBalanceException("The amount cannot be debited");
        balance -= tk;
    }

    public void credit (double tk) throws Exception {
        if(tk <= 0 ){
            throw new IllegalArgumentException("The amount cannot be debited");
        }
        if(tk > balance)
            throw new InsufficientBalanceException("The amount cannot be debited");
        balance += tk;
    }


    public double balance(){
        return balance;
    }

    public double getLimit() {
        return limit;
    }

    public void freeze(){frozen = true;}

    public boolean isFrozen() {
        return frozen;
    }
}
