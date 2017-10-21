#include <stdio.h>
#include <stdlib.h>

struct tagNode
{
	float coef;                            //系数 
	int exp;                               //指数 
	struct tagNode *next;
};

typedef struct tagNode Node;
typedef struct tagNode*  pNode;

pNode pa_head = (pNode) malloc(sizeof(Node));
pNode pa_tail = (pNode) malloc(sizeof(Node));
pNode pb_head = (pNode) malloc(sizeof(Node));
pNode pb_tail = (pNode) malloc(sizeof(Node));
pNode pc_head = (pNode) malloc(sizeof(Node));
pNode pc_tail = (pNode) malloc(sizeof(Node));
pNode pd_head = (pNode) malloc(sizeof(Node));
pNode pd_tail = (pNode) malloc(sizeof(Node));




void insert(float coef_t, int exp_t, pNode head)
{
	pNode temp = (pNode) malloc(sizeof(Node));
	
	temp -> coef = coef_t;
	temp -> exp = exp_t;
	
	temp -> next = head -> next;
	head -> next = temp;
}


void outputList(pNode head, pNode tail)
{
	pNode temp;
	
	temp = head -> next;
	
	while (temp != tail)
	{
		if (temp -> coef != 0)
		{
			printf("%.1fX^%d  +  ", temp -> coef, temp -> exp);
			
		}
		
		temp = temp -> next;
		
	}
	
	putchar('\b');
	putchar('\b');
	putchar('\b');
	putchar('\b');
	putchar(' ');
	putchar(' ');
	putchar(' ');
	putchar(' ');
	
	printf("\n");
}

void plusList()
{
	pNode temp_a;
	pNode temp_b;
	pNode temp_c;
	int t = 0;
	
	temp_a = pa_head -> next;
	temp_c = pc_head -> next;
	temp_b = pb_head -> next;
	
	while (temp_a != pa_tail)
	{
		while (temp_b != pb_tail)
		{
			
			if (temp_b -> exp == temp_a -> exp)
			{
				insert(temp_a -> coef + temp_b -> coef, temp_a -> exp, pc_head);
			}
			
			
			
			temp_b = temp_b -> next;
		}
		temp_b = pb_head -> next;
		temp_a = temp_a -> next;
	}
//	outputList(pc_head, pc_tail);
	
	temp_a = pa_head -> next;
	temp_c = pc_head -> next;
	temp_b = pb_head -> next;
	
	
	while (temp_b != pb_tail)
	{
		
		
		while (temp_c != pc_tail)
		{
			if (temp_b -> exp == temp_c -> exp)
			{
				t = 1;
				
			}
			
			
			
			
			
			
			temp_c = temp_c -> next;
			
		}
		if (t == 0)
		{
			insert(temp_b -> coef, temp_b -> exp, pc_head);
		}
		
		
		t = 0;
		temp_c = pc_head -> next;
		
		temp_b = temp_b -> next;
	}
	
	

	temp_a = pa_head -> next;
	temp_c = pc_head -> next;
	temp_b = pb_head -> next;

	while (temp_a != pa_tail)
	{
		
		
		
		while (temp_c != pc_tail)
		{
			if (temp_a -> exp == temp_c -> exp)
			{
				t = 1;
				
			}
			
			
			
			
			
			
			temp_c = temp_c -> next;
			
		}
		if (t == 0)
		{
			insert(temp_a -> coef, temp_a -> exp, pc_head);
		}
		
		
		t = 0;
		temp_c = pc_head -> next;
		temp_a = temp_a -> next;
		
		
	}
	
	
}

void minusList()
{
	pNode temp_a;
	pNode temp_b;
	pNode temp_d;
	int t = 0;
	
	temp_a = pa_head -> next;
	temp_d = pd_head -> next;
	temp_b = pb_head -> next;
	
	while (temp_a != pa_tail)
	{
		while (temp_b != pb_tail)
		{
			
			if (temp_b -> exp == temp_a -> exp)
			{
				insert(temp_a -> coef - temp_b -> coef, temp_a -> exp, pd_head);
			}
			
			
			
			temp_b = temp_b -> next;
		}
		temp_b = pb_head -> next;
		temp_a = temp_a -> next;
	}
//	outputList(pc_head, pc_tail);
	
	temp_a = pa_head -> next;
	temp_d = pd_head -> next;
	temp_b = pb_head -> next;
	
	
	while (temp_b != pb_tail)
	{
		
		
		while (temp_d != pd_tail)
		{
			if (temp_b -> exp == temp_d -> exp)
			{
				t = 1;
				
			}
			
			
			
			
			
			
			temp_d = temp_d -> next;
			
		}
		if (t == 0)
		{
			insert(0 - temp_b -> coef, temp_b -> exp, pd_head);
		}
		
		
		t = 0;
		temp_d = pd_head -> next;
		
		temp_b = temp_b -> next;
	}
	
	

	temp_a = pa_head -> next;
	temp_d = pd_head -> next;
	temp_b = pb_head -> next;

	while (temp_a != pa_tail)
	{
		
		
		
		while (temp_d != pd_tail)
		{
			if (temp_a -> exp == temp_d -> exp)
			{
				t = 1;
				
			}
			
			
			
			
			
			
			temp_d = temp_d -> next;
			
		}
		if (t == 0)
		{
			insert(temp_a -> coef, temp_a -> exp, pd_head);
		}
		
		
		t = 0;
		temp_d = pd_head -> next;
		temp_a = temp_a -> next;
		
		
	}
	
	
}

int main(void)
{
	float coef_t;
	int exp_t;
	int i;
	
	
	{
		pa_head -> next = pa_tail;
		pb_head -> next = pb_tail;
		pc_head -> next = pc_tail;
		pd_head -> next = pd_tail;
	}
	
	
	i = 0;
	printf("正在输入A式:\n");
	
	printf("(输入'0'退出输入)请输入 第%d项 的系数：", i + 1);
	scanf("%f", &coef_t);
	while (coef_t != 0)
	{
		printf("\t\t 请输入 第%d项 的指数：", i + 1);
		scanf("%d", &exp_t);
		
		i++;
		
		insert(coef_t, exp_t, pa_head);
			
		printf("(输入'0'退出输入)请输入 第%d项 的系数：", i + 1);
		scanf("%f", &coef_t);
	}
	printf("\nA式为："); 
	outputList(pa_head, pa_tail);
	
	
	printf("\n---------------------------------------------------------\n");
	
	i = 0;
	printf("正在输入B式:\n");

	printf("(输入'0'退出输入)请输入 第%d项 的系数：", i + 1);
	scanf("%f", &coef_t);
	while (coef_t != 0)
	{
		printf("\t\t 请输入 第%d项 的指数：", i + 1);
		scanf("%d", &exp_t);
		
		i++;
		
		insert(coef_t, exp_t, pb_head);
			
		printf("(输入'0'退出输入)请输入 第%d项 的系数：", i + 1);
		scanf("%f", &coef_t);
	}
	printf("\nB式为："); 
	outputList(pb_head, pb_tail);
	
	
	printf("\n---------------------------------------------------------\n");
	
	printf("Plus:\n");
	plusList();
	outputList(pc_head, pc_tail);
	
	printf("\n\n");
	
	printf("Minus:\n");
	minusList();
	outputList(pd_head, pd_tail);
	
	
	return 0;
}
					    
