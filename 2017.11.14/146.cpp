#include <stdio.h>
#include <stdlib.h>
#include "a.h"


typedef struct TreeNode
{
	int data;
	
	TreeNode* previous;
	TreeNode* llink;
	TreeNode* rlink;
}TN, *TNP;


void Print(TNP tree)
{
	if (tree->llink != NULL)
	{
		Print(tree->llink);
	}
	printf("%d ", tree->data);
	
	if (tree->rlink != NULL)
	{
		Print(tree->rlink);
	}	
}


TNP Search(TNP tree, int data, TNP temp2)
{
	if (tree)
	{
		if (tree->data == data)
		{
			return tree;
		}
		else if (data > tree->data)
		{
			temp2 = tree;
			return Search(tree->rlink, data, temp2);
		}
		else if (data < tree->data)
		{
			temp2 = tree;
			return Search(tree->llink, data, temp2);
		}
	}
	return temp2;
}
TNP Creation(int data)
{
	TNP p;
	p = (TNP)malloc(sizeof(TN));
	if (p)
	{
		p->data = data;
		p->llink = NULL;
		p->rlink = NULL;
		p->previous = NULL;
	}
	else
	{
		printf("error! no space to creative node!\n");
		return NULL;
	}
	return p;
}



TNP Insert(TNP tree, int data)
{
	TNP temp;
	TNP flag;
	if (tree)
	{
		flag = Search(tree, data, NULL);
		temp = Creation(data);
		temp->previous = flag;
		if (data>flag->data)
		{
			flag->rlink = temp;
		}
		else
		{
			flag->llink = temp;
		}
	}
	else
	{
		tree= Creation(data);
	}
	return tree;
}


int main(void)
{
	initTree();
	
	int data[7] = { 5,7,6,9,3,2,4 };
	TNP tree=NULL;
	printf("data:");
	for (int x = 0; x < 7; x++)
	{
		printf(" %d", data[x]);
		tree=Insert(tree,data[x]);
	}
	printf("\n");
	Print(tree);
	printf("\n");
//	print(tree);
	
	printTree();
	
	return 0;
}
