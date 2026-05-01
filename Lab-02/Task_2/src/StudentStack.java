/*(a) Push and Pop never shifts any element. What does this mean for speed when the stack has 50 student versus 5 student?
    Ans. push and pop only interacts with the very end of the array. The speed remains exactly the same whether you
         have 50 students or 5.
  (b) Your StudentStack and StudentQueue both have a private field called count. if someone writes code that uses both
      classes at the same time. can one's object count interfere with the other's ? Why not?

      Ans. No. One's object count cannot interfere with Another's. because count is a private field within the class.
            Meaning each individual object gets it's own seperate memory.


 */
public class StudentStack {

        String[] Names= new String[100];
        double[] marks= new double[100];
        int count=0;

        void push(String Names,double marks){
                this.Names[count]=Names;
                this.marks[count]=marks;
                count++;
        }

        void pop(){
            if(count==0){
                System.out.println("Stack is empty");
            }else{
                System.out.println(this.Names[count]+ " " +this.marks[count]);
            }
        }

        void peek(){
            if(count==0){
                System.out.println("Stack is empty");
            }else{
                System.out.println("Top Student: "+this.Names[count-1]);
            }
        }

        void display(){
            for(int i=0;i<count;i++){
                System.out.println(this.Names[i]+": "+this.marks[i]);
            }
        }
}
