/*
a. The information that every account needs to store include private fields like String name, double balance and public methods like deposit(amount), withdraw(amount) and printStatement().
b. The customer can deposit or add an amount to his existing amount(input-deposited amount; change-updated balance; output-prints an error if amount is negative or zero), withdraw amount from his account which would deduct amount from his current balance(input-amount to be withdrawn; change-updated balance after deduction; output-if the balance becomes less than zero then prints "Insufficient funds") and print the statement of his current balance along with his name(input-none; change-none; output-owner's name with current balance).
c. If we store all account balance in one big array and have another array for all the names then for 200 customers we would need to create two separate arrays, each of 200 elements. In that case change for one customer would require us to make changes in the arrays, that too, twice which would be a big hassle and time consuming.
d. In order to add a transaction limit per day, i would create another method to the class and call it in main function each time in order to ensure the limit doesn't exceed.
 */
public class BankAccount {
    String name;
    double balance = 0;

    BankAccount(String name) {
        this.name = name;
    }

    void deposit(double amount) {
        balance += amount;
        if (amount <= 0) {
            System.out.println("error");
        }
        return;
    }

    void withdraw(double amount){
        balance -= amount;
        if(amount<0 || amount>balance) {
            System.out.println("Insufficient funds");
        }
        return;
    }

    void printStatement(){

        System.out.println("Name:"+name+" "+"Balance:"+balance);
    }
}

/*
a. BankAccount is a class and alice and bob are objects as in instances of the class.
b. When alice.deposit(500) is called, balance of alice changes from 500 to 1000 since 500 was deposited(added) to the balance. The program knows to update alice's balance through the dot operator which assigns values and it is also known as method invocation.
c. In memory the instances of classes called alice and bob is created and gets assigned the string "Alice" and "Bob" respectively in place of its name attribute.
d. For writing alice=bob, all the attributes of alice would get assigned to bob and after calling alice.deposit(100), only the balance of the object alice is changed and no changes occur in the object called bob since each object is a distinct entity and if it was not called for making changes, it will not change.
 */