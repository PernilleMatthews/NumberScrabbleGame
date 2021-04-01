import java.util.Scanner;
/**
 * Class to control input
 */
public class InputManager {
    private Scanner keyboard = new Scanner(System.in);
    private String[] sArray;

    /**
     * Constructor
     */
    public InputManager() {     
        // Empty
    }

    /**
     * Get user input type int + prompt
     * @param  
     * @return a int read from input
     */

    public int intInput(String prompt) {
        System.out.print(prompt);
        return keyboard.nextInt();         
    } 

    /*
     * Get user input with type String + prompt
     * @param   
     * @return a string read from input
     */
    public String stringInput(String prompt) {      
        System.out.print(prompt);
        return keyboard.nextLine().trim();         
    } 

    /*
     * Get user input for move e.g., "A1"
     * @param   
     * @return a uppercase string read from input
     */
    public String[] stringMoveInput(String prompt) { 
        boolean validInput = false;
        do {
            System.out.print(prompt);
            String moveString;
            moveString = keyboard.nextLine().toUpperCase().trim();
            this.sArray = moveString.split("");

            if (moveString.length() !=  2 && !validatePosition(this.sArray) && !validateNumber(this.sArray)) {
                System.out.println("Please insert a correct value.");
            } else {
                validInput = true;
            }
        } while(!validInput);

        return this.sArray;
    } 

// Work on these two validation methods, they don't work as intended entirely...:thinking:
    /*
     * Get user input for move e.g., "A1"
     * @param   
     * @return a uppercase string read from input
     */
    public boolean validatePosition(String[] letterPosition) {
        return ((letterPosition[0].charAt(0) >= 65 && letterPosition[0].charAt(0) <= 74) ? true : false);
    } 

    /*
     * Get user input for move e.g., "A1"
     * @param   
     * @return a uppercase string read from input
     */
    public boolean validateNumber(String[] number) {
        int value = Integer.parseInt(String.valueOf(number[1]));
        return ((value >= 1 && value <= 9) ? true : false);
    } 


    /**
  //encapsulated code for user input validation
  //it checks to make sure the input was two or three characters long,
  //and that it contained one or two digits, followed by one lower
  //case or upper case letter
  private static boolean valid_input(String user_input) {
  
    boolean output = false;
    
    if(user_input.length() == 2){
    
      output = (user_input.substring(0,1).matches("[0-9]") && user_input.substring(1,2).matches("[a-zA-Z]"));
    } else if (user_input.length() == 3) {
    
      output = (user_input.substring(0,2).matches("[1-2][0-9]") && user_input.substring(2,3).matches("[a-zA-Z]"));
      
      if(Integer.parseInt(user_input.substring(0,2))>TicTacToe.game.gridSize){
        output = false;
      }
    }
    
    return output;
  }
     */

    /*
     * Close prompt.
     */
    public void closeInput(){
        keyboard.close();
    } 
}