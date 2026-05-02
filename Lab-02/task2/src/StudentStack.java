public class StudentStack {
     String[] name;
     int[] marks;
     int count;
    final int MAX_SIZE=100;
   StudentStack(String[] name,int[] marks){
       this.name=name;
       this.marks=marks;
       this.count=0;
   }
}