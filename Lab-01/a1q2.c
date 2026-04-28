/*

Task2 - Reflection

a.  The arrays "names" and "marks" are gone now,
    substituted "list"
    because, "names" and "marks" are now inside "list"
    and FINALLY they are working together, unlike task1 :D

b.  Unfortunately, yes... someone could still call "update" with a wrong array
    and the code stil can't prevent it :/

c.  Yes, "main" can write 'list[0].mark = -999' directly without any function
    WHICH was supposed to be done only using "update"
    This is a pretty big problem, 
    because we can accidently change the mark in "main" without realising :/
    To prevent this, we must use something that does not allow this
    outside "update".... which is CLASS

*/




#include "stdio.h"
#include "string.h"

#define MAX 50
#define NLEN 50

//  MAX = Max count of Student
// NLEN = Max count of Letters in Name


typedef struct {
    char name[NLEN];
    int mark;
} Student;

void add     (Student list[], int *count, 
              const char *name, int mark);

void removeAt(Student list[], int *count, 
              int index);

void update  (Student list[], int count, 
              int index, int newMark);

void display (Student list[], int count);

int search   (Student list[], int count, 
              const char *query);

void topN    (Student list[], int count, 
              int n);


int main (void) 
{
    Student students[MAX] = {
        {"rey", 99},
        {"miya", 78},
        {"ted", 76},
        {"beyhive", 56},
        {"ryad", 100},
        {"ashmi", 0},
        {"ishu", 100},
        {"navid", 0},
        {"mahmud", 20},
        {"mohtasiba", 80},
        {"muhtadi", 40},
        {"nowshin", 50}
    };

    int count = 12;

    add(students, &count, "s1", 100);
    topN(students, count, 5);
    removeAt(students, &count, 8);
    update(students, count, 7, 10);

    printf("\n\n\n");
    display(students, count);

    printf("\n\n\n");
    search(students, count, "ishu");



    /*
    
    char names [MAX][NLEN] = {"rey", "miya", "ted", "beyhive", "s1"};
    int marks [MAX] = {99, 78, 76, 56, 50};
    int count = 5;

    */
}













void add     (Student list[],   int *count, 
              const char *name, int mark)
{   
    int c = *count;

    if(c >= MAX)
    {
        printf("ERORR 1");
        return;
    }

    strcpy(list[c].name, name);
    list[c].mark = mark;

    *count = c + 1;
}











void removeAt(Student list[], int *count, int index)
{
    int c = *count;

    if(index >= c)
    {
        printf("ERORR 2: don't have that many students");
        return;
    }

    for (int i = index; i < (c-1); i ++)
    {
        list[i] = list[i+1];
    }

        strcpy(list[c-1].name, "\0");
        list[c-1].mark = 0;
        
    *count = c - 1;
}













void update  (Student list[], int count,
              int index, int newMark)
{
    int c = count;

    if(index >= c)
    {
        printf("ERORR 2: don't have that many students");
        return;
    }

    list[index].mark = newMark;
}

void display (Student list[], int count)
{
    for(int i=0; i<count; i++)
    {
        printf("%d %s %d \n", i+1, list[i].name, list[i].mark);
    }
}












int search   (Student list[], int count, 
              const char *query)
{
    for(int i = 0; i < count; i++)
    {
        int smth = strcmp(list[i].name, query);
        if(smth == 0) 
        {
            printf("%d %s \n", i+1, list[i].name);
            return i;
        }
    }

    printf("ERROR 3: Name not found");
    return -1;
}







void topN    (Student list[], int count, 
              int n)
{
    Student list2[count];

    
    for(int i = 0; i < count; i++)
    {
        list2[i] = list[i];
    }


    for(int i = 0; i <  count; i++)
    {
        if (i == n) break;

        for(int j = i+1; j <  count; j++)
        {
            if (list2[i].mark <list2[j].mark)
            {
                Student temp = list2[i];
                list2[i] = list2[j];
                list2[j] = temp;
            }
        }
        printf("%d %s %d \n", i+1, list2[i].name, list2[i].mark);
    }
}
