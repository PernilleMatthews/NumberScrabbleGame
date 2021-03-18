import java.util.Arrays;
/**
 * Class description. This class holds the state of the game and....
 */

public class NumberScrabble {
    /**
     * Class attributes.
     */
    private int moves;
    private char[][] board;
    private char[] charArray = new char[9];

    /**
     * Constructor that creates an empty board.
     */
    public NumberScrabble() {
        board = new char[3][3];
        createCharArray();        

        // Creat board with the letters from the charArray
        int tracker = 0;
        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {
                board[i][j] = this.charArray[tracker];
                tracker++;
            }
        }
        System.out.println(Arrays.deepToString(board));    

        // Initialise moves
        moves = 0;        
    }

    /*
     * Create letter array and insert A-I into array
     */
    public void createCharArray() {
        int i = 0;
        int letter = 65;
        while (i < charArray.length){
            charArray[i] = (char)letter;
            i++;
            letter++;
            
        }
    }

    /**
     * Checks if a given cell is free.
     * <b>Precondition:</b> 1&le;cell&le;9.
     * @param   cell   the number of the cell
     * @return         true if the cell is currently unoccupied
     
    public boolean isFree(int cell) {
        return true;
    }
    */

    /*
    * Method to check if board is full is available (isFull?)
    */


    /**
     * Returns the char of the player whose turn it is.
     * @return the char of the next player
     Should be in Player?
    public String nextPlayer() {
        return ((moves%2 == 0) ? player1 : player2);
    }*/

    /*
    * play the move given by player - no idea how to do this. 
    * Update state?
    */

    /*
    * Who has won? Check who the winner is (hasWon)
    */

    /*
    * Some kind of visualisation of the board to the terminal
    * to String?

    */
    /*
     * Auxiliary method for printing a cell.
    */
    private String cellToString(int row, int col, int count) {
        // If board cell is not empty, print x other print below
   
        return " "+board[row][col]+count+" ";
    }

    
    
    /**
     * Returns a textual representation of this board.
     * @return a textual representation of this board
     */
    public String toString() {
        String result = "";
        int count = 1;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {

                result = result + cellToString(i,j, count);
                count++;
                if (j<2)
                    result = result + "|";
                else
                    result = result + "\n";
            }
            if (i<2)
                result = result + "---+---+---\n";
        }
        return result;
    }


    /**
    * Something to check for computer turn and take the move?
    * To start with probably randomly selected free cell and
    * random free number
     */

     /*
    * Something to print the "available numbers" to the users
    * will help them stay on top of their choices.
    */


    
    
}
