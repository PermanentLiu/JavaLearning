#include <stdio.h>
#include <stdlib.h>


#define R 7 

struct _Branch
{
	int row;
	int column;
	
	_Branch * nextBranch;
};

struct _Root
{
	_Branch * thisBranch;
	
	_Root * nextRoot;
	_Branch * nextBranch;
};


typedef struct _Branch * Branch;
typedef struct _Root * Root;




int map[R][R];

Root treeRoot;
int lever = 1;//?????




void printMap()
{
	printf("\n-----------------------------------------------------\n");
	
	int i = 0;
	int j = 0;
	
	for (i = 0; i < R; i++)
	{
		for (j = 0; j < R; j++)
		{
			printf("\t%d", map[i][j]);
		}
		printf("\n");
	}
}

Branch findBranch(Root tempRoot, int tempLever)
{
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));	
	int tempRow = tempRoot -> thisBranch -> row;
	int tempColumn = tempRoot -> thisBranch -> column;
	
	//up
	if (map[tempRow - 1][tempColumn] == 0)//??????
	{
		tempBranch -> row = tempRow - 1;
		tempBranch -> column = tempColumn;

		map[tempRow - 1][tempColumn] = tempLever + 1;//????
		
		return tempBranch;
	}
	else if (map[tempRow - 1][tempColumn] == 9)
	{
		//?????
		lever = -1;
	}
	
	//right
	if (map[tempRow][tempColumn + 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn + 1;
		
		map[tempRow][tempColumn + 1] = tempLever + 1;//????
		
		return tempBranch;
	}
	else if (map[tempRow][tempColumn + 1] == 9)
	{
		//?????
		lever = -1;
	}
	
	//down
	if (map[tempRow + 1][tempColumn] == 0)
	{
		tempBranch -> row = tempRow + 1;
		tempBranch -> column = tempColumn;

		map[tempRow + 1][tempColumn] = tempLever + 1;//????
		
		return tempBranch;
	}
	else if (map[tempRow + 1][tempColumn] == 9)
	{
		//?????
		lever = -1;
	}
	
	//left
	if (map[tempRow][tempColumn - 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn - 1;
		
		map[tempRow][tempColumn - 1] = tempLever + 1;//????
		
		return tempBranch;
	}
	else if (map[tempRow][tempColumn - 1] == 9)
	{
		//?????
		lever = -1;
	}
	
	return NULL;
}

void addRoot(Branch tempBranch)
{
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Root tempBranchRoot = (struct _Root *) malloc (sizeof(struct _Root));
	
	tempBranchRoot -> thisBranch -> row = tempBranch -> row;
	tempBranchRoot -> thisBranch -> column = tempBranch -> column;
	
	
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
	
	tempBranch = tempRoot -> thisBranch;
	while (tempBranch -> nextBranch != NULL)
	{
		if (tempBranch = tempRoot -> thisBranch)
		{
			continue;
		}
		else
		{
			addRoot(tempBranch);
		}
		
		
		
		tempBranch = tempBranch -> nextBranch;
	}
	
}


void createTree()
{
	int flag = 1;
	int tempLever = 1;
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Root flagRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));

	tempRoot = treeRoot;
	
	
	
	while (lever != 0)//????????
	{
		tempBranch = findBranch(tempRoot, map[tempRoot -> thisBranch -> row][tempRoot -> thisBranch -> column]);
		//????root?branch
		while (tempBranch != NULL)//??????
		{
			
			tempRoot -> nextBranch = tempBranch;

			tempBranch = findBranch(tempRoot, map[tempRoot -> thisBranch -> row][tempRoot -> thisBranch -> column]);//???

		}
		
		createRoot(tempRoot);//?tempRoot?branch??root
		
		tempRoot = tempRoot -> nextRoot;
	}
	
	//??????
	printMap();
}





int main(void)
{
	map[0][0] = -1; map[0][1] = -1; map[0][2] = -1; map[0][3] = -1; map[0][4] = -1; map[0][5] = -1; map[0][6] = -1;
	map[1][0] = -1; map[1][1] =  0; map[1][2] =  0; map[1][3] =  0; map[1][4] =  0; map[1][5] =  0; map[1][6] = -1;
	map[2][0] = -1; map[2][1] = -1; map[2][2] = -1; map[2][3] =  0; map[2][4] = -1; map[2][5] = -1; map[2][6] = -1;
	map[3][0] = -1; map[3][1] = -1; map[3][2] =  0; map[3][3] = -1; map[3][4] = -1; map[3][5] = -1; map[3][6] = -1;
	map[4][0] = -1; map[4][1] =  0; map[4][2] = -1; map[4][3] =  0; map[4][4] = -1; map[4][5] =  0; map[4][6] = -1;
	map[5][0] = -1; map[5][1] = -1; map[5][2] = -1; map[5][3] =  0; map[5][4] =  0; map[5][5] = -1; map[5][6] =  0;
	map[6][0] = -1; map[6][1] = -1; map[6][2] = -1; map[6][3] = -1; map[6][4] = -1; map[6][5] = -1; map[6][6] =  9; 
	
	//???treeRoot
	treeRoot = (struct _Root *) malloc (sizeof(struct _Root));
	treeRoot -> thisBranch -> row = 1;
	treeRoot -> thisBranch -> column = 1;
	
	createTree();
	
	return 0;
}
