import java.util.Scanner;

/*
  PART B: The Counter class
 This class demonstrates basic encapsulation of a single integer value.
 */
class Counter {
    private int value;

    // 1. The constructor is called when a new Counter object is created.
    // 2. It sets the initial value of the counter to zero.
    // 3. This ensures that every new instance starts from a clean state.
    // 4. The field is private so it cannot be modified directly from outside.
    // 5. This protects the integrity of the counting logic within the class.
    // 6. Users must interact with the counter through its public methods only.
    // 7. This is a fundamental example of how classes hide internal data.
    public Counter() {
        this.value = 0; [cite: 211]
    }

    public void increment() { this.value++; } [cite: 212]
    public void reset() { this.value = 0; } [cite: 213]
    public int get() { return this.value; } [cite: 214]
}

/*
 PART A: The StudentList class
 Manages student records using private arrays and public methods.
 */
public class StudentList {
    private String[] names; [cite: 201]
    private int[] marks; [cite: 201]
    private int count; [cite: 201]
    private final int MAX = 50; [cite: 12, 208]

    // 1. The constructor initializes the fixed-size arrays for names and marks.
    // 2. It allocates memory for exactly fifty entries as per the requirements.
    // 3. The integer count is set to zero to indicate an empty list.
    // 4. This setup happens automatically when the roster object is instantiated.
    // 5. No parameters are needed because the size is defined by a constant.
    // 6. It prepares the internal storage before any data is actually added.
    // 7. This is the starting point for managing the student record system.
    public StudentList() {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0; [cite: 203]
    }

    // 1. The add method inserts a new student into the private arrays.
    // 2. It first checks if the current count has reached the maximum limit.
    // 3. If the list is full, it prints a specific error message. [cite: 17]
    // 4. Otherwise, it stores the name in the next available array slot.
    // 5. The student's mark is also saved at the corresponding index position.
    // 6. After saving the data, the count variable is incremented by one.
    // 7. This ensures the system tracks how many students are currently stored.
    public void add(String name, int mark) {
        if (count >= MAX) {
            System.out.println("Error: The list is full."); [cite: 17]
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    // 1. The display method prints the status of every stored student record.
    // 2. It uses a simple loop to iterate through the active entries.
    // 3. For each student, it accesses the name and mark arrays simultaneously.
    // 4. It prints the numerical position of the student starting from zero. [cite: 21]
    // 5. The output format is kept clear and easy for users to read.
    // 6. It only loops up to the current count to avoid empty slots.
    // 7. This provides a complete overview of all students in the system.
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println("Pos: " + i + " | Name: " + names[i] + " | Mark: " + marks[i]); [cite: 21]
        }
    }

    // 1. The removeAt method deletes a student at a specific index location. [cite: 19]
    // 2. It validates that the provided index is within the valid range.
    // 3. A loop starts at the target position to begin the shifting process.
    // 4. Every subsequent entry is moved one position to the left. [cite: 19]
    // 5. This effectively overwrites the student that was intended for removal.
    // 6. The internal count is decreased by one after the shift finishes.
    // 7. This maintains a continuous list without leaving any empty gaps inside.
    public void removeAt(int index) {
        if (index < 0 || index >= count) return;
        for (int i = index; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }

    // 1. The update method changes the mark for an existing student record. [cite: 21]
    // 2. It receives the index of the student and the new grade.
    // 3. First, it verifies that the index corresponds to an actual student.
    // 4. If the index is valid, it targets the specific mark array.
    // 5. The old value is replaced with the new integer provided by user.
    // 6. This operation does not affect the student's name or list position.
    // 7. It allows for quick corrections to student performance data over time.
    public void update(int index, int newMark) {
        if (index >= 0 && index < count) {
            marks[index] = newMark;
        }
    }

    // 1. The search method looks for a student name matching a query. [cite: 22]
    // 2. It scans the entire list of names from the first entry.
    // 3. Each name is compared to the search string regardless of case.
    // 4. If a match is found, it prints the student's information immediately. [cite: 22]
    // 5. The method returns the index of the first matching student found.
    // 6. If no student matches the query, it reports that to the console. [cite: 23]
    // 7. It returns negative one if the search fails to find anything.
    public int search(String query) {
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(query)) {
                System.out.println("Found: " + names[i] + " with mark " + marks[i]);
                return i;
            }
        }
        System.out.println("Not found."); [cite: 23]
        return -1;
    }

    // 1. The topN method identifies the highest-performing students in the list. [cite: 24]
    // 2. It creates temporary copies of the name and mark arrays first.
    // 3. This ensures that the original order of the list remains unchanged. [cite: 24]
    // 4. A sorting algorithm organizes the copied data in descending order.
    // 5. It compares the marks and swaps names along with the grades.
    // 6. After sorting, it prints only the top number of students requested. [cite: 24]
    // 7. This is useful for identifying the best students in the class.
    public void topN(int n) {
        if (n > count) n = count;
        String[] tempNames = new String[count];
        int[] tempMarks = new int[count];
        for (int i = 0; i < count; i++) {
            tempNames[i] = names[i];
            tempMarks[i] = marks[i];
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (tempMarks[j] < tempMarks[j + 1]) {
                    int m = tempMarks[j]; tempMarks[j] = tempMarks[j+1]; tempMarks[j+1] = m;
                    String s = tempNames[j]; tempNames[j] = tempNames[j+1]; tempNames[j+1] = s;
                }
            }
        }
        System.out.println("Top " + n + " Students:");
        for (int i = 0; i < n; i++) {
            System.out.println(tempNames[i] + " : " + tempMarks[i]);
        }
    }

    public static void main(String[] args) {
        StudentList roster = new StudentList();
        roster.add("Sathiya", 95);
        roster.add("Alice", 88);
        roster.add("Bob", 70);
        roster.display();
        
        System.out.println("\n--- Testing Counter ---");
        Counter c = new Counter();
        c.increment();
        System.out.println("Counter: " + c.get());
    }
}