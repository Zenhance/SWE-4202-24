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

}
