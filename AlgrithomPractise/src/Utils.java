public class Utils {
	public static void swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}
	
	public static void main(String args[]){
		int [] num = new int[]{1,2};
		swap(num,0,1);
		for(int x: num){
			System.out.println(x);
		}
	}
}
