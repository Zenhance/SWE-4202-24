/*
a. If the queue holds 50 students and I dequeue 45 times then at first it will move 49 spaces
   then 48 and 47 ...lastly 5 times so the total movement will be sum of
   1->49 -(1+2+3+4)=49x50/2-10=1215 times

b. Using private in array and cnt,others can't access it's data.

 */




public class StudentQueue {

    private String[] name=new String[50];
    private int[] marks=new int[50];
    private int cnt=0;

    public void enqueue(String name, int marks) {
        if (cnt>50){
            System.out.println("Queue is full");
            return;
        }
        this.name[cnt] = name;
        this.marks[cnt] = marks;
        cnt++;
    }

    public void dequeue(){
        if(cnt==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued: "+name[0]+" "+marks[0]);
        for(int i=0;i<cnt-1;i++){
            name[i]=name[i+1];
            marks[i]=marks[i+1];
        }
        cnt--;

    }

    public void front(){
        if(cnt==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Name: "+name[0]+"\nMarks: "+marks[0]);
    }

    public void display(){
        if(cnt==0){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=0;i<cnt;i++){
            System.out.println(+i+". "+name[i]+" "+marks[i]);
        }
    }


}
