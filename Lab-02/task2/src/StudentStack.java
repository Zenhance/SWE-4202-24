public class StudentStack {
    private Student[] students;
    private int count;
    private final int MAX = 50;

   public StudentStack() {
       students = new Student[MAX]; // Student[] = new Student[MAX]
       count = 0;
   }

   public void push(String name, int mark) {
       if(count>=MAX) {
           System.out.println("Student list is full!");
           return;
       }
       students[count] = new Student(name, mark);
       count++;
       System.out.println("Added " + name);
   }
}