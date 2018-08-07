#include <stdio.h>
#include <stdlib.h>

struct date
{
    int year;
    int month;
    int day;
};
struct marriedState
{
    struct date marryDay;
    char spouseName[20];
    int child;
};
struct divorceState
{
    struct date divorceDay;
    int child;
};
union maritalState
//由于同一内存单元在每一瞬间只能存放其中一种数据类型的成员，也就是说同一时刻只有一个成员是有意义的
{
    int single;
    struct marriedState married;
    struct divorceState divorce;
};
struct person
{
    char name[20];
    char sex;
    int age;
    union maritalState marital;
    int marryFlag;
};
int main()
{
    printf("Hello world!\n");
    return 0;
}
