/*
 * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 * any placement of queens which do not attack each other.
 *
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 */
class Position
{
	int row, col;
	public Position(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
}
public class NQueenProblem {
	
	void solveNQueen(int n)	//row = n, col = n : n x n matrix
	{
		Position[] pos = new Position[n];
		if(solveNQueenUtil(n, 0, pos))
		{
			for(int i = 0; i < n; i++)
				System.out.println(pos[i].row + ", " + pos[i].col);
		}
		else
			System.out.println("No Solution found");		
	}
	
	boolean solveNQueenUtil(int n, int row, Position[] pos)
	{
		//base
		if(n == row)
			return true;
		
		int col;
		for(col = 0; col < n; col++)
		{
			boolean posFound = true;
			
			//check for attack
			for(int queen = 0; queen < row; queen++)
			{
				//same column + both diagonals
				if(pos[queen].col == col || pos[queen].row - pos[queen].col == row - col || pos[queen].row + pos[queen].col == row + col)
				{
					posFound = false;
					break;
				}
			}
			if(posFound)
			{
				//store pos, recurse & return
				pos[row] = new Position(row, col);
				if(solveNQueenUtil(n, row + 1, pos))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NQueenProblem s = new NQueenProblem();
        s.solveNQueen(7);
	}

}
