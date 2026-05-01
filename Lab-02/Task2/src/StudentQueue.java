public class StudentQueue {
    private String[] name = new String[50];
    private int[] mark = new int[50];
    private int count = 0;

    public void enqueue(String name,int mark){
             this.name[count]=name;
             this.mark[count]=mark;
             count++;
             if (count<=50){
                 System.out.println("Queue is full");
             }
    }
    public void dequeue(){
          for (int i=0;i<count-1;i++){
              this.name[i]=this.name[i-1];
          }
    }
}