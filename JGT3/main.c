#include <stdio.h>
#include <stdlib.h>

typedef struct date
{
    int year;
    int month;
    int day;
}DATE;
DATE Func(DATE pt)
{
    pt.year=2000;
    pt.month=5;
    pt.day=22;
    return pt;
}
int main()
{
    DATE d;
    d.year=1999;
    d.month=4;
    d.day=23;
    printf("Before function call:%d/%02d/%02d\n",d.year,d.month,d.day);
    d=Func(d);
    printf("After function call:%d/%02d/%02d\n",d.year,d.month,d.day);
    return 0;
}
