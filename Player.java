/**
 * Description -- class for player and np
 * Two types of players: Player or Computer
 */

public class Player {
    private int type;
    private String name;
    private boolean whosTurn;
    

    /**
     * Constructor for player
     */
    public Player(int type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Constructor for computer (No name included)
     */
    public Player(int type) {
        this.type = type;
    }

    /**
     * Perform player action
     */
    public void takeTurn() {
        //turn = true;

        if (type == 1) {
            // Perform turn
            System.out.println("Select a position and a number on the board. ");
           // System.out.println

        } else {
            // If computer
            // Later
        }
    }

    /**
     * TODO:
     * Method to validate user input to make sure that only 1 letter and 1 number
     * within the range is written. Maybe use some REGEX? Could be fun :D
    
    private static boolean valid_input(String playerInput) {
        return true;
    }
     */


    /**
     * Method that executes player move
     */
    //private void move(...)



}