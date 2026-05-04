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

    public void dequeue(){
        if(count ==0){
            System.out.println("empty queue");
            return;
        }
        System.out.println("Dequeued: " + this.name[0] + " " + this.marks[0]);
        for(int i=1; i<count; i++){
            this.name[i-1]= this.name[i];
            this.marks[i-1]=this.marks[i];
        }
        count--;
    }

    public void front(){
        if(count==0){
            System.out.println("empty queue");
            return;
        }
        System.out.println("Front: " + this.name[0] + " " + this.marks[0]);

    }
}
