/*
a. push and pop do not shift elements,they only add at or remove from the last index,
so the time taken is constant,whether there are 5 or 50 students,the operation takes
the same amount of time.

b.No,one object's count can't interfere with another,each object has its own
separate memory and its own copy of the count variable,they work independently.

*/

public class StudentStack {

    private String[] names = new String[50];
    private int[] marks = new int[50];
    private int count=0;


public void push(String name,int mark){

        if(count >=50){

            System.out.println("The stack is full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        System.out.println("Pushed: " + name + " (" + mark + ")");
        count++;
    }


public void pop() {

    if (count == 0) {

        System.out.println("The stack is empty");
        return;
    }

    count--;
    System.out.println("Popped: " + names[count] + " (" + marks[count] + ")");
}

public void peek() {

        if (count == 0) {

            System.out.println("The stack is empty");
            return;
        }

        System.out.println("Top: " + names[count-1] + " (" + marks[count-1] + ")");
    }



public void display() {

            System.out.println("The stack:");
             for (int i = 0;i<count;i++){
                 System.out.println(i + " " + names[i] + " " + marks[i]);
             }
        }
    }
