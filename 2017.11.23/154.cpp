#include <stdio.h>
#include <stdlib.h>


typedef struct _Node
{
	int data;
	
	_Node * next;
}
pNode, * Node; 


Node head;


Node createNode()
{
	Node temp = (Node) malloc(sizeof(pNode));
	temp -> data = 0;
	temp -> next = NULL;
	
	return temp;
}

void print()
{
	Node temp = head;
	
	int count = 1;
	
	while (temp != NULL)
	{
		printf("%d\t%d\n", count, temp -> data);
		temp = temp -> next;
		count++;
	}
}

void addNode()
{
	Node t = head;
	Node temp = createNode();
	printf("Please input the data: ");
	scanf("%d", &(temp -> data));
//	temp -> next = NULL;
	
	while (t -> next != NULL)
	{
		t = t -> next;
	}
	
	t -> next = temp;
	
	print();
}

void searchByNo()
{
	Node t = head;
	int location = 1;
	int count = 1;
	
	
	scanf("%d", &location);
	
	while (count != location)
	{
		t = t -> next;
		
		count++;
	}
	
	printf("第%d位置上的值是%d\n", location, t -> data);
}

void deleteByNo()
{
	Node t = head;
	int location = 1;
	int count = 1;
	Node temp;
	
	temp = t;
	t = t -> next;
	
	scanf("%d", &location);
	
	while (count != location)
	{
		t = t -> next;
		temp = temp -> next;
		count++;
	}
	
//	printf("第%d位置上的值是%d", location, head -> data);
	temp -> next = t -> next;
	free(t);
}

void searchByData()
{
	Node t = head;
	int data = 0;
	int count = 1;
	
	t = t -> next;
	
	scanf("%d", &data);
	
	while (data != t -> data)
	{
		t = t -> next;
		
		count++;
	}
	
	printf("%d在第%d个位置上\n", data, count + 1);
}

void deleteByData()
{
	Node t = head;
	int data = 0;
	int count = 1;
	Node temp = t;
	
	t = t -> next;
	
	scanf("%d", &data);
	
	while (data != t -> data)
	{
		t = t -> next;
		temp = temp -> next;
		
		count++;
	}
	
//	printf("%d在第%d个位置上", data, count);
	temp -> next = t -> next;
	free(t);
}

void backSpace()
{
	
	int choose = 0;
	int flag = 1;
	
	
	printf("输入1，按位置删除\n");
	printf("输入2，按数据删除\n");
	scanf("%d", &choose);
	
	while (flag)
	{
		if (choose == 1)
		{
			printf("请输入位置：" );
			deleteByNo();
			flag = 0;
		}
		else if (choose == 2)
		{
			printf("请输入数据：");
			deleteByData();
			flag = 0;
		}
		else
		{
			printf("Error input!\n");
			printf("Please input again\n");
			
			printf("输入1，按位置删除\n");
			printf("输入2，按数据删除\n");
			scanf("%d", &choose);
		}
		
		
	}
	
}




int main(void)
{
	int flag = 1;
	int count = 1;
	int temp = 0;
	head = createNode();
	print();
	
	//
	printf("你想输入几个节点");
	scanf("%d", &count);
	for (temp = 1; temp <= count; temp++)
	{
		addNode();
		
	}
	
	//
	printf("你想查找第几个位置上的值");
	searchByNo();
	print();
	
	printf("你想查找的数在第几个位置");
	searchByData();
	print();
	
	//
	backSpace();
	print();
	
	//
//	print(head);
	printf("over");
	return 0;
}





