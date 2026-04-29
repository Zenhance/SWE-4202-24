public class StudentStack{
    String[] names;
    double[] marks;
    int count=0;

    StudentStack(String[] names,double[] marks){
        this.names=names;
        this.marks=marks;
    }
    public void push(String names,double marks){
        if(count==500){
            System.out.println("Stack is full");
            return;
        }
        names[count]=names;
        marks[count]=count;
        count++;
    }
    public void pop(){
       if(count==0){
           System.out.println("Stack is empty");
           return;
       }
       count--;
        System.out.println("Name:"+names[count]+" Marks:"+marks[count]);
    }
}