/*a. push and pop never shift any elements. What does this mean for speed when the
stack has 50 students versus 5 students?

--Ans-- As push and pop never shifts elements,
the speed of these operations will be constant (O(1))
regardless of the number of students in the stack. 
Whether there are 50 students or 5 students,
the time taken to push or pop an element will be the same as the top element is only accessed.


b. Your StudentStack and StudentQueue both have a private field called count (or
similar). If someone writes code that uses both classes at the same time, can one
object’s count interfere with the other’s? Why not?


--Ans-- No, one object's count cannot interfere with the other's because
each instance of the StudentStack and StudentQueue 
classes will have its own separate count variable.
When you create an object of either class, 
it will have its own count variable that is independent

 */
public class StudentStack {

    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int cnt = 0;

    // Adding Push
    public void push(String name, int marks) {
        if (cnt + 1 > 50) {
            System.out.println("Full Stack");
        }
        this.name[cnt] = name;
        this.marks[cnt] = marks;
        cnt++;
    }

    // Adding Pop
    public void pop() {
        if (cnt - 1 < 0) {
            System.out.println("Empty Stack");
        }
        System.out.println(this.name[cnt - 1] + " " + this.marks[cnt - 1]);
        cnt--;
    }

    // Adding peek
    public void peek() {
        if (cnt == 0) {
            System.out.println("Empty Stack");
        }
        System.out.println(this.name[cnt - 1] + " " + this.marks[cnt - 1]);
    }
}
