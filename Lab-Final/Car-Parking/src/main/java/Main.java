import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String line=input.nextLine();
        String[] parts=line.split(" ");
         int bike=Integer.parseInt(parts[1]);
        int regular=Integer.parseInt(parts[2]);
        int large=Integer.parseInt(parts[3]);
        ParkingSlot parkingSlot=new ParkingSlot(bike,regular,large);
        line = input.nextLine();
        parts = line.split(" ");
        int maxStay = Integer.parseInt(parts[1]);

        input.close();
    }
}