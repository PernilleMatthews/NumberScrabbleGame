import java.util.Arrays;

/**
* Class description.
*
*/
public class NumberScrabbleClient {
    private static Game game;
    private static int gameMode;
    //private static Player[] players;
    private static InputManager inputManager = new InputManager();


    /**
     * Initialisation.
     */
    private static void init() {         
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
        Player[] players = new Player[2];

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
            
        } else { // Else player vs pc
            // TODO: later....first player vs player             
            System.out.println("You have selected Player vs Computer.");
            String player1 = inputManager.stringInput("Who is player 1? ");
            System.out.println();
            
            players[0] = new Player(2, player1);
            players[1] = new Player(2);            
        }   
        // Create tha game!
        game = new Game(inputManager, players);
         
    }

    /**
     * Main program.
     */
    public static void main(String[] args) {
        init(); 
        game.play();        
    }
}