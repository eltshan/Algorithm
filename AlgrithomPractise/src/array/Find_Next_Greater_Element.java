package array;

import java.util.Stack;

/**
 * Find the next greater element for each element in an array Print out the next
 * greater elements
 * 
 * O(n)
 * 
 * @author shen
 * 
 */
public class Find_Next_Greater_Element {

	public static void findNextGreaterElement(int[] array) {
		int n = array.length;
		Stack<Integer> stack = new Stack<>();
		int i = n - 1;
		while (i >= 0)
			if (stack.isEmpty()) {
				System.out.println(array[i] + " " + "-1");
				stack.push(array[i--]);
			} else {
				if (stack.peek() > array[i]) {
					System.out.println(array[i] + " " + stack.peek());
					stack.push(array[i--]);
				} else
					stack.pop();

			}
	}

	public static void main(String args[]) {
		int[] array = new int[] { 4, 5, 2, 25, 20, 11, 13, 21, 3 };
		findNextGreaterElement(array);
	}
}
