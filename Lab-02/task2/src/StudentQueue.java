/*a)
Each dequeue shifts all remaining elements one step to the left.In the scenario of 50 students
the first step moves 49,second moves 48 and it goes on like that.
If the queue holds 50 students and I dequeue 45 times, roughly 49+48+47.....+5=1210 individual element
moves required in.
b)
By hiding the array as private,outside code can only interact with data through the methode we choose to expose.
So the exact same array and count fields can power completely different behaviours by changing which public methods are provided,
without any risk of outside code accidentally bypassing the rules.
 */


public class StudentQueue {
    String[] name=new String[100];
    int[] marks =new int[100];
    int count=0;
    public void enqueue(String name,int marks){
        if(count == 100){
            System.out.println("Error!");
            return;
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }
    public void dequeue(){
        if(count == 0){
            System.out.println("Empty");
            return;
        }
        else{
            count--;
            System.out.println("Remove: "+name[0]);
            System.out.println("Marks:"+marks[0]);
            for(int i=0;i<count;i++){
                this.name[i]=name[i+1];
                this.marks[i]=marks[i+1];
            }

        }
    }
    public void front(){
        if(count==0){
            System.out.println("Empty");
            return;
        }
        System.out.println("Front Name:"+this.name[0]);
        System.out.println("Front Mark:"+this.marks[0]);
    }
    public void display(){
        if(count == 0){
            System.out.println("Empty");
            return;}
        for(int i=0;i<count;i++){

            System.out.println("Name: "+this.name[i]);
            System.out.println("Marks:"+this.marks[i]);
        }
    }

}
