public class StudentStack {
     String[] name;
     int[] marks;
     int count;
    final int MAX_SIZE=100;
   StudentStack(String[] name,int[] marks){
       this.name=name;
       this.marks=marks;
       this.count=0;
   }
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
           System.out.println("Remove: "+name[count-1]);
           System.out.println("Marks:"+marks[count-1]);
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

}