public class StudentStack {
    private String[] name=new String[50];
    private int[] mark=new int[50];
    private int count;

    StudentStack (String name[],int mark[]){
        this.name=name;
        this.mark=mark;
        this.count =0;
    }
    public void push(String name,int mark){
        if(count>=50){
            System.out.println("The stack is full");
            return;

        }
        else{
           this.name[count]=name;
            this.mark[count]=mark;
            count ++;
        }
    }
    public void pop(){
        if(count ==0){
            System.out.println("The stack is empty!");
            return;
        }
        else{
            System.out.println("Removed:"+this.name[count-1]+","+this.mark[count-1]);
            count --;
        }
    }
    public void peek(){
        if(count==0){
            System.out.println("the stack is empty!");
            return;
        }
        else{
            System.out.println("Top:"+this.name[count-1]+","+this.mark[count-1]);
        }

    }
    public void display(){
        for(int i=0;i<count;i++){
            System.out.println(i+"."+"Name:"+this.name[i]+" "+"Mark:"+this.mark[i]);
        }
    }


}
