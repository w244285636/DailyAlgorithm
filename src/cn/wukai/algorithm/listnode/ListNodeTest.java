package cn.wukai.algorithm.listnode;

public class ListNodeTest {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		ListNode s1 = new ListNode(1);
		ListNode s2 = new ListNode(1);
		ListNode s3 = new ListNode(2);
		ListNode s4 = new ListNode(3);
		ListNode s5 = new ListNode(3);
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = s5;
		
		ListNode list = RotateList.solution(a1,2);
		
		//ListNode list = ReverseLinkedListII.solution(l1, 2,4);
		//ListNode list = AddTwoNumbers.solution(l1, a1);
		
		//ListNode list = OddEvenLinkedList.solution(l1);
		while(null != list) {
			System.out.println(list.val);
			list = list.next;
		}
	}
	
}
