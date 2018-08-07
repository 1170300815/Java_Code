#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *fp;
    char ch;
    int i;
    fp=fopen("demo.bin","wb");
    if(fp==NULL)
    {
        printf("Failure to open demo.bin!\n");
        exit(0);
    }
    for(i=0;i<128;i++)
    {
        fputc(i,fp);
    }
    fclose(fp);
    fp=fopen("demo.bin","rb");
    if(fp==NULL)
    {
        printf("Failure to open demo.bin!\n");
        exit(0);
    }
    while((ch=fgetc(fp))!=EOF)
    {
        putchar(ch);

    }
    fclose(fp);
    return 0;
}
