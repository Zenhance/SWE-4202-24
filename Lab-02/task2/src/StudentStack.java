public class StudentStack {
        private String[] name=new String[50];
        private int[] marks=new int[50];
        private int cnt=0;

        public void push(String name,int marks){

            if(cnt>50) {
                System.out.println("Stack is full");
                return;
            }
            this.name[cnt]=name;
            this.marks[cnt]=marks;
            cnt++;
        }

}
