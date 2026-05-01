//a
   /* after each dequeue the queue shift one step to the left. so
      after 1st dequeue shift= 50-1 =49
      after 2nd dequeue shift= 50-2 =48
      after 3rd dequeue shift= 50-3 =47

      so after each dequeue shift= total - number of dequeue

      after 45th dequeue shift= 50-45 =5

      therefore total shifts= 49+48+47+...........+5=1215
    */

//b
   /* we have declared the array as private. as a result though the three classes uses the same array
      they cannot influence or change one another. no outside code can directly access it or modify it.
      for this reason each class can behave differently imposing its own rule
    */


public class StudentQueue {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count =0;

    public void enqueue(String name, int marks){
        if(count+1>50){
            System.out.println("Queue is full");
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }

    public void dequeue(){
        if(count-1<0){
            System.out.println("Queue id empty");
        }
        System.out.println("Remove:" + this.name[0] + " " + this.marks[0] + "\n" );
        for(int i=0;i<count-1;i++){
            this.name[i]=this.name[i+1];
            this.marks[i]=this.marks[i+1];
        }
        count--;
    }

    public void front(){
        System.out.println(this.name[0] + ":" + this.marks[0] + "\n");
    }

    public void display(){
        for(int i=0;i<count;i++){
            System.out.println(this.name[i] + ":" + this.marks[i] + "\n");
        }
    }
}
