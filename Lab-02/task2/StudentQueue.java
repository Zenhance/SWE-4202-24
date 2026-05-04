/*
    a.The first dequeue move 49 elements and the second one moves 48 and so on.

    b. As the array and  count is private, outside code cannot access its data. So each class can
    behave differently without
    interfering each other.
 */

public class StudentQueue {

    private String[] name =new String[50];
    private int[] marks=new int[50];
    private int count=0;




    void enqueue(String name, int marks){
        if(count>=50) {
            System.out.println("Queue is full");
            return;
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }

    void dequeue(){
        if(count==0){
            System.out.println("The queue is empty.");
            return;
        }
        System.out.println(this.name[0]+ " "+this.marks[0]);

        for(int i=0;i<count-1;i++){
            this.name[i]=this.name[i+1];
            this.marks[i]=marks[i+1];
        }
        count--;
    }

    void front(){
        System.out.println("Front Student: "+this.name[0]);
    }

    void display(){
        System.out.println("Front to back:");
        for(int i=0;i<count;i++){
            System.out.println(this.name[i]+": "+this.marks[i]);
        }
    }


    public static void main(String[] args) {
        StudentQueue queue=new StudentQueue();
        queue.enqueue("Sadeed",82);
        queue.enqueue("Anwar",78);
        queue.enqueue("Saad",87);
        queue.enqueue("Fahim",88);
        queue.enqueue("Wasi",91);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();

    }
}
