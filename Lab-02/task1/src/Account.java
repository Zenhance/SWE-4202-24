public class Account {
    String name;
    double balance;
    public Account(String name){
        this.name=name;
        this.balance=0.0;
    }
    public void printStatement() {
        System.out.println("The owner name " + name);
        System.out.println("The Balance is " + balance);
    }
}
