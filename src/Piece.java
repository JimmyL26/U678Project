/**
 * This class represents a Piece object
 *
 * @author Jimmy Li
 */
public class Piece {
    /** The color pieces in Connect 4 **/
    private static final String[] pieces = {"\033[1;93m" + "O", "\033[1;91m" + "O"};

    /** The symbol of the Piece object **/
    private final String symbol;

    /**
     * Instantiates a Piece object
     *
     * @param pieceNum The index of the array pieces
     */
    public Piece (int pieceNum)
    {
        this.symbol = pieces[pieceNum];
    }

    /**
     * Returns the symbol of the Piece object
     *
     * @return the symbol of the Piece object
     */
    public String getSymbol()
    {
        return symbol;
    }
}
