/**
 * This class represents a Player object
 *
 * @author Jimmy Li
 */
public class Player {
    /** The name of the player **/
    private String name;

    /** The piece the player is using **/
    private Piece piece;

    /**
     * Instantiates a Player object
     *
     * @param name The name of the player
     * @param piece The piece the player is using
     */
    public Player(String name, Piece piece)
    {
        this.name = name;
        this.piece = piece;
    }

    /**
     * Returns the name of the player
     *
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the piece the player is using
     *
     * @return the piece the player is using
     */
    public Piece getPiece()
    {
        return piece;
    }
}
