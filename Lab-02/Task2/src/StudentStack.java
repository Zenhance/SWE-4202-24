public class StudentStack {
    private String[] name = new String[50];
    private int[] mark = new int[50];
    private int count=0;

    public void push(String name,int mark){
        if (count+1>50){
            System.out.println("Stack is full");
            return;
        }
        this.name[count]=name;
        this.mark[count]=mark;
        count++;
    }
   public void pop(){
        if (count-1<0){
            System.out.println("Stack is empty");
            return;

        }
       System.out.println(this.name[count-1]+" "+this.mark[count-1]);
        count--;


   }
   public void peek(){
       System.out.println(this.name[count-1]+" "+this.mark[count-1]);
   }
   public void display(){
        for (int i=0;i<count;i++){
           System.out.println(this.name[i]+" "+this.mark[i]);
       }
   }
}
/*
A.The speed will remain same.

B.No, one object's count cannot interfere with another because each object has
    its own separate memory, so their data is independent.
 */