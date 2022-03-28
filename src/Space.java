public class Space {
    // static variable
    public static final String BLANK = " ";

    // instance variable
    private String symbol;

    /** Constructor; all Space objects start off with a blank symbol
     */
    public Space()
    {
        symbol = BLANK;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}
