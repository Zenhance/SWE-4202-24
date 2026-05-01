/*
a. push and pop never shift any elements. What does this mean for speed when the
stack has 50 students versus 5 students?
ans:whether there are 5 or 50 students, the speed stays the same.

b. Your StudentStack and StudentQueue both have a private field called count (or
similar). If someone writes code that uses both classes at the same time, can one
object’s count interfere with the other’s? Why not?
ans:  No, one object's count cannot interfere with another because each object has
    its own separate memory, so their data is independent.

 */

public class StudentStack {
    String[] names;
    int[] marks;
    int count;

    StudentStack(String[] name, int[] mark) {
        this.names = name;
        this.marks = mark;
        this.count = 0;
    }

    public void push(String name, int mark) {
        if (count == 100) {
            System.out.println("ERROR:STACK IS FULL");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;

    }
    public void pop(){
        if(count==0){
            System.out.println("ERROR:STACK IS EMPTY");
            return;
        }
        System.out.println(names[count-1]+" "+marks[count-1]);
        count--;
    }
    public void peek(){
        System.out.println(names[count-1]+" "+marks[count-1]);
    }
    public void display(){
        for(int i=0;i<count;i++){
            System.out.println(names[i]+" "+marks[i]);
        }
    }

}

