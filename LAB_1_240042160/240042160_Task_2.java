#include <stdio.h>
#include <string.h>

/*

Student Record System — Task 2 (Using struct in C)


Improvement over Task 1:
- Instead of two parallel arrays, we now use ONE array of Student.

Each Student contains:
    - name
    - mark

Benefits:
- Data is grouped logically
- Only ONE shift operation needed
- Less risk of inconsistency

Limitation:
- Data is still not protected (no encapsulation yet)

*/

#define MAX 50
#define NLEN 50

/* STRUCT */


/*A struct groups related data into a single unit.
Here, a Student has:
- a name
- a mark
*/
typedef struct {
    char name[NLEN];
    int mark;
} Student;


/* The prototypes */

void add(Student list[], int *count, const char *name, int mark);
void removeAt(Student list[], int *count, int index);
void update(Student list[], int count, int index, int newMark);
void display(Student list[], int count);
int search(Student list[], int count, const char *query);
void topN(Student list[], int count, int n);

/* The main program   */

int main() {
    Student list[MAX]; // single array of Student objects
    int count = 0;

    // Add students
    add(list, &count, "Ali", 85);
    add(list, &count, "John", 90);
    add(list, &count, "Sara", 75);

    // Display initial list
    display(list, count);

    printf("\nAfter update:\n");
    update(list, count, 1, 95);
    display(list, count);

    printf("\nAfter remove:\n");
    removeAt(list, &count, 0);
    display(list, count);

    printf("\nSearch John:\n");
    int index = search(list, count, "John");
    if (index != -1)
        printf("Found at index %d\n", index);
    else
        printf("Not found\n");

    printf("\nTop 2:\n");
    topN(list, count, 2);

    return 0;
}



/* 
   FUNCTION: add
   Purpose: Add a new student to the list
*/
void add(Student list[], int *count, const char *name, int mark) {

    // Check if list is full
    if (*count >= MAX) {
        printf("List is full!\n");
        return;
    }

    /*
    Access struct fields using dot operator:
    list[index].field
    */
    strcpy(list[*count].name, name);
    list[*count].mark = mark;

    // Increas   count
    (*count)++;
}



/* 
   FUNCTION: removeAt
   Purpose: Remove a student at a given index
 */
void removeAt(Student list[], int *count, int index) {

    // Validate index
    if (index < 0 || index >= *count) {
        printf("Invalid index!\n");
        return;
    }

    /*
    KEY IMPROVEMENT:
    One single assignment copies the entire struct
    (both name and mark at once)
    */
    for (int i = index; i < *count - 1; i++) {
        list[i] = list[i + 1]; // copies whole student
    }

    (*count)--;
}



/* 
   FUNCTION: update
   Purpose: Modify a student's mark
 */
void update(Student list[], int count, int index, int newMark) {

    if (index < 0 || index >= count) {
        printf("Invalid index!\n");
        return;
    }

    list[index].mark = newMark;
}



/* 
   FUNCTION: display
   Purpose: Print all students
 */
void display(Student list[], int count) {

    for (int i = 0; i < count; i++) {
        printf("%d. %s - %d\n", i, list[i].name, list[i].mark);
    }
}



/* 
   FUNCTION: search
   Purpose: Find a student by name
 */
int search(Student list[], int count, const char *query) {

    for (int i = 0; i < count; i++) {
        if (strcmp(list[i].name, query) == 0) {
            return i;
        }
    }

    return -1;
}



/* 
   FUNCTION: topN
   Purpose: Display top N students without modifying original list
 */
void topN(Student list[], int count, int n) {

    // Temporary copy of the list
    Student temp[MAX];

    /*  Copy */
    for (int i = 0; i < count; i++) {
        temp[i] = list[i]; // copies entire struct
    }

    /*  Sort (descending) */
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {

            if (temp[j].mark > temp[i].mark) {

                // Swap entire struct
                Student t = temp[i];
                temp[i] = temp[j];
                temp[j] = t;
            }
        }
    }

    /*  Display  */
    printf("Top %d students:\n", n);

    for (int i = 0; i < n && i < count; i++) {
        printf("%s - %d\n", temp[i].name, temp[i].mark);
    }
}