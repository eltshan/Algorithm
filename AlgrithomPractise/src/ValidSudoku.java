public class ValidSudoku {
	static public boolean isValidSudoku(char[][] board) {
		return isValidHelper(board, 0, 0);
	}

	private static boolean isValidHelper(char[][] board, int r, int c) {

		int i = 0;
		int j = 0;

		for (i = r; i < 9; i++) {
			if (board[i][j] < '1' || board[i][j] > '9')
				break;
			for (j = c; j < 9; j++) {
				if (board[i][j] < '1' || board[i][j] > '9')
					break;
			}
		}
		if (i == 9)
			return true;

		for (int k = 0; k < 9; k++) {
			board[i][j] = (char) (k + '1');
			if (isValidSmall(board, i, j) && isValidHelper(board, i, j + 1))
				return true;
			board[i][j] = '.';
		}

		return false;

	}

	private static boolean isValidSmall(char[][] board, int r, int c) {
		for (int i = 0; i < r; i++) {
			if (board[i][c] == board[r][c])
				return false;
		}
		for (int j = 0; j < c; j++) {
			if (board[r][j] == board[r][c])
				return false;
		}
		for (int i = r % 3; i < r % 3 + 3; i++) {
			for (int j = c % 3; j < c % 3 + 3; j++) {
				if (board[i][j] == board[r][c])
					return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		char[][] chars = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				chars[i][j] = '.';
			}
		}
		// ["..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."
		chars[0][2] = '4';
		chars[0][6] = '6';
		chars[0][7] = '3';
		chars[2][0] = '5';
		chars[2][7] = '9';
		isValidSudoku(chars);

	}
}
