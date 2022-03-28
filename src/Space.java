/**
 * This class represents a Space object
 *
 * @author Jimmy Li
 */
public class Space {
    /** A variable that represents a blank space on the board **/
    public static final String BLANK = " ";

    /** The symbol of the space **/
    private String symbol;

    /**
     * Instantiates a Space object with the default value of BLANK
     */
    public Space()
    {
        symbol = BLANK;
    }

    /**
     * Returns the symbol of the space
     *
     * @return the symbol of the space
     */
    public String getSymbol()
    {
        return symbol;
    }

    /**
     * Sets the symbol of the space to a new symbol
     *
     * @param symbol the new symbol of the space
     */
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}
