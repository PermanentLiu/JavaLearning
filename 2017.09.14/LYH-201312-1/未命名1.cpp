#include <stdio.h>
#include <stdlib.h>

typedef struct SeqList PSeqList;

struct SeqList
{
	int MAX;
	int n; 
	int * element;
};







int main(void)
{
	PSeqList * palist_head = (PSeqList *)malloc(sizeof(PSeqList));
	scanf("%d", &palist_head -> MAX);
	int i = 1;
//	(PSeqList *)palist_head = (PSeqList *)malloc(sizeof(PSeqList));
	
	
	for ( ; i <= palist_head -> MAX; i++)
	{
		PSeqList * palist = (PSeqList *)malloc(sizeof(PSeqList));
		scanf("%d", &palist -> element[i]);
		if (i == 0)
		{
			palist_head = palist;
		}
	}
	
	
	for (i = 1; i <= palist_head -> MAX; i++)
	{
		printf("%d ", palist_head -> element[i]);
	}
	
	
	
	return 0;
}
