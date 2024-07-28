package linkedlist;

public class LinkedListUse {

	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		return n1;
	}

	public static void printLinkedList(Node<Integer> n) {

		Node<Integer> head = n;

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> n = createLinkedList();
		printLinkedList(n);

	}

}
