import java.util.Objects;

public abstract class Wallet {
    public String identity;
    public double balance;
    private String pin;
    public boolean frozen;
    public int total_sent;
    public Wallet(String identity, double balance, String pin) {
        if(identity==null|| identity.equals(" ")) throw new IllegalArgumentException();
        if(balance<0.0) throw new IllegalArgumentException();
        if(pin==null) throw new IllegalArgumentException();
        this.identity = identity;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.total_sent = 0;
    }
    public void debit(double amount) {
        if(amount<0.0) throw new IllegalArgumentException();
        if(amount>balance) throw new InsufficientBalanceException();
        balance -= amount;
        this.total_sent += amount;
    }
    public void credit(double amount) {
        if(amount<=0.0) throw new IllegalArgumentException();
        amount+=balance;
    }
    public double balance() {
        return balance;
    }
    public boolean verifyPin(String number) {
        return Objects.equals(number, pin);
    }
    public void freeze() {
        this.frozen = true;
    }

}
