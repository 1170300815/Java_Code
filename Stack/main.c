#include <stdio.h>
#include <stdlib.h>
#define initSize 20
//占空间初始大小

//#define maxsize 100
//typedef int SElemType;
//typedef struct
//{
//    SElemType elem[maxsize];
//    int top;
//}SeqStack;
typedef int SElemType;
typedef struct
{
    SElemType *elem;
    int maxSize;
    int top;
}SeqStack;
void InitStack(SeqStack S)
//建立一个最大尺寸为initSize的空栈，若分配不成功则进行错误处理
{
    S.elem=(SElemType*)malloc(initSize*sizeof(SElemType));
//    创建栈空间
    if(S.elem==NULL)
    {
        printf("存储分配失败！\n");
        exit(1);
    }
    S.maxSize=initSize;
    S.top=-1;
}
int Push(SeqStack S,SElemType x)
//进栈操作：若栈不满，则将元素x插入栈顶，函数返回1；否则栈溢出，函数返回0；
{
    if(S.top==S.maxSize-1)
    {
        return 0;
    }
    S.elem[++S.top]=x;
    return 1;
}
int Pop(SeqStack S,SElemType x)
//退栈：若栈不空则函数通过引用参数x返回栈顶元素值，栈顶指针退1，函数返回1；否则函数返回0，且x的值不可引用。
{
    if(S.top==-1)
    {
        return 0;
    }
    x=S.elem[S.top--];
    return 1;
}
int Gettop(SeqStack S,SElemType x)
//读取栈顶元素的值：若栈不空则函数返回栈顶元素的值且函数返回1，否则函数返回0
{
    if(S.top==-1)
    {
        return 0;
    }
    x=S.elem[S.top];
    return 1;
}
int StackEmpty(SeqStack S)
//函数测试栈S是否为空。若栈满，则函数返回1，否则函数返回0
{
    return S.top==-1;
}
int StackFull(SeqStack S)
//函数测试栈S是否为满。若栈满，则函数返回1，否则函数返回0
{
    return S.top==S.maxSize;
}
int StackSize(SeqStack S)
//函数返回栈S的长度，即栈S中元素个数
{
    return S.top+1;
}
void Reverse(int a[],int n)
//将向量a中所有元素逆置
{
    SeqStack S;
    InitStack(S);
    int i;
    for(i=1;i<=n;i++)
    {
        Push(S,a[i-1]);
    }
    i=0;
    while(!StackEmpty(S))
    {
        Pop(S,a[i++]);
    }
}

int main()
{
    printf("Hello world!\n");
    return 0;
}
