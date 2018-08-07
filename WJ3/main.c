#include <stdio.h>
#include <stdlib.h>
#define N 80
int main()
{
    FILE *fp;
    char str[N];
    fp=fopen("demo.txt","a");
    if(fp==NULL)
    {
        printf("Failure to open demo.txt!\n");
        exit(0);
    }
    gets(str);
    fputs(str,fp);
    fclose(fp);
    fp=fopen("demo.txt","r");
    if(fp==NULL)
    {
        printf("Failure to open demo.txt!\n");
        exit(0);
    }
    fgets(str,N,fp);
    puts(str);
    fclose(fp);
    return 0;
}
