package binaryTrees;

public class BalancedTreeResponse {
	
	boolean isBalanced;
	int height;
	
	public BalancedTreeResponse(boolean isBalanced, int height) {
		this.height = height;
		this.isBalanced = isBalanced;
	}
}
