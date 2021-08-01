public class NQueenProblem {
    private final int N = 4;
    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        nQueenProblem.solveNQueen();
    }

    /* This function solves the N Queen problem using Backtracking.  It mainly uses solveNQUtil () to
       solve the problem. It returns false if queens cannot be placed, otherwise, return true and
       prints placement of queens in the form of 1s. Please note that there may be more than one
       solutions, this function prints one of the feasible solutions.*/
    private void solveNQueen(){
        int[][] board = {{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        if (solveNQueenUtil(board, 0)){
            printSolution(board);
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }

    /* A recursive utility function to solve N Queen problem */
    private boolean solveNQueenUtil(int[][] board, int col){
        /* base case: If all queens are placed then return true */
        if (col >= N) return true;

        /* Consider this column and try placing this queen in all rows one by one */
        for (int i=0; i<N; i++){
            /* Check if the queen can be placed on board[i][col] */
            if (isSafeBoard(board, i, col)){
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQueenUtil(board, col+1))
                    return true;

                /* If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col] */
                board[i][col] = 0; // backtrack
            }
        }
        /* If the queen can not be placed in any row in this column col, then return false */
        return false;
    }

    /* A utility function to check if a queen can be placed on board[row][col]. Note that this
       function is called when "col" queens are already placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    private boolean isSafeBoard(int[][] board, int row, int col){
        /* Check this row on left side */
        for (int i=0; i< col; i++){
            if (board[row][i] == 1) return false;
        }

        /* Check upper diagonal on left side */
        for (int i= row, j=col; i>=0 && j>=0; i--,j--){
            if (board[i][j] == 1) return false;
        }

        /* Check lower diagonal on left side */
        for (int i=row, j=col; i<N && j>=0; i++,j--){
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private void printSolution(int[][] board){
        for (int i=0; i< N; i++){
            for (int j=0; j<N; j++ ){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
