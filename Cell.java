/**
* Class that represents a single cell of the whole board
*/

public class Cell {    
    private int value;
    private String letter;

    public Cell(String letter) {
        this.letter = letter;
        this.value = 0;
    }

    /**
     * Precondition: Value is an int between 1-9.
     * Set the content of a cell
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }

    /**
     * Return the empty value of a cell
     */
    public boolean isEmpty() {
        return this.value == 0;
    }

    /**     
     * Returns content of cell
     */
    public int value() {
        return this.value;
    }

    /**
     * Returns a textual representation of this cell.
     * @return a textual representation of this cell
     */
    public String toString() {
        if(isEmpty() == false) {
            return Integer.toString(value());
        } else {
            return letter;
        }
    }
}
