import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)
            throws Exception {

        CarPark carPark = new CarPark();

        CommandProcessor processor =
                new CommandProcessor(carPark);

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.equals("END")) {
                break;
            }
            processor.process(line);
        }
    }
}