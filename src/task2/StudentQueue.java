package task2;

public class StudentQueue {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count =0;

    public void enqueue(String name, int marks){
        if(count ==50){
            System.out.println("queue is full");
            return;
        }
        this.name[count] =name;
        this.marks[count]=marks;
        count++;
    }

    public void dequeue()
}
