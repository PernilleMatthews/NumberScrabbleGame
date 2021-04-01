import java.util.Scanner;
/**
 * Class to control input
 */
public class InputManager {
    private Scanner keyboard = new Scanner(System.in);

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
    public String stringMoveInput(String prompt) {  
        String moveString;
        do {            
            System.out.print(prompt);
            moveString = keyboard.nextLine().toUpperCase().trim();
            if(moveString.length() !=  2) {
                System.out.println("Please insert a correct value. Try again.");
            }
        } while (moveString.length() != 2);       
        return moveString;
    } 

    /**
     * User input validation
     * Input = two characters
     * Input is uppercase
     * Input contains 1 letter & 1 number
     */
    private String validateInput(String validateInput) {
        //String validatedInput;
        //TODO
        return "TODO";
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