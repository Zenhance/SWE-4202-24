public class StudentStack {
    private String[] names = new String[50];
    private int[] marks = new marks[50];
    private int count=0;

    public void push(String names, int marks){
        if(count+1>50){
            System.out.println("Stack is Full");
        }
        this.names[count]=names;
        this.marks[count]=marks;
        count++;
    }

    public void pop(){
        if(count-1<0){
            System.out.println("Stack is empty");
        }
        System.out.println("Remove:" + this.names[count-1] + " " + this.marks[count-1] + "\n");
        count--;
    }

    public void peek(){
        if(count-1<0){
            System.out.println("Stack is empty");
        }
        System.out.println("Top:" + this.names[count-1] + " " + this.marks[count-1] + "\n");
    }

    public void display(){
        for(int i=0;i<5;i++){
            System.out.println(this.names[i] + ":" + this.marks[i]);
        }
    }
}

