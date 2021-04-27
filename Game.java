import java.util.Arrays;
/**
 * Class description. This class holds the state of the game and....
 * Includes: Creating a board-object and other objects, prompts the user for input,
 * parses the input and calls methods on board to update board state, 
 * shows board after each turn, stops the game once finished. 
 */

public class Game {
    private Board board;
    private int row, column;
    private Player[] players;
    private InputManager input;
    private static boolean turn;

    /**
     * Constructor that creates an empty board.
     */
    public Game(InputManager inputManager, Player[] players) {
        this.input = inputManager;
        this.players = players;
        board = new Board();
    }

    public void play() {
        // Print initial board
        System.out.println("Current board state.");
        System.out.println();
        System.out.println(board);


        while(!board.gameIsFinished) {
            for(Player player : players){
                if(board.gameIsFinished){
                    System.out.println("The game has ended.");  

                    if(board.draw) {
                        System.out.println("It is a draw!"); 
                    } else {
                          System.out.println("Congratulations to the winner: " + player.name());
                    }                                  
                    break;
                }

                 System.out.println("It is " + player.name() + "'s turn."); 
                turn();
                System.out.println();
                System.out.println(board);
            }       
        }
        //inputManager.closeInput();
    }

    /**
     * Prompt player for their move. 
     */
    public void turn() {        
        turn = true;

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
                if (board.isNumberUsed(value)) {
                    System.out.println("That number has already been used.");
                } else if (!board.isCellFree(row, column)){
                    System.out.println("That cell is not available.");
                } else {
                    board.move(row, column, value);
                    board.checkBoardState();

                    // Change player - turn is over!
                    turn = false;
                }       
            } while (turn);
        } 
    }



    /**
     * Return index based on letter input on board
    */
    private void letterPosition(char letter) {
        int index = letter - 65;               
        this.column = index % 3;
        this.row = index / 3;
    } 
}