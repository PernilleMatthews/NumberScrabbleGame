/*
* Description -- Class for creating a board for the Game
* Includes: Current position on board, methods for sum of rows/cols/diagonals,
* methods for checking if player has won or draw, methods to update board.
*/

public class Board {     
    public Cell[][] grid; 
    public boolean draw;
    public boolean gameIsFinished; 
    private char[][] charArray = new char[3][3];

    /**
     * Constructor that creates an empty board.
     */
    public Board() {
        gameIsFinished = false;
        draw = false;
        createNewBoard(); 
    }

    /**
     * Creates a new 3x3 empty board 
     */
    private void createNewBoard() { 
        this.grid = new Cell[3][3];
   
        // Create board with cells and the letters from the charArray
        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {
               this.grid[i][j] = new Cell(mapLetter(i * 3 + j));
            }
        }
    }
    
    /**
     * Returns if number has already been used or not. 
     */
    public boolean isNumberUsed(int value) {
        boolean isCellValueEqual = false;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) { 
                if (grid[i][j].value() == value) {
                    isCellValueEqual = true;
                }
            }
        }
        return isCellValueEqual;
    }
    
    /**
     * Auxiliary method that makes a move according to player's input
     */
    public void move(int row, int column, int value) {  
        grid[row][column].setValue(value);
    }
    
    /**
     * Checks whether a given cell is free.<br>
     * <b>Precondition:</b> 1&le;cell&le;9.
     * @param cell the number of the cell
     * @return true if the cell is currently unoccupied
     */
    public boolean isCellFree(int row, int column) {
        return (grid[row][column].isEmpty());
    }

    /**
     * Return letter based on index on board
     */
    private String mapLetter(int index) {
        int asciiValue = 65 + index;               
        return ""+(char)asciiValue;
    } 

    /**
     * Returns a textual representation of this board.
     * @return a textual representation of this board
     */
    public String toString() {        
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result = result + "  "+grid[i][j].toString()+"  ";
                if (j < 2)
                    result = result + "|";
                else
                    result = result + "\n";
            }
            if (i < 2)
                result = result + "-----+-----+-----\n";
        }
        return result;
    }   

    /**
    * Sum diagonals to check for sum of 15
    */
    private int sumDiagonals() {
        int sumLeftDiagonal = 0;
        int sumRightDiagonal = 0;
        int counter = 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                // Add value to left diagonal sum
                if((grid[i][j].isEmpty() == false) && (i==j)) {
                    sumLeftDiagonal = sumLeftDiagonal + grid[i][j].value();
                }

                // Add value to right diagonal sum
                if((grid[i][j].isEmpty() == false) && (i + j) == (3 - 1)) {
                    sumRightDiagonal = sumRightDiagonal + grid[i][j].value();
                }   
            }
        }        
        return ((sumLeftDiagonal == 15 || sumRightDiagonal == 15) ? 15 : 0);
    }

    // ISSUE WITH DIAGONALS! If e.g., 9+6, then the game ends regardless if all three cells are filled out or not. 
    // EXACTLY THREE NUMBERS MUST ADD UP TO 15, not just two.

    /**
     * Sum rows to check for sum of 15
     * This method is super messy, need to rethink how to exit loop if 15 = true.
     */
    private int sumRows() {
        int sumRow = 0;
        boolean winFound = false;
        for(int i = 0; i < 3; i++) {
                sumRow = 0;              
            for(int j = 0; j < 3; j++) { 
                if(grid[i][j].isEmpty() == false) {
                    sumRow = sumRow + grid[i][j].value();

                    if(sumRow == 15) {
                        winFound = true;
                    }   
                } 
            }
        }
        return (winFound ? 15 : 0);
    }

    /**
     * Sum columns to check for sum of 15
     * This method and the sumRows can be together, but would that be messy?
     * Keep them separate for now, seems much cleaner, consider remaking these two.
     */
    private int sumColumns() {
        int sumCol = 0;
        boolean winFound = false;
        for(int i = 0; i < 3; i++) {
                sumCol = 0;              
            for(int j = 0; j < 3; j++) { 
                if(grid[j][i].isEmpty() == false) {
                    sumCol = sumCol + grid[j][i].value();

                    if(sumCol == 15) {
                        winFound = true;
                    }   
                }  
            }
        }
        return (winFound ? 15 : 0);
    }

    /**
     * Check for win or draw
     */
    public void checkBoardState() {
        draw();
        winningConditions();
    }
 
    /**
     * Check if game is a draw
     */
    private void draw() {
        int countEmpty = 0;
        for(int i = 0; i < 3; i++) {            
            for(int j = 0; j < 3; j++) {
                if((grid[i][j].isEmpty() == false) && !gameIsFinished) {
                    countEmpty++;

                    if(countEmpty == 9) {  
                              
                        gameIsFinished = true;
                        draw = true;
                    }
                }        
            }
        }
    } 

    /*
    * Check winning conditions
    */
    private void winningConditions() {
        if(sumDiagonals() == 15 || sumRows() == 15 || sumColumns() == 15) {            
            gameIsFinished = true;
        }
    }
}