package commonDataStructures;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int a) {
		val = a;
		next = null;
	}

	private static ListNode reverse(ListNode p) {
		ListNode preHead = new ListNode(-1);
		ListNode tmp;
		while(p!=null) {
			tmp = p.next;
			p.next = preHead.next;
			preHead.next = p;
			p = tmp;
		}

		return preHead.next;
	}

	private static ListNode findHeadofSecondHalf(ListNode preHead) {
		ListNode slow = preHead;
		ListNode fast = preHead;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
			if (fast == null)
				break;
			fast = fast.next;
		}
		return slow;
	}

	static public void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode aaa = findHeadofSecondHalf(preHead);
		
		ListNode h2 = reverse(aaa.next);
		aaa.next = null;
		ListNode first = head;
		ListNode second = h2;
		ListNode p = preHead;

		for (int i = 0; p != null; i++) {
			if (first == null && second == null)
				break;
			else if (first != null && second != null) {
				p.next = first;
				first = first.next;
				p = p.next;
				p.next = second;
				second = second.next;
				p = p.next;
			} else if (first != null && second == null) {
				p.next = first;
				first = first.next;
				p = p.next;
				break;
			} else
				break;
		}
		
		for(ListNode x = head; x!=null; x = x.next){
			System.out.println(x.val);
		}
	}
	// reverse the node after p
}
