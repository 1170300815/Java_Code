#include <stdio.h>
#include <stdlib.h>

struct link *AppendNode(struct link *head);
void DisplyNode(struct link *head);
void DeleteMemory(struct link *head);
struct link *DeleteNode(struct link *head,int notedata);
struct link *InsertNode(struct link *head,int nodeData);
struct link
{
    int data;
    struct link *next;
};
int main()
{
    int i=0,Data,Data1;
    char c,d,e;
    struct link *head =NULL;   /* 链表头指针 */
    printf("Do you want to append a new node(Y/N)?");
    scanf(" %c",&c);
    while (c=='y'||c=='Y')
    {
        head =AppendNode(head);  /*向head为头指针的链表末尾添加节点*/
        DisplyNode(head);  //        显示当前链表中的各节点信息
        printf("Do you want to append a new node(Y/N)?");
        scanf(" %c",&c);
        i++;
    }
    printf("%d new nodes have been appended!\n",i);
    printf("Do you want to delete a new node(Y/N)?");
    scanf(" %c",&d);
    while (d=='y'||d=='Y')
    {
        printf("Input the data which you want to delete\n");
        scanf("%d",&Data);
        head=DeleteNode(head,Data);
        DisplyNode(head);
        printf("Do you want to delete a new node(Y/N)?");
        scanf(" %c",&d);
    }

    printf("Do you want to insert a new node(Y/N)?");
    scanf(" %c",&e);
    while (e=='y'||e=='Y')
    {
        printf("Input the data which you want to insert\n");
        scanf("%d",&Data1);
        head=InsertNode(head,Data1);
        DisplyNode(head);
        printf("Do you want to delete a new node(Y/N)?");
        scanf(" %c",&e);
    }
    DeleteMemory(head);
    return 0;
}
struct link *AppendNode(struct link *head)
{
    struct link *p=NULL,*pr=head;
    int data;
    p= (struct link*)malloc(sizeof(struct link));
    if(p==NULL)
    {
        printf("No enough memory to allocate!\n");
        exit(0);
    }
    if(head==NULL)
    {
        head=p;
    }
    else
    {
        while(pr->next!=NULL)
        {
            pr=pr->next;
        }
        pr->next=p;
    }
    printf("Input node data:");
    scanf("%d",&data);
    p->data=data;
    p->next =NULL;
    return head;
}
void DisplyNode(struct link *head)
{
    struct link *p=head;
    int j=1;
    while(p!=NULL)
    {
        printf("%5d%10d\n",j,p->data);
        p=p->next;
        j++;
    }
}
void DeleteMemory(struct link *head)
{
    struct link *p=head,*pr=NULL;
    while(p!= NULL)
    {
        pr=p;
        p=p->next;
        free(pr);
    }
}
struct link *DeleteNode(struct link *head,int nodeData)
{
    struct link *p=head,*pr=head;
    if(head==NULL)
    {
        printf("Linked Table is empty!\n");
        return(head);
    }
    while(nodeData!=p->data&&p->next!=NULL)
    {
        pr=p;
        p=p->next;
    }
    if(nodeData==p->data)
    {
        if(p==head)
        {
            head=p->next;
        }
        else
        {
            pr->next=p->next;
        }
        free(p);
    }
    else
    {
        printf("This Node has not been found!\n");
    }
    return head;
}
struct link *InsertNode(struct link *head,int nodeData)
{
    struct link *pr=head,*p=head,*temp=NULL;
    p=(struct link *)malloc(sizeof(struct link));
    if(p==NULL)
    {
        printf("No enough memory!\n");
        exit(0);
    }
    p->next=NULL;
    p->data=nodeData;
    if(head==NULL)
    {
        head=p;
    }
    else
    {
        while(pr->data<nodeData&&pr->next!=NULL)
        {
            temp=pr;
            pr=pr->next;
        }
        if(pr->data>=nodeData)
        {
            if(pr==head)
            {
                p->next=head;
                head=p;
            }
            else
            {
                pr=temp;
                p->next=pr->next;
                pr->next=p;
            }
        }
        else
        {
            pr->next=p;
        }
    }
    return head;
}
