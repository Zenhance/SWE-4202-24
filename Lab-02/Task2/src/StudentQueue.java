public class StudentQueue {
    private String[] name=new String[50];
    private double[] mark=new double[50];
    private int count=0;

    public void enqueue(String name,double mark){
        if(count>=50){
            System.out.println("the queue is full!");
            return;
        }
        else{
            this.name[count]=name;
            this.mark[count]=mark;
            count++;
        }
    }
    public void dequeue(){
        if(count==0){
            System.out.println("the queue is empty!");
            return;
        }
        else{
            System.out.println("Remove:"+"Name:"+this.name[0]+" Mark:"+this.mark[0]);

            for(int i=0;i<count-1;i++){
                this.name[i]=this.name[i+1];
                this.mark[i]=this.mark[i+1];

            }
            count--;
        }
    }
    public void front(){
        System.out.println("Student at the front: Name:"+this.name[0]+"Roll:"+this.mark[0]);

    }

    public void display(){
        for(int i=0;i<count;i++){
            System.out.println(i+"."+"Name:"+this.name[i]+"Mark:"+this.mark[i]);

        }
    }
}
/*
part c
a)It will take about 1,215 individual moves in total. This is because every
dequeue forces all remaining students in the line to shift one step forward.
 b)Making the array private ensures that the data is hidden and protected from the outside.
 This forces the code to follow the specific rules of a Queue or Stack.
 */