import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

Scanner input=new Scanner(System.in);
CarPark park=null;

while(input.hasNextLine()){
    String line= input.nextLine().trim();

    if(line.isEmpty()){
        continue;
    }

    String[] field=line.split(" ");
    String command=field[0];

    if(command.equals("END")){
        break;
    }
try{
    if(command.equals("SLOTS")){
        int bikeSlots=Integer.parseInt(field[1]);
        int regularSlots=Integer.parseInt(field[2]);
        int largerSlots=Integer.parseInt(field[3]);

    }
    else if(command.equals("MAXSTAY")){
        int hours=Integer.parseInt(field[1]);
        park.setMaxStay(hours);
    }
}
    }
}