import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args){

     Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("MAXSTAY")) {
                int hours = parseInt(field[1]);
                // ... do something with hours ...
            } else if (field[0].equals("COUNT")) {
                System.out.println(/* the number you worked out */);
            } else if (field[0].equals("LEAVE")){

            // ... one branch per keyword ...
        }
        else if (field[0].equals("BILLS")) {}
        else if (field[0].equals("SLOT")){
}
        else if (field[0].equals("EARNED")){}
        else if (field[0].equals("FREE")){
     if(field[1].equals("BIKE"))System.out.println(slot.bike);
            }
}       else if (field[0].equals("PASSTIME")){
            int hours = Integer.parseInt(field[1]);
            time = hours;
            }
}
        else if (field[0].equals("SLOTS")){}
        else if (field[0].equals("BIKE"))