package array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * given an array A of n elements. for indexes j , i such that j>i maximize( j �C
 * i ) such that A[j   ] �C A [ i ]> 0 does O(n) algo exist for this
 * 
 * test case: 6,3,2,5,0,4,1 leftToRight 6,3,2,0 RightToLeft 1,4,5,6
 * ����Ҫ��˼���Ǳȹ��˵ľͲ�Ҫ�ٱ��ˡ�
 * ��һ�αȽϵ���0 �� 1 
 * �����2
 * ��һ�αȽϵ��� 2 �� 1�� ��Ϊ1����һ����0֮��ľ���϶�����
 * 2��1 ����������
 * ��ô��Ҫ��1
 * �����2��4
 * �����3
 * ��һ�αȽϵ���3��4
 * �����4
 * ��һ�αȽϵ���6��4
 * ���� 
 * �Դ�����  
 * 
 * @author shen
 * 
 */
public class Find_Max {

	public static int[] findMax(int[] A) {

		assert (A != null);
		int left = 0;
		int right = 0;

		Stack<Integer> leftToRright = new Stack<>();
		Queue<Integer> rightToLeft = new LinkedList<>();

		leftToRright.push(0);
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[leftToRright.peek()])
				leftToRright.push(i);
		}

		rightToLeft.add(A.length - 1);
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] > A[rightToLeft.peek()])
				rightToLeft.add(i);
		}

		int i = 0;
		int j = A.length - 1;

		while ((!rightToLeft.isEmpty()) && (!leftToRright.isEmpty())) {
			if (A[rightToLeft.peek()] > A[leftToRright.peek()]) {
				if (rightToLeft.peek() - leftToRright.peek() > (right - left)) {
					right = rightToLeft.peek();
					left = leftToRright.peek();
				}
				leftToRright.pop();
			} else {
				rightToLeft.poll();
			}
		}

		int[] result = new int[2];
		result[0] = left;
		result[1] = right;
		return result;

	}

	public static void main(String[] args) {
		int[] array = new int[] { 6, 3, 2, 5, 0, 4, 1 };
		int[] result = findMax(array);
		System.out.println(result[0] + " " + result[1]);
	}
}