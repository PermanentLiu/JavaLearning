/*
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，
并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
 
 
/*
思路：题目中已知，位数按照从小到大来排序
所以直接从两个链表的第一个元素相加即可，此时要注意进位

*/
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);//新建一个链表，第一个元素为0，dummyHead为头指针
        ListNode curr = dummyHead;//curr也指向头
        ListNode p = l1;//p是l1的头指针
        ListNode q = l2;//q是l2的头指针
        int carry = 0;//carry代表进位
        
        while (p != null || q != null){
            int x = 0;
            int y = 0;//x，y为l1，l2当前节点的值
            int sum = 0;
            
            if (p != null){//如果当前节点不为空，则把当前节点的值赋给x
                x = p.val;
            }
            else{//如果当前节点为空，则意味着当前链表已经遍历完，没有多余元素，则赋0
                x = 0;
            }
            if (q != null){//同上
                y = q.val;
            }
            else{
                y = 0;
            }
            
            sum = carry + x + y;//sum = 进位 + l1当前值 + l2当前值
            carry = sum / 10;//如果sum大于10，则需要进位
            
            curr.next = new ListNode(sum % 10);//只在新链表中添加sum中个位的值（如果需要进位的话）
            curr = curr.next;//新链表中当前节点往下继续移动
            
            if (p != null){//如果l1没有遍历完，接着遍历
                p = p.next;
            }
            if (q != null){//同上
                q = q.next;
            }
        }
        if (carry > 0){//如果l1，l2两个链表都遍历完了，但是还存在进位
            curr.next = new ListNode(carry);//新建一个节点，把进位赋给最高位（新建一个最高位，赋1）
        }
        return dummyHead.next;
    }
}