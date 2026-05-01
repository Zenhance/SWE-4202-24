public class StudentQueue{
    private Student[] students=new Student[50];
    private int count=0;
    public void enqueue(String name,int mark){
        if(count==students.length){
            System.out.println("Queue is full");
            return;
        }
        students[count]=new Student(name,mark);
        count++;
    }
}