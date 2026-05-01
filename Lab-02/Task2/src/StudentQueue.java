public class StudentQueue {
    private String[] name = new String[50];
    private int[] mark = new int[50];
    private int count = 0;

    public void enqueue(String name,int mark){
             this.name[count]=name;
             this.mark[count]=mark;
             count++;
             if (count+1>50){
                 System.out.println("Queue is full");
                 return;
             }
    }
    public void dequeue(){
          for (int i=0;i<count-1;i++){
              this.name[i]=this.name[i-1];
              this.mark[i]=this.mark[i-1];
              count--;
          }
          if (count-1<0){
              System.out.println("Queue is empty");
          }
    }
    public void front(){
        System.out.println(this.name[0]+" "+this.mark[0]);
    }
    public void display(){
        for (int i=0;i<count;i++){
            System.out.println(this.name[i]+" "+this.mark[i]);
        }
    }
}