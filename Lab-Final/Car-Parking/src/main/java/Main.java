import java.util.Scanner;

public class Main {
    public static void main(String[] args){
                Scanner input = new Scanner(System.in);
                Parkinglot lot = new Parkinglot();
    }
    while(input.hasNextLine()){
        String line = input.nextLine().trim();
        if (line.isEmpty()) {
            continue;
        }
        String[] field = line.split(" ");
        String command = field[0];
    }
}