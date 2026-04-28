/*

Task1 - Reflection

a.  There are 4 paremeters of removeAt. 
    It doesn't feel natural, 
    like "why am I even doing so many tasks just to modify a list? 
    Isn't programming supposed to make my work easier? 
    I'm working more here!!!"
    Third field = one more parameter in the function = another array = more pain! >:(

b.  I wrote two seperate shift operations in removeAt:
    strcpy(names[i], names[i+1]);   SHIFT 1    
    marks[i] = marks[i+1];          SHIFT 2
    Had to deal with shifting twice because the names and marks are stored seperately,
    in two different arrays, can't deal with them together :(

c.  If a collegue accidentally passed the wrong array to update, 
    the code COULD NOT detect it, inside the function update(), the code cannot detect it.
    We never wrote anything to detect any "accident" :')
    So if we pass the wrong array...
    the "count" paramter might still be a number, maybe 10
    but it would be accessing a random memory, which has nothing to do with marks or names,
    Trying to change it might crash our program, because all memories can't be touched 

*/




#include "stdio.h"
#include "string.h"

#define MAX 50
#define NLEN 50

//  MAX = Max count of Student
// NLEN = Max count of Letters in Name

void add     (char  names[][NLEN], int marks[], int *count, 
              const char *name, int mark);

void removeAt(char names[][NLEN], int marks[], int *count, 
              int index);

void update  (int marks[], int count, 
              int index, int newMark);

void display (char names[][NLEN], int marks[], int count);

int search   (char names[][NLEN], int count, 
              const char *query);

void topN    (char names[][NLEN], int marks[], int count, 
              int n);


int main (void) 
{
    char names [MAX][NLEN] = {
        "rey", "miya", "ted", "beyhive",
        "ryad", "ashmi", "ishu", "navid", 
        "mahmud", "mohtasiba", "muhtadi", "nowshin"
    };

    int marks [MAX] = {
        99, 78, 76, 56,
        100, 0, 100, 0,
        20, 80, 40, 50
    };
    int count = 12;

    add(names, marks, &count, "s1", 100);
    topN(names, marks, count, 5);
    removeAt(names, marks, &count, 8);
    update(marks, count, 7, 10);

    printf("\n\n\n");
    display(names, marks, count);

    printf("\n\n\n");
    search(names, count, "ishu");



    /*
    
    char names [MAX][NLEN] = {"rey", "miya", "ted", "beyhive", "s1"};
    int marks [MAX] = {99, 78, 76, 56, 50};
    int count = 5;

    */


}













void add     (      char  names[][NLEN], int marks[], int *count, 
              const char *name,        int mark)
{   
    int c = *count;

    if(c >= MAX)
    {
        printf("ERORR 1");
        return;
    }

    strcpy(names[c], name);
    marks[c] = mark;

    *count = c + 1;
}












void removeAt(char names[][NLEN], int marks[], int *count, 
              int index)
{
    int c = *count;

    if(index >= c)
    {
        printf("ERORR 2: don't have that many students");
        return;
    }

    for (int i = index; i < (c-1); i ++)
    {
        strcpy(names[i], names[i+1]);
        marks[i] = marks[i+1];   
    }

        strcpy(names[c-1], "\0");
        marks[c-1] = 0;
        
    *count = c - 1;
}













void update  (int marks[], int count, 
              int index, int newMark)
{
    int c = count;

    if(index >= c)
    {
        printf("ERORR 2: don't have that many students");
        return;
    }

    marks[index] = newMark;
}

void display (char names[][NLEN], int marks[], int count)
{
    for(int i=0; i<count; i++)
    {
        printf("%d %s %d \n", i+1, names[i], marks[i]);
    }
}












int search   (char names[][NLEN], int count, 
              const char *query)
{
    for(int i = 0; i < count; i++)
    {
        int smth = strcmp(names[i], query);
        if(smth == 0) 
        {
            printf("%d %s \n", i+1, names[i]);
            return i;
        }
    }

    printf("ERROR 3: Name not found");
    return -1;
}







void topN    (char names[][NLEN], int marks[], int count, 
              int n)
{
    int marks2[count];
    char names2[count][NLEN];

    
    for(int i = 0; i < count; i++)
    {
        marks2[i] = marks[i];
        strcpy(names2[i], names[i]);
    }


    for(int i = 0; i <  count; i++)
    {
        if (i == n) break;

        for(int j = i+1; j <  count; j++)
        {
            if (marks2[i] < marks2[j])
            {
                int tempMark = marks2[i];
                marks2[i] = marks2[j];
                marks2[j] = tempMark;

                char tempName[NLEN];
                strcpy(tempName, names2[i]);
                strcpy(names2[i], names2[j]);
                strcpy(names2[j], tempName);
            }
        }
        printf("%d %s %d \n", i+1, names2[i], marks2[i]);
    }
}
