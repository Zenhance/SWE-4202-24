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
    public static Vehicle makeVehicle(String type, String plate, String d){
        Discount discount = makeDiscount(d);
        if(type.equals("BIKE")){
            return new Bike(plate,discount);
        }
        else if(type.equals("CAR")){
            return new Car(plate,discount);
        }
        else{
            return new Truck(plate,discount);
        }
    }
    public static void main(String[] args){

    }
}