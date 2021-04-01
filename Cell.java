/**
* Class that represents a single cell of the whole board
*/

public class Cell {
    /**
     * Class attributes
     */
    private boolean isEmpty;
    private int value;
    
    public Cell() {
        this.isEmpty = true;
        this.value = -1;
    }

    /**
     * Set the content of a cell
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }

    /**
     * Set the empty value of a cell
     */
    public void setIsEmpty(boolean newState) {
        this.isEmpty = newState;
    }

    /**
     * Return the empty value of a cell
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * Returns content of cell
     */
    public int value() {
        return this.value;
    }


}
