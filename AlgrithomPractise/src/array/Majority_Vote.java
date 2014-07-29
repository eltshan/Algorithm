package array;

public class Majority_Vote {

	/**
	 * This alg assumes that there exist majority element. Otherwise need to
	 * validate it.
	 * 
	 * @param input
	 * @return
	 */
	public static char majorityVote(char[] input) {
		char e = ' ';
		int counter = 0;

		for (char c : input) {
			if (counter++ == 0)
				e = c;
			else {
				if (c == e)
					counter++;
				else {
					counter--;
				}
			}
		}

		return e;
	}

	public static void main(String[] args) {

		System.out.println(majorityVote(new char[] { 'a', 'b', 'a', 'c' }));
	}
}
