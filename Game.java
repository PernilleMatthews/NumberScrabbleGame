import java.util.Arrays;
/**
 * Class description. This class holds the state of the game and....
 */

public class Game {
    /**
     * Class attributes.
     */
    public boolean gameIsFinished;  
    
    private char[][] charArray = new char[3][3];
    private Cell[] grid = new Cell[9]; // Is this needed?
    public Cell[][] board;
        
    private static boolean turn;  
    private InputManager input;
    private int row, column;

    /**
     * Constructor that creates an empty board.
     */
    public Game(InputManager inputManager) {
        this.input = inputManager;
        this.gameIsFinished = false;        
        createNewBoard();       
    }

    /**
     * Creates a new 3x3 empty board 
     */
    private void createNewBoard() {
        // Create a 1D array of new cells (CAn this be integrated in 2xfor?) 
        for(int i = 0; i < 9; i++) {
            grid[i] = new Cell();
        }
        createCharArray();        
        this.board = new Cell[3][3];

        // Create board with cells and the letters from the charArray
        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {
               this.board[i][j] = this.grid[i * 3 + j];
            }
        }    
    }

    /**
     * Create letter array and insert A-I into array
     */
    private void createCharArray() {
        int letter = 65;

        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {
                charArray[i][j] = (char)letter;
                letter++;
            }
        }
    }

    /**
     * Prompt player for their move. 
     */
    public void turn() {
        turn = true;

        //char index;
        while(turn) {                
            String position;
            String number;
            do {
                // Validate input
                String[] sArray = input.stringMoveInput("Where do you want to play?: "); 
                position = sArray[0];
                number = sArray[1];

                // Find board row & column of letter given by input
                String s = sArray[0];
                letterPosition(s.charAt(0)); // This sets row & columns values

                int value;
                value = Integer.parseInt(String.valueOf(sArray[1]));

                // Check conditions for input
                if (isNumberUsed(value)) {
                    System.out.println("That number has already been used.");
                } else if (!isCellFree()){
                    System.out.println("That cell is not available.");
                } else {
                    move(value);
                    checkBoardState();

                    // Change player - turn is over!
                    turn = false;
                }       
            } while (turn);
        } 
    }

    /**
     * Returns if number has already been used or not. 
     */
    public boolean isNumberUsed(int value) {
        boolean isCellValueEqual = false;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) { 
                if (board[i][j].value() == value) {
                    isCellValueEqual = true;
                }
            }
        }
        return isCellValueEqual;
    }

    /**
     * Checks whether a given cell is free.<br>
     * <b>Precondition:</b> 1&le;cell&le;9.
     * @param cell the number of the cell
     * @return true if the cell is currently unoccupied
     */
    public boolean isCellFree() {
        return (board[row][column].isEmpty());
    }

    /**
     * Auxiliary method that makes a move according to player's input
     */
    private void move(int value) {  
        board[row][column].setValue(value);
        board[row][column].setIsEmpty(false);
    }

    /**
     * Convert the letter into the row & col position on board
     */    
    private void letterPosition(char index) {   
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {    
                if(charArray[i][j] == index) {
                    row = i;
                    column = j;   
                }                     
            }
        }          
    }

    /**
     * Auxiliary method for printing a cell.
     */
    private String cellToString(int row, int col) {
        if(board[row][col].isEmpty() == false) {
            return " "+" "+board[row][col].value()+" "+" ";
        } else {
            return " "+" "+charArray[row][col]+" "+" ";
        }       
    }

    /**
     * Returns a textual representation of this board.
     * @return a textual representation of this board
     */
    public String toString() {
        System.out.println();
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result = result + cellToString(i, j);
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


// TO DO: CHECK IF ALL CELLS ARE FULL, RIGHT NOW GAME ENDS IF SUM = 15, 
// BUT NOT ALL CELLS ARE FILLED.
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
                if((board[i][j].isEmpty() == false) && (i==j)) {
                    sumLeftDiagonal = sumLeftDiagonal + board[i][j].value();
                }

                // Add value to right diagonal sum
                if((board[i][j].isEmpty() == false) && (i + j) == (3 - 1)) {
                    sumRightDiagonal = sumRightDiagonal + board[i][j].value();
                }   
            }
        }        
        return ((sumLeftDiagonal == 15 || sumRightDiagonal == 15) ? 15 : 0);
    }

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
                if(board[i][j].isEmpty() == false) {
                    sumRow = sumRow + board[i][j].value();

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
                if(board[i][j].isEmpty() == false) {
                    sumCol = sumCol + board[j][i].value();

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

        if(sumDiagonals() == 15 || sumRows() == 15 || sumColumns() == 15) {
            gameIsFinished = true;
        }
    }
 
    /**
     * Check if game is a draw
     */
    public void draw() {
        int countEmpty = 0;
        for(int i = 0; i < 3; i++) {            
            for(int j = 0; j < 3; j++) {
                if((board[i][j].isEmpty() == false) && !gameIsFinished) {
                    countEmpty++;

                    if(countEmpty == 9) {
                        System.out.println("It is a draw!");
                        gameIsFinished = true;
                    }
                }        
            }
        }
    }  
}
