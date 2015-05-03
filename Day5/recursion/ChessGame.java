/*
 * row: 1; column: 0
row: 3; column: 1
row: 5; column: 2
row: 2; column: 3
row: 4; column: 4
row: 4; column: 5  // wrong; two rows on the same column
row: 6; column: 6
row: 4; column: 7
 */


import java.lang.Math;

public class ChessGame {

	public static void main(String[] args) {
		Queen nb = null;
		for (int i = 0; i<8; i++) {
			Queen lastQueen = new Queen(i, nb);
			if (!lastQueen.findSolution()) {System.out.println("No solution") ; break;}
			lastQueen.print();
			nb = lastQueen;
		}	
		
	}
	
	public static class Queen {
		int row;
		int col;
		Queen neighbor;
		
		Queen(int column, Queen n) {
			col = column;
			neighbor = n;
			row = 1;
					
		}
		
		
		/*
		 * Check with all the neighbors on the left, too see if any attack occurs;
		 */
		public boolean canAttack (int testRow, int testColumn) {
			if ( (testRow == row) || (Math.abs(testColumn - col) == Math.abs(testRow - row))) {
				return true;
			} else {
				if (neighbor != null){
					return neighbor.canAttack(testRow, testColumn);
				} else {
					return false;
				}
			}
		}
		
		/*
		 * Check every neight on the right to see if Attack happens
		 * if there is an attack, advance the row forward; if reach the bottom of the row, findSolution return false
		 * if no attacked, the solution has been found;
		 */
		public boolean findSolution() {
			while (neighbor != null && neighbor.canAttack(row, col) ){
				if (!canAdvance()) return false;
			}
			return true;
		}
		
		/*
		 * Advance the row by one, and run findSolution again'
		 * If row is already reach the bottom, going back to see if the neighbor(if not null) can advance to find the solution
		 */
		public boolean canAdvance() {
			if (row < 8) {
				row++; 
				return findSolution();
			} else {
				if (neighbor!= null) {
					if (!neighbor.canAdvance()) {
						
						return false;
					} else {
						row = 1;
						return findSolution();
					}
				}
				return false;
			}
			
		}
		
		public void print() {
			System.out.println("row: " + row + "; column: " + col);
		}
		
	}
		
}
