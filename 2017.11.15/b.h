#ifndef _B_H_
#define _B_H_

#include <stdio.h>
#include <stdlib.h>

typedef struct _TreeNode
{
	int data;
	
	_TreeNode * preNode;
	_TreeNode * leftNode;
	_TreeNode * rightNode;
}
pTreeNode, * TreeNode;

void print(TreeNode tree)
{
	if (tree -> leftNode != NULL)
	{
		print(tree -> leftNode);
	}
	
	printf("%d ", tree -> data);
	
	if (tree -> rightNode != NULL)
	{
		print(tree -> rightNode);
	}
}

TreeNode Search(TreeNode tree, int data, TreeNode tempNode)
{
	if (tree)
	{
		if (tree -> data == data)
		{
			return tree;
		}
		else if (data > tree -> data)
		{
			tempNode = tree;
			return Search(tree -> rightNode, data, tempNode);
		}
		else if (data < tree -> data)
		{
			tempNode = tree;
			return Search(tree -> leftNode, data, tempNode);
		}
	}
	
	return tempNode;
}

TreeNode Creation(int data)
{
	TreeNode tempNode = (TreeNode) malloc(sizeof(pTreeNode));
	
	if (tempNode)
	{
		tempNode -> data = data;
		tempNode -> leftNode = NULL;
		tempNode -> rightNode = NULL;
		tempNode -> preNode = NULL;
	}
	else
	{
		printf("Error");
		return NULL;
	}
	
	return tempNode;
}

TreeNode Insert(TreeNode tree, int data)
{
	TreeNode tempNode;
	TreeNode flag;
	
	if (tree)
	{
		flag = Search(tree, data, NULL);
		tempNode = Creation(data);
		tempNode -> preNode = flag;
		
		if (data > flag -> data)
		{
			flag -> rightNode = tempNode;
		}
		else
		{
			flag -> leftNode = tempNode;
		}
	}
	else
	{
		tree = Creation(data);
	}
	
	return tree;
}

#endif


