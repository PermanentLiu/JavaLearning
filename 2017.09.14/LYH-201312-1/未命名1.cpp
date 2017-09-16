#include <stdio.h>
#include <stdlib.h>



struct SeqList
{
	int MAX;
	int n; 
	int * element;
};


typedef struct SeqList * PSeqList;




int main(void)
{
	PSeqList palist_head = (PSeqList)malloc(sizeof(struct SeqList));
	scanf("%d", &palist_head -> MAX);
	int i = 0;
//	(PSeqList *)palist_head = (PSeqList *)malloc(sizeof(PSeqList));
	
	
	for ( ; i < palist_head -> MAX; i++)
	{
//		int temp;
		PSeqList palist = (PSeqList)malloc(sizeof(struct SeqList));
		scanf("%d", &palist -> element[i]);
//		palist -> element[i] = temp;
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
