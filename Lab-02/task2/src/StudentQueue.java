public class StudentQueue {
    private Student[] students;
    private int count;
    private final int MAX = 50;

    public StudentQueue() {
        students = new Student[MAX]; // Student[] = new Student[MAX]
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if(count>=MAX) {
            System.out.println("Error: Student list is full!");
            return;
        }
        students[count] = new Student(name, mark);
        count++;
        System.out.println("Added " + name + ", " + mark);
    }
}
