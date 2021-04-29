import java.util.Scanner;
/**
 * Class to control input and enable one Scanner 
 * throughout the program. 
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
     * @param  ...
     * @return a int read from input
     */
    public int intInput(String prompt) {
        System.out.print(prompt);
        return keyboard.nextInt();         
    } 

    /*
     * Get user input with type String + prompt
     * @param   ...
     * @return a string read from input
     */
    public String stringInput(String prompt) {      
        System.out.print(prompt);
        return keyboard.nextLine().trim();         
    } 

    /*
     * Get user input for move e.g., "A1"
     * @param   ...
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
// Question: To what degree should they validate the input, e.g., A11 will work and seen as A1.
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

    /*
     * TODO: Currently does not work..:sus:
     * Close prompt.
     */
    public void closeInput(){
        keyboard.close();
    } 
}