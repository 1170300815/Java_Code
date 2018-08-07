#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *fp;
    char ch;
    fp=fopen("demo.txt","w");
    if(fp==NULL)
    {
        printf("Failure to open demo.txt!\n");
        exit(0);
    }
    ch=getchar();
    while(ch!='\n')
    {
        fputc(ch,fp);
        ch=getchar();
    }
    fclose(fp);
    return 0;
}
