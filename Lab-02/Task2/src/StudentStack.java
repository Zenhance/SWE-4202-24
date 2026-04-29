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
        if (count==0){
            System.out.println("Stack is empty");

        }
       System.out.println(this.name[count-1]+" "+this.mark[count-1]);


   }
}
