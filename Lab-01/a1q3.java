public class a1q3 {
    public static void main(String[] args)
    {
        StudentList roster = new StudentList();
            // will forget why I did this, have to check it again

        roster.add("rey", 99);
        roster.add("miya", 78);
        roster.add("ted", 76);
        roster.add("beyhive", 56);
        roster.add("ryad", 100);
        roster.add("ashmi", 0);
        roster.add("ishu", 100);
        roster.add("navid", 0);
        roster.add("mahmud", 20);
        roster.add("mohtasiba", 80);
        roster.add("muhtadi", 40);
        roster.add("nowshin", 50);


        roster.add("s1", 100);
        roster.topN(5);
        roster.removeAt(8);
        roster.update(7, 56);

        System.out.println("\n\n");
        roster.display();

        System.out.println("\n\n");
        roster.search("ishu");
    }
}

class StudentList {
    private String[] names = new String[50];
    private int[] marks = new int[50];
    private int count;

    /* Constructor */
    StudentList() {
        this.count = 0;
    }

    public void add (String name, int mark)
    {
        if(this.count >= 50)
        {
            System.out.println("ERORR 1");
            return;
        }

        names[count] = name;
        marks[count] = mark;

        this.count += 1;
    }

    public void removeAt(int index)
    {
        if(index >= count)
        {
            System.out.println("ERORR 2: don't have that many students");
            return;
        }

        for (int i = index; i < (count-1); i ++)
        {
            names[i] = names[i+1];
            marks[i] = marks[i+1];
        }

        names[count - 1] = null;
        marks[count - 1] = 0;
        count -= 1;
    }

    public void update (int index, int newMark)
    {
        if(index >= count)
        {
            System.out.println("ERORR 2: don't have that many students");
            return;
        }

        marks[index] = newMark;
    }

    public void display ()
    {
        for(int i=0; i<count; i++)
        {
            System.out.println((i+1) + " " + names[i] + " " + marks[i]);
        }
    }

    public int search (String query)
    {
        for(int i = 0; i < count; i++)
        {
            boolean x = query.equals(names[i]);
            if(x == true) 
            {
                System.out.println((i+1) + " " + names[i]);
                return i;
            }
        }

        System.out.println("ERROR 3: Name not found");
        return -1;
    }

    public void topN (int n)
    {
        String[] names2 = new String[count];
        int[] marks2 = new int[count];

        
        for(int i = 0; i < count; i++)
        {
            names2[i] = names[i];
            marks2[i] = marks[i];
        }


        for(int i = 0; i <  count; i++)
        {
            if (i == n) break;

            for(int j = i+1; j <  count; j++)
            {
                if (marks2[i] < marks2[j])
                {
                    int temp = marks2[i];
                    marks2[i] = marks2[j];
                    marks2[j] = temp;

                    String tempName = names2[i];
                    names2[i] = names2[j];
                    names2[j] = tempName;
                }
            }
            System.out.println((i+1) + " " + names2[i] + " " + marks2[i]);
        }
    }
};
