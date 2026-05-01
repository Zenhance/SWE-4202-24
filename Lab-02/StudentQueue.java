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
    public void dequeue(){
        if(count==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("dequeue: ");
        students[0].display();
        for(int i=0;i<count-1;i++){
            students[i]=students[i+1];
        }
        count--;
    }
}