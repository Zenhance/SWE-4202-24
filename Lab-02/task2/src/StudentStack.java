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
           System.out.println("Error: Student list is full!");
           return;
       }
       students[count] = new Student(name, mark);
       count++;
       System.out.println("Added " + name + ", " + mark);
    }

    public void display() {
       if(count==0) {
           System.out.println("Error: Student list is empty!");
           return;
       }

       for(int i=0;i<count;i++) {
           System.out.println("Student " + (i+1) + ": " +
                   students[i].name + ", " + students[i].mark);
       }
    }

    public void peek() {
        if(count==0) {
            System.out.println("Error: Student list is empty!");
            return;
        }

       System.out.println("Peeked Student " + (count) + ": " +
               students[count-1].name + ", " + students[count-1].mark);
    }

    public void pop() {
        if(count==0) {
            System.out.println("Error: Student list is empty!");
            return;
        }
        System.out.println("Removed Student " + count + ": " +
                students[count-1].name + ", " + students[count-1].mark);
        count--;
        // since I dont need to zero out the removed slot
        // students[count].name = null;
        // students[count].mark = 0;
    }
}