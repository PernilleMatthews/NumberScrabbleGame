import java.util.Arrays;

/**
* Class description.
*
*/
public class NumberScrabbleClient {
    /**
     * Class attributes.
     */ 
    private static Game board;
    private static int gameMode;
    private static Player[] players;
    private static InputManager inputManager = new InputManager();


    /**
     * Initialisation.
     */
    private static void init() {              
        board = new Game(inputManager);
        
        // Select game mode
        System.out.println("Select a game mode");
        System.out.println("Press 1 for Player vs Player");
        System.out.println("Press 2 for Player vs Computer");
        do {
            gameMode = inputManager.intInput("Your choice: ");
            if((gameMode != 1) && (gameMode != 2)) {
                System.out.println("Please insert a correct value. Try again.");
            }
        } while((gameMode != 1) && (gameMode != 2));

        // Initialise the players array      
        players = new Player[2];

        if (gameMode == 1) {       
            System.out.println();  
            System.out.println("You have selected Player vs Player.");

            // Player 1 creation
            inputManager.stringInput(""); // Flush
            String player1 = inputManager.stringInput("Who is player 1? ");
            players[0] = new Player(1, player1);
            
            // Player 2 creation
            String player2 = inputManager.stringInput("Who is player 2? ");
            players[1] = new Player(1, player2);
            
        } else {
            // TODO: later....first player vs player             
            System.out.println("You have selected Player vs Computer.");
            String player1 = inputManager.stringInput("Who is player 1? ");
            System.out.println();
            
            players[0] = new Player(2, player1);
            players[1] = new Player(2);            
        }    
    }

    /**
     * Main program.
     */
    public static void main(String[] args) {
        init(); 

        while(!board.gameIsFinished) {
            System.out.println("Current board state.");
            System.out.println(board);
            
            String cell;
            char c;
            
            for(Player player : players){
                
                System.out.println("It is " + player.name() + "'s turn.");
                board.turn();
                System.out.println(board);                

                if(board.gameIsFinished){
                    // change message if draw
                    System.out.println("The game has ended.");
                    System.out.println("Congratulations to the winner: " + player.name());
                    break;
                }
            }           
        }
        inputManager.closeInput(); 
    }
}