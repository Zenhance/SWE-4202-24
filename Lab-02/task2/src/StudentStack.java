/*
a)Shifting elements decreasing speed. The more elements the more operations and more times takes. in 50 students array it will take 10 times more time than 5 stduents array.
but, as push and pop don't shift studets, it will not matter, if there is 5 or 50 students.

b)NO.the private fields in different class. and each object will get separate memeory
* */



public class StudentStack {
    private String[] name = new String[100];
    private int[] marks = new int[100];
    private int count = 0;
    public void push(String name, int marks){
        if(count==100){
            System.out.println("Stack is full");
            return;
            }
            this.name[count]=name;
            this.marks[count]=marks;
            count++;

    }
    public void pop(){
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println("Name:" +this.name[count] + " Marks: " + this.marks[count]);
    }
    public void peek(){
       System.out.println("Name: "+this.name[count-1]);
    }
    public void display(){
        for(int i=0;i<count;i++){
            System.out.println("Name:" +this.name[i] + " Marks: " + this.marks[i]);
        }
    }
}
