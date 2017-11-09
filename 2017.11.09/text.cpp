/*
问题：迷宫问题 
算法：广度优先搜索 
数据结构：邻接表 
*/
#include <stdio.h>
#include <stdlib.h>
#define R 7 

typedef struct _Branch
{
	int row;
	int column;

	_Branch * nextBranch;
}
* Branch;

typedef struct _Root
{
	int row;
	int column;

	_Root * nextRoot;
	_Branch * nextBranch;
}
* Root;

/////////////////////////////全局变量 
int map[R][R];//迷宫 
Root treeRoot;//树根 
int level = 1;//第几层 
/////////////////////// 

void printMap()
{
	printf("\n---------------------------------------------------------------------\n");

	int i = 0;
	int j = 0;

	for (i = 0; i < R; i++)
	{
		for (j = 0; j < R; j++)
		{
			if (map[i][j] == -1)
			{
				printf("\t□");
			}
			else
			{
				printf("\t%d", map[i][j]);
			}
		}
		printf("\n");
	}
}

Branch findBranch(Root tempRoot, int templevel)//寻路 
{
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));	
	int tempRow = tempRoot -> row;
	int tempColumn = tempRoot -> column;

	//up
	if (map[tempRow - 1][tempColumn] == 0)
	{
		tempBranch -> row = tempRow - 1;
		tempBranch -> column = tempColumn;
		map[tempRow - 1][tempColumn] = templevel + 1;//等于当前的层数加一 

		return tempBranch;
	}
	else if (map[tempRow - 1][tempColumn] == 9)//出口是9 
	{
		level = 0;//找到了出口，把当前层数变成0，并返回NULL 
	}
	
	//right
	if (map[tempRow][tempColumn + 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn + 1;
		map[tempRow][tempColumn + 1] = templevel + 1;

		return tempBranch;
	}
	else if (map[tempRow][tempColumn + 1] == 9)
	{
		level = 0;
	}

	//down
	if (map[tempRow + 1][tempColumn] == 0)
	{
		tempBranch -> row = tempRow + 1;
		tempBranch -> column = tempColumn;
		map[tempRow + 1][tempColumn] = templevel + 1;
		
		return tempBranch;
	}
	else if (map[tempRow + 1][tempColumn] == 9)
	{
		level = 0;
	}

	//left
	if (map[tempRow][tempColumn - 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn - 1;
		map[tempRow][tempColumn - 1] = templevel + 1;
		
		return tempBranch;
	}
	else if (map[tempRow][tempColumn - 1] == 9)
	{
		level = 0;
	}
	return NULL;
}

void addRoot(Branch tempBranch)
{
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Root tempBranchRoot = (struct _Root *) malloc (sizeof(struct _Root));
	//初始化 
	{ 
		tempBranchRoot -> row = tempBranch -> row;
		tempBranchRoot -> column = tempBranch -> column;
		tempBranchRoot -> nextBranch = NULL;
		tempBranchRoot -> nextRoot = NULL;
	}
	 
	tempRoot = treeRoot;
	while (tempRoot -> nextRoot != NULL)
	{
		tempRoot = tempRoot -> nextRoot;
	}
	tempRoot -> nextRoot = tempBranchRoot;
}

void createRoot(Root tempRoot)
{
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	tempBranch = tempRoot -> nextBranch;

	while (tempBranch != NULL)
	{
		addRoot(tempBranch);//把当前branch变成root 
		tempBranch = tempBranch -> nextBranch;
	} 
}

void createTree()
{
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	Branch lastBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	
	tempRoot = treeRoot;

	while (level != 0)//标识符，如果为0就代表找到了出口 
	{
		tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);
		//为当前root建立branch 
		while (tempBranch != NULL)//如果还有branch 
		{
			tempBranch -> nextBranch = NULL;
			tempRoot -> nextBranch = tempBranch;
			lastBranch = tempBranch;

			tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);

			while (tempBranch != NULL)
			{
				lastBranch -> nextBranch = tempBranch;
				lastBranch = tempBranch;
				tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);
			}
		}
		createRoot(tempRoot);//把当前root的branch创建成root，放在表尾 
		tempRoot = tempRoot -> nextRoot;//接着寻找下一个root 

		printMap();
	}
}

int main(void)

{
	map[0][0] = -1; map[0][1] = -1; map[0][2] = -1; map[0][3] = -1; map[0][4] = -1; map[0][5] = -1; map[0][6] = -1;
	map[1][0] = -1; map[1][1] =  1; map[1][2] =  0; map[1][3] =  0; map[1][4] =  0; map[1][5] =  0; map[1][6] = -1;
	map[2][0] = -1; map[2][1] = -1; map[2][2] = -1; map[2][3] =  0; map[2][4] = -1; map[2][5] = -1; map[2][6] = -1;
	map[3][0] = -1; map[3][1] = -1; map[3][2] = -1; map[3][3] =  0; map[3][4] = -1; map[3][5] = -1; map[3][6] = -1;
	map[4][0] = -1; map[4][1] =  0; map[4][2] =  0; map[4][3] =  0; map[4][4] =  0; map[4][5] =  0; map[4][6] = -1;
	map[5][0] = -1; map[5][1] = -1; map[5][2] = -1; map[5][3] =  0; map[5][4] = -1; map[5][5] =  9; map[5][6] = -1;
	map[6][0] = -1; map[6][1] = -1; map[6][2] = -1; map[6][3] = -1; map[6][4] = -1; map[6][5] = -1; map[6][6] = -1; 
	printMap();

	//初始化根 
	{
		treeRoot = (struct _Root *) malloc (sizeof(struct _Root));
		treeRoot -> nextRoot = NULL;
		treeRoot -> row = 1;
		treeRoot -> column = 1;
	}
	
	createTree();

	return 0;

}
