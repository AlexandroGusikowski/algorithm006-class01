//˫ָ�룬������ �ڱ�
class Solution {
public:
	ListNode * mergeTwoLists(ListNode* l1, ListNode* l2) {

		ListNode* pHead = new ListNode(-1);
		ListNode* l3 = pHead;
		//������һ����
		while (l1 != NULL && l2 != NULL) {
			if (l1->val < l2->val) {
				l3->next = l1;
				l1 = l1->next;
			}
			else {
				l3->next = l2;
				l2 = l2->next;
			}
			l3 = l3->next;
		}

		//�ϲ�
		l1 == NULL ? l3->next = l2 : l3->next = l1;
		return pHead->next;

	}
};