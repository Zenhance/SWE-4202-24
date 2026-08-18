import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        List<Slot> vehicles = new ArrayList<>();
        while (input.hasNextLine())
        {
            String line = input.nextLine().trim();
            if (line.isEmpty())
            {
                continue;
            }
            String[] word = line.split(" ");
            switch(word[0])
            {
                case "END" ->
                {
                    break;
                }
            }
        }

    }
}