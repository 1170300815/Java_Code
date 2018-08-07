#include <stdio.h>
#include <stdlib.h>

typedef int  QElemType;
typedef struct Node
{
    QElemType data;
    struct Node *Link;
} LinkNode;
typedef struct
{
    LinkNode *front;
    LinkNode *rear;
} LinkQueue1,*LinkQueue;
void InitQueue(LinkQueue Q)
//队列初始化：令队头指针和队尾指针均为NULL
{
    (*Q).front=(*Q).rear=NULL;
}
int EnQueue(LinkQueue Q,QElemType x)
//进队列：将新元素x插入到队列的队尾（链尾）
{

    LinkNode *s=(LinkNode *)malloc(sizeof(LinkNode));
    s->data=x;
    s->Link=NULL;
    if((*Q).rear==NULL)
    {
        (*Q).front=(*Q).rear=s;
    }
    else
    {
        (*Q).rear->Link=s;
        (*Q).rear=s;
    }
}
int DeQueue (LinkQueue Q,QElemType *x)
//出队列：如果队列空，不能退队，函数返回0；且引用参数x的值不可用
{
    if((*Q).front==NULL)
    {
        return 0;
    }
    LinkNode *p=(*Q).front;
    *x=p->data;
    (*Q).front=p->Link;
    free(p);
    if((*Q).front==NULL)
    {
        (*Q).rear=NULL;
    }
    return 1;
}
int GetFront(LinkQueue Q,QElemType *x)
//读取队头元素的值：若队列为空，则函数返回0，且引用参数x的值不可用
//若队列不为空，函数返回1，且从引用参数x可得到退出的队头元素的值
{
    if((*Q).front==NULL)
    {
        return 0;
    }
    *x=(*Q).front->data;
    return 1;
}
int QueueEmpty(LinkQueue Q)
//判断队列是否为空：队列空则函数返回1，否则函数返回0
{
    return (*Q).front==NULL;
}
int QueueSize(LinkQueue Q)
{
    LinkNode *p=(*Q).front;
    int k=0;
    while(p!=NULL)
    {
        p=p->Link;
        k++;
    }
    return k;
}
int main()
{
    QElemType s,s1;
    LinkQueue Q=(LinkQueue)malloc(sizeof(LinkQueue1));
    InitQueue(Q);
    EnQueue(Q,10);
    EnQueue(Q,7);
    DeQueue(Q,&s);
    DeQueue(Q,&s1);
    printf("%d\n",s);
    printf("%d",s1);
    return 0;
}
