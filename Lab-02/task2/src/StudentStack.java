public class StudentStack {
     String[] name=new String[100];
     int[] marks =new int[100];
     int count=0;
    final int MAX_SIZE=100;

   public void push(String name,int marks){
       if(count == 100){
           System.out.println("Error!");
       }
       this.name[count]=name;
       this.marks[count]=marks;
       count++;
   }
   public void pop(){
       if(count == 0){
           System.out.println("Empty");
       }
       else{
           count--;
           System.out.println("Remove: "+name[count]);
           System.out.println("Marks:"+marks[count]);
       }
   }
    public void peek(){
        if(count == 0){
            System.out.println("Empty");
        }
        else{
            count--;
            System.out.println("Top Name: "+this.name[count-1]);
            System.out.println("Marks:"+this.marks[count-1]);
        }
    }
    public void display(){
       for(int i=0;i<count;i++){
           System.out.println("Name: "+this.name[i]);
           System.out.println("Marks:"+this.marks[i]);
       }
    }

}