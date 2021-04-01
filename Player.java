/**
 * Description -- class for player and np
 * Two types of players:
 *       Player: A Player can have a name
 *       Computer: A Computer is not given a name
 */

public class Player {
    private int type;
    private String name; 

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

    /*
     * Returns the player's name 
     */
    public String name() {
        return name;
    }    
}