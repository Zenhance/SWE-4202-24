public class Bankaccount {
    private String name;
    private double bal ;
    public Bankaccount(String name){
        this.name = name;
        this.bal = 0.0;
    }

public void deposit(double ball){
        if(ball<=0){
            System.out.println("Error!");
            return;
        }
        bal+=ball;
}
public void withdraw(double ba){
        bal-=ba;
        if(bal<0){
            System.out.println("Insufficient balance");
        }
}
public void printdetails(){
        System.out.println(name+ ":" + bal);
}
}
