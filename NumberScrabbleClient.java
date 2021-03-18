import java.util.Scanner;
import java.util.Arrays;

/**
* Class description.
*
*/
public class NumberScrabbleClient {
    /**
     * Class attributes.
     */ 
    public static int gameMode;
    
    private static NumberScrabble board;
    private static Scanner input;
    //private static String player, computer;
    private static String player1, player2, computer;
    
    

    /**
     * Initialisation.
     */
    private static void init() {              
        board = new NumberScrabble();
        
        // Select game mode
        System.out.println("Select a game mode");
        System.out.println("Press 1 for Player vs Player");
        System.out.println("Press 2 for Player vs Computer");
        System.out.print("Your choice: ");

        //do {
            gameMode = input.nextInt();
        //} while(gameMode != 1 || gameMode != 2);

        // Initialise the players array (Always 2)        
        Player[] players = new Player[2];

        if (gameMode == 1) {       
            System.out.println();  
            System.out.println("You have selected Player vs Player.");

            // Player 1 creation         
            System.out.print("Who is player 1? ");
            input.nextLine(); // Flush
            player1 = input.nextLine().trim();
            players[0] = new Player(1, player1);
            
            // Player 2 creation           
            System.out.print("Who is player 2? ");
            player2 = input.nextLine().trim();
            players[1] = new Player(1, player2);

        } else {
            // To do later....first player vs player             
            System.out.println("You have selected Player vs Computer.");
            System.out.print("Who is player 1? ");
            player1 = input.nextLine().trim();

            players[0] = new Player(2, player1);
            players[1] = new Player(2);
            System.out.println(player1);
        } 
       
        
    }


    /**
     * Main program.
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);
        init(); 
        System.out.println(board);

/*
        boolean activeGame = true;
        while (activeGame) {
           // String getPlayer = (board.nextPlayer() ? )
            //System.out.println("It is "+(board.nextPlayer() == player1 ? player1 : player2)+"'s turn.");
            //System.out.println("It is " + (board.nextPlayer() == player ? player : computer) +"'s turn.");
            System.out.println("Current board state:");
            System.out.println(board);
            
            String cell;

            do {
                // System.out.println("available numbers are")
                System.out.println("Where do you want to play? ");
                cell = input.nextLine().trim();
                char c = board[][charAt(cell)];

                if((c < 65) || (c > 79)) {
                    System.out.println("Invalid board position.");
                } else if (!board.isFree(cell)) {
                    System.out.println("That board position is not free.");
                }
            } while ((c < 65) || (c > 79) || !board.isFree(cell));

            board.play(cell);
            activeGame = false;

            if (board.hasWon('X')) {
                System.out.println(player1 + " has won.");
            } else if (board.hasWon('O')) {
                System.out.println(player2 + " has won.");
            } else if (board.isFull()) {
                System.out.println("We have a draw.");
            } else {
                activeGame = true;
            }                        
            
            input.close();
        }
            */
        
    }
}