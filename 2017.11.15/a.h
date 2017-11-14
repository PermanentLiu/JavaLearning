#ifndef _A_H_
#define _A_H_

#include <stdio.h>
#include <stdlib.h>
#include <math.h>


typedef struct _Branch
{
	int data;
	
	_Branch * nextBranch;
}
* Branch;

typedef struct _Root
{
	int data;
	
	_Branch * nextBranch;
	_Root * nextRoot;
}
* Root;


Root treeRoot;




void searchData(int data)
{
	
	
	Root tempRoot = treeRoot;
	int level = 1;
	int temp = 1;
	
	printf("\n------------------------------------\n");
	
	while (tempRoot != NULL)
	{
		for (temp = 1; temp <= pow(2, level - 1); temp++)
		{
			if (tempRoot -> data == data)
			{
				printf("%d在 第%d层 第%d个", tempRoot -> data, level, temp);
				return;
			}
			
			
			if (tempRoot -> nextRoot == NULL)
			{
				return;
			}
			tempRoot = tempRoot -> nextRoot;
		}
		level++;
		
	}
}

void printTree()
{
	Root tempRoot = treeRoot;
	int level = 1;
	int temp = 1;
	int t = 1;
	
	printf("\n------------------------------------\n");
	
	while (tempRoot != NULL)
	{
		printf("第%d层: ", level);
		
		for (t = 1; t <= (4 - level); t++)
		{
			printf("   ");
		}
		
		for (temp = 1; temp <= pow(2, level - 1); temp++)
		{

			printf("%d", tempRoot -> data);
			
			for (t = 1; t <= (4 - level); t++)
			{
				printf("   ");
			}
			
			if (tempRoot -> nextRoot == NULL)
			{
				return;
			}
			tempRoot = tempRoot -> nextRoot;
		}
		printf("\n");
		level++;
		
	}
	
	
	
}

void initTree()
{
	treeRoot = (Root) malloc(sizeof(struct _Root));
	treeRoot -> data = 0;
	treeRoot -> nextBranch = NULL;
	treeRoot -> nextRoot = NULL;
}

void buildBranchRoot(Root root)
{
	Root tempRoot = treeRoot;
	Root dataRoot;
	
	Branch tempBranch = (Branch) malloc(sizeof(struct _Branch));
	tempBranch -> data = NULL;
	tempBranch -> nextBranch = NULL;
	
	
	
	
	
	if (root -> nextBranch -> nextBranch -> data != 0)//如果存在右子节点 
	{
		while (tempRoot -> nextRoot -> nextRoot != NULL)
		{
			tempRoot = tempRoot -> nextRoot;
		}
		
		dataRoot = (Root) malloc(sizeof(struct _Root));
		dataRoot -> nextBranch = tempBranch;
		dataRoot -> nextRoot = NULL;
		dataRoot -> data = root -> nextBranch -> nextBranch -> data;
		
		tempRoot -> nextRoot -> nextRoot = dataRoot;
		
		return;
	}
	
	if (root -> nextBranch -> data != 0)
	{
		while (tempRoot -> nextRoot != NULL)
		{
			tempRoot = tempRoot -> nextRoot;
		}
		
		dataRoot = (Root) malloc(sizeof(struct _Root));
		dataRoot -> nextBranch = tempBranch;
		dataRoot -> nextRoot = NULL;
		dataRoot -> data = root -> nextBranch -> data;
	
		tempRoot -> nextRoot = dataRoot;
		
		return;
	}
	
	
	
}

int insertThisRoot(Root tempRoot, int data)
{
	if (tempRoot -> data == 0)//在根上赋值 
	{
		tempRoot -> data = data;
		
		Branch newBranch = (Branch) malloc(sizeof(struct _Branch));
		newBranch -> data = NULL;
		newBranch -> nextBranch = NULL;
		
		tempRoot -> nextBranch = newBranch;
		
	
		
		return 1;
	} 
	else if (tempRoot -> nextBranch -> data == 0)//在左子节点上赋值 
	{
		tempRoot -> nextBranch -> data = data;
		
		Branch newBranch = (Branch) malloc(sizeof(struct _Branch));
		newBranch -> data = NULL;
		newBranch -> nextBranch = NULL;
		
		tempRoot -> nextBranch -> nextBranch = newBranch;
		
		buildBranchRoot(tempRoot);
		
		return 2;
	}
	else if (tempRoot -> nextBranch -> nextBranch -> data == 0)//在右子节点上赋值 
	{
		tempRoot -> nextBranch -> nextBranch -> data = data;
		
		buildBranchRoot(tempRoot);
		
		return 3;
	}
	else
	{
		return 0;
	}
}

void addData(int data)
{
	Root static tempRoot;
	
	if (treeRoot -> data == 0)
	{
		tempRoot = treeRoot;
	}
	
	int result;
	

	result = insertThisRoot(tempRoot, data);
	
	if (result == 3)
	{
		tempRoot = tempRoot -> nextRoot;
	}
	
	printTree();
}


#endif
