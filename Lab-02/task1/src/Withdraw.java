
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Withdraw {

    void Withdraw(BankAccount var1, double var2) {
        if (var2 > var1.balance) {
            System.out.println(var1.owner + ": Insufficient funds");
        } else {
            var1.balance -= var2;
        }

    }
}
