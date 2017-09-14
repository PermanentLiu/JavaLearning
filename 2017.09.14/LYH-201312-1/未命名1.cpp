#include <stdio.h>



struct SeqList
{
	int MAX;
	int n; 
	int * element;
};

typedef struct SeqList PSeqList;





int main(void)
{
	(PSeqList *)palist_head = (PSeqList *)malloc(sizeof(PSeqList));
	scanf("%d", &palist_head -> MAX);
	int i = 1;
	(PSeqList *)palist_head = (PSeqList *)malloc(sizeof(PSeqList));
	
	
	for ( ; i <= PSeqList.MAX; i++)
	{
		(PSeqList *)palist = (PSeqList *)malloc(sizeof(PSeqList));
		scanf("%d ", palist -> element[i]);
		if (i == 0)
		{
			palist_head = palist;
		}
	}
	
	
	for (i = 1; i <= PSeqList.MAX; i++)
	{
		printf("%d ", palist_head -> element[i]);
	}
	
	
	
	return 0;
}
