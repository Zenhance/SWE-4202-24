// sir has asked to take two parameters of student name and marks in the push method,but i created a separate class for it


public class StudentStack{
    private Student[] list;
    private int  maximum_capacity;
    private int count;

    public StudentStack(int maximum_capacity){
        this.maximum_capacity=maximum_capacity;
        list= new Student[maximum_capacity];
        count=-1;
    }

    public void push(Student s){
        if(count==maximum_capacity-1){
            System.out.println("ERROR!");
        }
        count++;
        list[count]=s;
    }

    public Student pop(){
        if(count==-1){
            System.out.println("ERROR");
            return null;
        }
        Student temp=list[count];
        count--;
        return temp;
    }



    public Student peek(){
        if(count==-1){
            System.out.println("ERROR");
            return null;
        }
        return list[count];
    }


    public void display(){
       if(count==-1){
           System.out.println("ERROR");
           return ;
       }
       for(int i=0; i<=count; i++){
           System.out.println(list[i].name+ "  "+list[i].mark);
       }

    }

}

// this is the corrected version