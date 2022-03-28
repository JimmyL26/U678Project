public class Piece {
    private static final String[] pieces = {"\033[1;93m" + "O", "\033[1;91m" + "O"};

    private final String symbol;

    public Piece (int pieceNum)
    {
        this.symbol = pieces[pieceNum];
    }

    public String getSymbol()
    {
        return symbol;
    }
}
