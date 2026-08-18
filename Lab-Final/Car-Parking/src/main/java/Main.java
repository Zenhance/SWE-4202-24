import java.util.Scanner;

public class Main {
    public static Discount makeDiscount(String x){
        if(x.equals("STUDENT")){
            return new StudentDiscount();
        }
        else if(x.equals("WEEKEND")){
            return new WeekendDiscount();
        }
        else{
            return new NoDiscount();
        }
    }
    public static void main(String[] args){

    }
}