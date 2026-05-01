/*
 QUESTIONS:-
a. push and pop never shift any elements. What does this mean for speed when the
stack has 50 students versus 5 students?

b. Your StudentStack and StudentQueue both have a private field called count (or
similar). If someone writes code that uses both classes at the same time, can one
object’s count interfere with the other’s? Why not?


 ANSWERS:-
 a. Number of student doesn't matter as both of the operations only works on a particular index of the arrays. So there is nothing to do with speed, it will always be the same.

 b. Each object get its own private count variable assigned when it's called. So, one object's count can't interfere with other's.
*/
public class StudentStack {
    private int count = 0;
    private String[] names = new String[10];
    private int[] marks = new int[10];

    public void push(String name, int obtained_mark){
        if(count == 10){
            System.out.println("Error. No space left. Can't push " + name + ".");
            return;
        }
        names[count] = name;
        marks[count] = obtained_mark;
        count++;
    }

    public void pop(){
        if(count == 1){
            System.out.println("Error. No element to pop.");
            return;
        }
        System.out.println(names[count-1] + " with mark " + marks[count-1] + " popped successfully.");
        count--;
    }

    public void peek(){
        if(count == 0){
            System.out.println("Error. No element to peek.");
            return;
        }
        System.out.println("Student " + names[count - 1] + " with mark " + marks[count - 1] + " is at top.");
    }


}

