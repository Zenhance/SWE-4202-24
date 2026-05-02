/*a)Push and pop never shift any elements,
 they just add and remove elements at the position
 pointed by count.Count is always at the end of the array.
 So both operations take constant time o(1).It doesn't matter if the stack has
 5 or 50 students. It will push and pop in the same amount of time.
 b)Each copy of StudentStack has its own separate copy of "count".If I use "count" in both
 StudentStack and StudentQueue, the "count" will not be the same. They will hold different values.
 Changing one will never affect the other.
 */

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