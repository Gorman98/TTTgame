package ser210.quinnipiac.edu.tictactoe;

import ser210.quinnipiac.edu.tictactoe.ITicTacToe;

public class TicTacToe implements ITicTacToe {

    // The game board and the game status
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[] board = new int[ROWS*COLS]; // game board in 1D array
    /**
     * clear board and set current player
     */
    public TicTacToe(){

    }

    //clears the board
    @Override
    public void clearBoard() {
        for (int i = 0; i < 9; i++){
            board[i] = 0;
        }
    }

    //sets the move
    @Override
    public void setMove(int player, int location) {
        board[location] = player;
    }

    //generates a computer move
    @Override
    public int getComputerMove() {
        //gets the computers move by checking the first square and trying to put a naught there
        //then checking the next one if it is filled
        if(board[0] == 0) {
            return 0;
        } else if(board[1] == 0) {
            return 1;
        } else if(board[2] == 0) {
            return 2;
        } else if(board[3] == 0) {
            return 3;
        } else if(board[4] == 0) {
            return 4;
        } else if(board[5] == 0) {
            return 5;
        } else if(board[6] == 0) {
            return 6;
        } else if(board[7] == 0) {
            return 7;
        } else {
            return 8;
        }
    }

    @Override
    public int checkForWinner() {
        if(checkWin(CROSS, board)) {
            return CROSS_WON;
        } else if(checkWin(NOUGHT, board)){
            return NOUGHT_WON;
        } else if(!(board[0] == 0 || board[1] == 0 || board[2] == 0
                || board[3] == 0 || board[4] == 0 || board[5] == 0
                || board[6] == 0 || board[7] == 0 || board[8] == 0)) {
            return TIE;
        }else {
            return 0;
        }
    }

    //check to see if the win condition was meet
    public boolean checkWin(int player, int[] board) {
        if(board[0] == player && board[1] == player && board[2] == player ||
                board[3] == player && board[4] == player && board[5] == player ||
                board[8] == player && board[6] == player && board[7] == player ||
                board[0] == player && board[3] == player && board[6] == player ||
                board[1] == player && board[4] == player && board[7] == player ||
                board[2] == player && board[5] == player && board[8] == player ||
                board[0] == player && board[4] == player && board[8] == player ||
                board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }
        else return false;
    }

    /**
     *  Print the game board
     */
    public  void printBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[col + (row*3)]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }

    /**
     * Print a cell with the specified "content"
     * @param content either CROSS, NOUGHT or EMPTY
     */
    public  void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case NOUGHT: System.out.print(" O "); break;
            case CROSS:  System.out.print(" X "); break;
        }
    }

    //checks if the cell is empty
    public boolean isEmpty(int loc) {
        if(board[loc] == 0) {
            return true;
        } else
            return false;
    }
    //checks what is in the cell at location i
    public int getCell (int i){
        return board[i];
    }
}
