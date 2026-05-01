/*
(a)
Ans:
Each dequeue shifts all remaining elements one step to the left.
So first time: 49 moves
Second time: 48 moves
Then 47, 46, and so on...

So the total number of moves is:
49 + 48 + 47 + ... + 5

This follows the formula n(n - 1) / 2, so a lot of movements happen compared to stack.

(b)
Ans:
Making the array private means outside code cannot directly change it.
All changes must go through methods like push, pop, enqueue, or dequeue.
This allows each class (Stack, Queue, List) to control how the data is used and keeps everything safe.
*/


public class StudentQueue {
    private String[] names;
    private double[] marks;
    private int count;
    private int capacity;

    public StudentQueue(int capacity) {
        this.capacity = capacity;
        names = new String[capacity];
        marks = new double[capacity];
        count = 0;
    }
    public void enqueue(String name, double mark){
        if (count == capacity) {
            System.out.println("Memory is full");
            return;
        }
        else {
            names[count] = name;
            marks[count] = mark;
            count++;
        }
    }
    public void deQueue(){
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Removed: " + names[0] + " - " + marks[0]);

        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        count--;
    }
    public void front(){
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front: " + names[0] + " - " + marks[0]);
    }
    public void display(){
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("All data:");
        for(int i =0; i<count; i++){
            System.out.printf("%-10s ---> %6.2f\n", names[i], marks[i]);
        }
    }
}
