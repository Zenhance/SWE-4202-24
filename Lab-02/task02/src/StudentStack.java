/*
    a. push and pop never shift any elements. What does this mean for speed when the
    stack has 50 students versus 5 students?
    Ans: Say for say to completely empty or to completely fillup an empty stack we woud need to
    go through every element, increasing its runtime. As this is linear, the speed of 50 students
    with respect to 5 students would be much slower.

    b. Your StudentStack and StudentQueue both have a private field called count (or similar).
    If someone writes code that uses both classes at the same time, can one
    object’s count interfere with the other’s? Why not?
    Ans: No they can't interfere at the same time. As their access modifier is private they can't be modified outside
    of the class itself. They can be given values through methods and constructors but their fields could not interfered.
*/

public class StudentStack {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void push(String name, int marks) {
        if (count + 1 > 50){
            System.out.println("Stack is full");
            return;
        }
        this.name[count] = name;
        this.marks[count] = marks;
        count++;
    }

    public void pop(){
        if (count - 1 < 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.name[count-1] + " " + this.marks[count-1]);
        count--;
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.name[count-1] + " " + this.marks[count-1]);
    }

    public void display (){
        for (int i = 0; i < count; i++){
            System.out.println(this.name[i] + " " + this.marks[i]);
        }
    }
}
