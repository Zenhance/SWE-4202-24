/* (a) dequeue always shifts the entire array one step to the left. if the queue hold 50 students and you dequeue
       45 times. how many individual element moves does that require in total ?

       Ans. The first dequeue move 49 elements and the second one moves 48 and so on.
            Mathematically,  It follows the pattern if n*(n-1)/2.

   (b) You have now written three classes- StudentList,StudentStack and StudentQueue all using the same private
       array and count. The only real difference is which methods are available to outside code. In one sentence
       explain why hiding the arrays as private makes this possible ?

       Ans. Hiding the array as private allows the class to act as a "Gatekeeper" ensuring that the data can only be
            changed through specific rules without outside code accidentally breaking the structure.
 */
public class StudentQueue {

    String[] Names=new String[100];
    double[] marks=new double[100];
    int count=0;

    void enqueue(String Names, double marks){

        this.Names[count]=Names;
        this.marks[count]=marks;
        count++;
    }

    void dequeue(){
        if(count==0){
            System.out.println("The queue is empty.");
        }else{
            System.out.println(this.Names[0]+ " "+this.marks[0]);

            for(int i=0;i<count-1;i++){
                this.Names[i]=this.Names[i+1];
                this.marks[i]=marks[i+1];
            }
            count--;
        }
    }

    void front(){
        System.out.println("Front Student: "+this.Names[0]);
    }

    void display(){

        for(int i=0;i<count;i++){
            System.out.println(this.Names[i]+": "+this.marks[i]);
        }
    }

}
