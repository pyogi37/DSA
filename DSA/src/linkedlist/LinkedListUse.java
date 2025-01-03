package linkedlist;

import java.util.Scanner;

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

	public static Node<Integer> takeInput() {

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();

		Node<Integer> head = null;
		Node<Integer> tail = null;

		while (data != -1) {
			Node<Integer> currNode = new Node<Integer>(data);
			if (head == null) {
				head = currNode;
				tail = currNode;
			} else {
				tail.next = currNode;
				tail = tail.next;
			}
			
			data = s.nextInt();
		}
		s.close();
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Node<Integer> n = createLinkedList();
		Node<Integer> n = takeInput();
		printLinkedList(n);

	}

}
