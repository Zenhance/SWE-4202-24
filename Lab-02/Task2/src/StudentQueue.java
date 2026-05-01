public class StudentQueue {
    private String[] name=new String[50];
    private int[] mark=new int[50];
    private int count;
    StudentQueue(String name[],int mark[]){
       this.name=name;
       this.mark=mark;
       this.count=0;
    }
    public void enqueue(String name,int mark){
        if(count>=100){
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
