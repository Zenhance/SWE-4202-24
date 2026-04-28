import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many customer are there: ");
        int customer = sc.nextInt();

        for(int i =0; i<customer; i++){
            sc.nextLine();
            System.out.println("Enter you name: ");
            String name = sc.nextLine();
            BankAccount acc = new BankAccount(name);

            System.out.println("Enter deposit amount: ");
            double Dep_AM = sc.nextDouble();
            acc.deposit(Dep_AM);
            acc.printStatement();
            System.out.println();
            System.out.println("Enter withdrawal amount: ");
            double With_AM = sc.nextDouble();
            acc.withdraw(With_AM);
            acc.printStatement();
        }

    }
}