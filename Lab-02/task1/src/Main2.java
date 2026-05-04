//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Main2 {
    public Main2() {
    }

    public static void main(String[] var0) {
        BankAccount var1 = new BankAccount("Alex");
        BankAccount var2 = new BankAccount("blue");
        Deposit var3 = new Deposit();
        Withdraw var4 = new Withdraw();
        Statement var5 = new Statement();
        var3.Deposit(var1, (double)1000.0F);
        var4.Withdraw(var1, (double)200.0F);
        var5.Print(var1);
        var3.Deposit(var2, (double)500.0F);
        var4.Withdraw(var2, (double)700.0F);
        var5.Print(var2);
    }
}
