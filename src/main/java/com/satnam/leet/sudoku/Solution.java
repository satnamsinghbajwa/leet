package com.satnam.leet.sudoku;

class Solution {
	public boolean isValidSudoku(char[][] board) {

		if (doBasicValidation(board) || validateGrid(board))
            return false;
		return true;
	}

	private boolean doBasicValidation(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return true;
		return false;
	}

		private boolean validateGrid( char[][] board){

		for (int j = 0; j < 9; j++) {
			boolean[] rows = new boolean[9];
			boolean[] columns = new boolean[9];
			boolean[] boxes = new boolean[9];

			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (rows[board[i][j] - '1']) {
						//duplicate value
						return true;
					}
					rows[(board[i][j] - '1')] = true;
				}

				if (board[j][i] != '.') {
					if (columns[board[j][i] - '1']) {
						//duplicate value
						return true;
					}
					columns[board[j][i] - '1'] = true;
				}
			}

			for (int i = j / 3 * 3; i < j / 3 * 3 + 3; i++) {
				for (int k = j % 3 * 3; k < j % 3 * 3 + 3; k++) {
					if (board[i][k] != '.') {
						if (boxes[(int) (board[i][k] - '1')]) {
							//duplicate value
							return true;
						}
						boxes[(int) (board[i][k] - '1')] = true;
					}
				}
			}
		}
		return false;
	}

}
