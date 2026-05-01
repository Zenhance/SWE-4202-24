/*
(a)
Ans:
Push and pop always work at the top (end) of the stack. They don’t move any other elements.
So the time it takes is the same whether there are 5 students or 50 students. The size doesn’t affect the speed.

(b)
Ans:
No, it cannot. Each object has its own separate count variable.
Because count is private, it belongs only to that specific object.
So if we create two stacks, their counts are completely independent.
*/

public class StudentStack {
    private String[] name;
    private double[] marks;
    private int count;
    private int capacity;


    public StudentStack(int capacity){
        this.capacity = capacity;
        name = new String[capacity];
        marks = new double[capacity];
        count = 0;
    }
    public void  push(String name, double marks){
        if(count == capacity){
            System.out.println("Memory full");
            return;
        }
        else{
            this.name[count] = name;
            this.marks[count] = marks;
            count++;
        }


    }
    public void pop(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else {
            count--;
            System.out.println("Removed: " + name[count] + " - " + marks[count]);

        }

    }
    public void peek(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else {
            System.out.println("Top: " + name[count - 1] + " - " + marks[count - 1]);
        }
    }
    public void display(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else{
            System.out.println("All data:");
            for(int i =0; i<count; i++){
                System.out.printf("%-10s ---> %6.2f\n", name[i], marks[i]);
            }
        }
    }
}
