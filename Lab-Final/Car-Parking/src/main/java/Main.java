import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ParkingLot lot = null;
        While(input.hasNextLine()){
            String Line = input.nextLine().trim();
            if(line.isEmpty()){
                continue;
            }
            String[] field = line.split(" ");
            if(field[0].equals("END")){
                break;
            }
            else if(field[0].equals("MAXSTAY")){
                int hours = Integer.parseInt(field[1]);

            }
            else if(field[0].equals("COUNT")){
                System.out.println("   ");
            }
        }
    }
}