#include <stdio.h>
#include <stdlib.h>

typedef struct date
{
    int year;
    int month;
    int day;
}DATE;
typedef struct student
{
    long studentID;
    char studentName[10];
    char studentSex;
    DATE birthday;
    int score[4];
}STUDENT;
int main()
{
    STUDENT stu1,stu2;
    int i;
    printf("Input a record:\n");
    scanf("%ld",&stu1.studentID);
    scanf("%s",stu1.studentName);
    scanf(" %c",&stu1.studentSex);
    scanf("%d",&stu1.birthday.year);
    scanf("%d",&stu1.birthday.month);
    scanf("%d",&stu1.birthday.day);
    for(i=0;i<4;i++)
    {
        scanf("%d",&stu1.score[i]);
    }
    stu2=stu1;
    printf("&stu2=%p\n",&stu2);
    printf("%10ld%8s%3c%6d/ %02d/ %02d%4d%4d%4d%4d\n",stu2.studentID,stu2.studentName,stu2.studentSex,stu2.birthday.year,stu2.birthday.month,
           stu2.birthday.day,stu2.score[0],stu2.score[1],stu2.score[2],stu2.score[3]);
    return 0;
}
