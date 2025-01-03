package binaryTrees;

import java.util.Scanner;

public class BinaryTreeUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, false, 0);
		printBinaryTree(root);
//		System.out.println("Node number: " + numNodes(root));
//		System.out.println("Node sum: " + sumNodes(root));
//		System.out.println("Largest node data: " + largestNode(root));
//		
//		System.out.println("Nodes greater than 3 :" + countGreaterThanX(root, 3));
//		System.out.println("Height of tree:" + heightOfTree(root));
//		System.out.println("Number of leaves: " + numberOfLeaf(root));
//		replaceNodeWithDepth(root, 0);
//		mirrorBinaryTree(root);
//		printBinaryTree(root);
		System.out.println("is balanced: " + isBalancedBetter(root).isBalanced);
		System.out.println("diameter: " + diameterOfTree(root));

	}

	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, boolean isLeft, int parentData) {
		if (isRoot) {
			System.out.println("Enter data for root node:");
		} else {
			if (isLeft)
				System.out.println("Enter data for left child of " + parentData);
			else
				System.out.println("Enter data for right child of " + parentData);
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if (rootData == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> left = takeTreeInputBetter(false, true, rootData);
		BinaryTreeNode<Integer> right = takeTreeInputBetter(false, false, rootData);
		root.left = left;
		root.right = right;

		return root;
	}

	public static BinaryTreeNode<Integer> takeTreeInput() {
		System.out.println("Enter data for root node:");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if (rootData == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> left = takeTreeInput();
		BinaryTreeNode<Integer> right = takeTreeInput();
		root.left = left;
		root.right = right;

		return root;
	}

	public static void printBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		System.out.print(root.data + ":");
		if (root.left != null)
			System.out.print(root.left.data + " ");
		if (root.right != null)
			System.out.print(root.right.data);

		System.out.println();

		printBinaryTree(root.left);
		printBinaryTree(root.right);

	}

	public static void postOrderPrint(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		postOrderPrint(root.left);
		postOrderPrint(root.right);

		System.out.println("Root data" + root.data);
	}

	public static int numNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		int leftNodeCount = numNodes(root.left);
		int rightNodeCount = numNodes(root.right);
		return leftNodeCount + rightNodeCount + 1;
	}

	public static int sumNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		return sumNodes(root.right) + sumNodes(root.left) + root.data;
	}

	public static int largestNode(BinaryTreeNode<Integer> root) {
		if (root == null)
			return -1;

		int rightLargest = largestNode(root.right);
		int leftLargest = largestNode(root.left);

		return Math.max(root.data, Math.max(rightLargest, leftLargest));

	}

	public static int countGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if (root == null)
			return 0;

		int count = (root.data > x) ? 1 : 0;
		if (root.left != null) {
			count += countGreaterThanX(root.left, x);
		}

		if (root.right != null) {
			count += countGreaterThanX(root.right, x);
		}

		return count;

	}

	public static int heightOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int numberOfLeaf(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		return numberOfLeaf(root.right) + numberOfLeaf(root.left);
	}

	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		printAtDepthK(root.left, k - 1);
		printAtDepthK(root.right, k - 1);
	}

	public static void replaceNodeWithDepth(BinaryTreeNode<Integer> root, int level) {
		if (root == null)
			return;

		root.data = level;
		replaceNodeWithDepth(root.right, level + 1);
		replaceNodeWithDepth(root.left, level + 1);
	}

	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return null;

		root.left = removeLeafNodes(root.left);
		root.right = removeLeafNodes(root.right);

		return root;

	}

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		
		BinaryTreeNode<Integer> tempLeft = root.left;
		root.left = root.right;
		root.right = tempLeft;
		
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) return true;
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		
		if(Math.abs(rightHeight - leftHeight) > 1) return false;
		
		boolean isLeftBanlanced = isBalanced(root.left);
		boolean isRightBanlanced = isBalanced(root.right);
		
		return isLeftBanlanced && isRightBanlanced;
	}

	public static BalancedTreeResponse isBalancedBetter(BinaryTreeNode<Integer> root) {
		BalancedTreeResponse ans = new BalancedTreeResponse(true, 0);
		if(root == null)return ans;
		
		BalancedTreeResponse leftReponse = isBalancedBetter(root.left);
		BalancedTreeResponse rightReponse = isBalancedBetter(root.right);
		
		int height = Math.max(leftReponse.height, rightReponse.height) +1;
		ans.height = height;
		
		if (Math.abs(leftReponse.height - rightReponse.height) > 1 || !leftReponse.isBalanced || !rightReponse.isBalanced) {
		    ans.isBalanced = false;
		}
		
		return ans;
	}

	public static int diameterOfTree(BinaryTreeNode<Integer> root) {
		return diameterOfTreeHelper(root).diameter;
	}

	public static DiameterPair diameterOfTreeHelper(BinaryTreeNode<Integer> root) {
		DiameterPair pair = new DiameterPair(0, 0);
		if(root == null) {
			return pair;
		}
		
		DiameterPair leftPair = diameterOfTreeHelper(root.left);
		DiameterPair rightPair = diameterOfTreeHelper(root.right);
		
		int height = 1+Math.max(leftPair.height, rightPair.height);
		int dist = leftPair.height + rightPair.height +1;
		int diameter = Math.max(dist, Math.max(rightPair.diameter,rightPair.diameter ));
		
		return new DiameterPair(height, diameter);
	}
}