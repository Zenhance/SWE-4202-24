public class StudentQueue {
    String[] name=new String[100];
    int[] marks =new int[100];
    int count=0;
    public void enqueue(String name,int marks){
        if(count == 100){
            System.out.println("Error!");
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }
    public void dequeue(){
        if(count == 0){
            System.out.println("Empty");
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

}
