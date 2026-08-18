import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line=input.nextLine().trim();
            if(line.isEmpty())
                continue;

            String[] data = line.split(" ");

            if(data[0].equals("BIKE")) {
                Bike bike = new Bike(data[1],getDiscount(data[2]));
                System.out.println(bike.getPlate());
            }

            else if(data[0].equals("CAR")) {
                Car car = new Car(data[1],getDiscount(data[2]));
                System.out.println(car.getPlate());
            }

            else if(data[0].equals("TRUCK")) {
                Truck truck = new Truck(data[1],getDiscount(data[2]));
                System.out.println(truck.getPlate());
            }
            else if(data[0].equals("END")) {
                break;
            }
        }
    }
    public static DiscountScheme getDiscount(String name) {
        if(name.equals("STUDENT")) {
            return new StudentDiscount();
        }
        else if(name.equals("WEEKEND")) {
            return new WeekendDiscount();
        }
        else {
            return new NoDiscount();
        }
    }

}

