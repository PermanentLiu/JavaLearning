/*
深度优先算法 
*/ 
#include <stdio.h>
#include <stdlib.h>
#define R 6 

struct _Node
{
	int line;
	int list;
	int data;
	
	_Node * next;
	_Node * last;
};

typedef struct _Node Node;
typedef struct _Node* pNode;
////////////////////////////////////////////////////////////

int map[R][R];
pNode head = (pNode) malloc(sizeof(Node));
pNode tail = (pNode) malloc(sizeof(Node));

/////////////////////////////////////////////////////////////
void listInsert(int i, int j)
{
	pNode temp = (pNode) malloc(sizeof(Node));
	
	temp -> line = i;
	temp -> list = j;
	temp -> data = map[i][j];
	
	temp -> last = head;
	temp -> next = head -> next;
	
	head -> next -> last = temp;
	head -> next = temp;
}

void printMap()
{
	printf("\n-----------------------------------------------------\n");
	
	int i = 0;
	int j = 0;
	
	for (i = 0; i < R; i++)
	{
		for (j = 0; j < R; j++)
		{
			printf("%d\t", map[i][j]);
		}
		printf("\n");
	}
}

void printWay()
{
	int length = 0;;

	pNode temp = (pNode) malloc(sizeof(Node));
	temp = head -> next;
	while (temp != tail)
	{
		map[temp -> line][temp -> list] = 1;
		temp = temp -> next;
	}
	printMap();
	
	printf("\n-----------------------------------------------------\n");
	
	temp = head -> next;
	while (temp != tail)
	{
		printf("%d, %d\n", temp -> line, temp -> list);
		length++;
		temp = temp -> next;
	}
	
	printf("\nThe length is : %d", length);
}

pNode recall()
{
	pNode t2 = head -> next;
	pNode t1 = t2 -> next;
	
	while (t2 -> data < t1 -> data)
	{
		map[t2 -> line][t2 -> list] = -1;
		head -> next = t1;
		t1 -> last = head;
		
		t2 = head -> next;
		t1 = t2 -> next;
	}
	
	head -> next = t1;
	t1 -> last = head;
	return t2;
}

void findWay(int i, int j)
{
	pNode temp = (pNode) malloc(sizeof(Node));
	int t;
	
	if (map[i - 1][j] == 0)//up 
	{
		t++;
	} 
	else if (map[i - 1][j] == 9)
	{
		listInsert(i, j);
		listInsert(i - 1, j);
		return;
	}
	
	if (map[i][j + 1] == 0)//right
	{
		t++;
	}
	else if (map[i][j + 1] == 9)
	{
		listInsert(i, j);
		listInsert(i, j + 1);
		return;
	}
	
	if (map[i + 1][j] == 0)//down
	{
		t++;
	}
	else if (map[i + 1][j] == 9)
	{
		listInsert(i, j);
		listInsert(i + 1, j);
		return;
	}
	
	if (map[i][j - 1] == 0)//left
	{
		t++;
	}
	else if (map[i][j - 1] == 9)
	{
		listInsert(i, j);
		listInsert(i, j - 1);
		return;
	}
	
	map[i][j] = t;
	printMap();	
	listInsert(i, j);
	
	if (map[i - 1][j] == 0)//up 
	{
		findWay(i - 1, j);
	} 
	else if (map[i][j + 1] == 0)//right
	{
		findWay(i, j + 1);
	}
	else if (map[i + 1][j] == 0)//down
	{
		findWay(i + 1, j);
	}
	else if (map[i][j - 1] == 0)//left
	{
		findWay(i, j - 1);
	}
	
	//如果周围没有路可走 
	else
	{
		//回溯
		temp = recall();
		i = temp -> line;
		j = temp -> list;
		
		findWay(i, j);
	}
}

int main(void)
{
	map[0][0] = -1; map[0][1] = -1; map[0][2] = -1; map[0][3] = -1; map[0][4] = -1; map[0][5] = -1;
	map[1][0] = -1; map[1][1] =  0; map[1][2] =  0; map[1][3] =  0; map[1][4] =  0; map[1][5] = -1;
	map[2][0] = -1; map[2][1] = -1; map[2][2] =  0; map[2][3] = -1; map[2][4] = -1; map[2][5] = -1;
	map[3][0] = -1; map[3][1] = -1; map[3][2] =  0; map[3][3] =  0; map[3][4] =  0; map[3][5] = -1;
	map[4][0] = -1; map[4][1] = -1; map[4][2] =  0; map[4][3] = -1; map[4][4] =  9; map[4][5] = -1;
	map[5][0] = -1; map[5][1] = -1; map[5][2] = -1; map[5][3] = -1; map[5][4] = -1; map[5][5] = -1;
	
	printMap();
	
	{
		head -> next = tail;
		tail -> last = head;
	}
	findWay(1, 1);
	printMap();
	printWay();
	
	return 0;
}
