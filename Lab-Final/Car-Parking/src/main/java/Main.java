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

    String[] field=line.split("\\s+");
    String command=field[0];

    if(command.equals("END")){
        break;
    }
    try{
        if(command.equals("SLOTS")){

            int bike=Integer.parseInt()
        }
    }
}

    }
}