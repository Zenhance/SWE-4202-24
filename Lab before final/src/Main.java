import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<String> names = new ArrayList<>();

        String csvFile = "src/resources/Students.CSV";
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip header row (ID, Name, CGPA)

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip blank lines
                }

                String[] data = line.split(delimiter);

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double cgpa = Double.parseDouble(data[2].trim());

                Student student = new Student(name, id, cgpa);
                students.add(student);
                names.add(name);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print results
        System.out.println("=== Students List ===");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\n=== Names List ===");
        System.out.println(names);

        System.out.println("\nTotal students loaded: " + students.size());
    }
}