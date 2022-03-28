/**
 * This class represents a Board object
 *
 * @author Jimmy Li
 */
public class Board {
    /** A variable to set text to the color blue **/
    private static final String BLUE = "\033[1;94m";

    /** A variable to set text to the color white **/
    private static final String WHITE = "\033[1;97m";

    /** The board for Connect 4 **/
    private Space[][] board;

    /**
     * Instantiates a Board object.
     */
    public Board()
    {
        board = new Space[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++)
            {
                board[i][k] = new Space();
            }
        }
    }

    /**
     * Draws the board with dividers and uses the 2D Space array to place the symbols
     */
    public void drawBoard()
    {
        System.out.println();

        for (int i = -1; i < board.length; i++)
        {
            String verticalDivider = BLUE + "|";
            String horizontalDivider = BLUE + "_";
            for (int j = 0; j < board[0].length; j++)
            {
                if (i == -1)
                {
                    System.out.print(WHITE + " " + (j + 1));
                }
                else
                {
                    System.out.print(verticalDivider);
                    if (board[i][j].getSymbol().equals(Space.BLANK)) {
                        System.out.print(horizontalDivider);
                    } else {
                        System.out.print(board[i][j].getSymbol());
                    }
                }
            }
            if (i != -1)
            {
                System.out.println(verticalDivider);
            }
            else
            {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Returns true or false based on if the space exists and is available
     *
     * @param column The column the piece is falling into
     * @param player The player that is doing the move
     * @return A boolean stating if the move was successfully recorded
     */
    public boolean recordMove(int column, Player player)
    {
        column -= 1;
        if (column >= board[0].length || column < 0)
        {
            return false;
        }
        else
        {
            for (int i = board.length - 1; i >= 0; i--)
            {
                if (board[i][column].getSymbol().equals(Space.BLANK))
                {
                    board[i][column].setSymbol(player.getPiece().getSymbol());
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Returns a boolean stating if the board has no blank spaces left by traversing through the 2D array until there is a blank space or until the entire 2D array is traversed
     *
     * @return A boolean stating if the board has no blank spaces left
     */
    public boolean isFull()
    {
        for (Space[] row : board)
        {
            for (Space element : row)
            {
                if (element.getSymbol().equals(Space.BLANK))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns a boolean stating if a player has won by using helper methods
     *
     * @return a boolean stating if a player has won
     */
    public boolean checkWin()
    {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    /**
     * Returns a boolean stating if a player has won with 4 consecutive same color pieces in one row
     *
     * @return a boolean stating if a player has won with a horizontal win config
     */
    public boolean checkHorizontal()
    {
        for (int i = 0; i < board.length; i++)
        {
            int count = 1;
            for (int j = 0; j < board[0].length; j++)
            {
                if (!board[i][j].getSymbol().equals(Space.BLANK) && j + 1 < board.length)
                {
                    if (board[i][j].getSymbol().equals(board[i][j + 1].getSymbol()))
                    {
                        count++;
                    }
                    else
                    {
                        count = 1;
                    }
                    if (count == 4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns a boolean stating if a player has won with 4 consecutive same color pieces in one column
     *
     * @return a boolean stating if a player has won with a vertical win config
     */
    public boolean checkVertical()
    {
        for (int j = 0; j < board[0].length; j++)
        {
            int count = 1;
            for (int i = 0; i < board.length; i++)
            {
                if (!board[i][j].getSymbol().equals(Space.BLANK) && i + 1 < board.length)
                {
                    if (board[i][j].getSymbol().equals(board[i + 1][j].getSymbol()))
                    {
                        count++;
                    }
                    else
                    {
                        count = 1;
                    }
                    if (count == 4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns a boolean stating if a player has won with 4 consecutive same color pieces in a diagonal pattern
     *
     * @return a boolean stating if a player has won with a diagonal win config
     */
    public boolean checkDiagonal()
    {
        for (int i = 0; i < board.length; i++)
        {
            int count = 1;
            int temp = i;
            for (int j = 0; j < board[0].length; j++)
            {
                if (!board[i][j].getSymbol().equals(Space.BLANK) && i + 1 < board.length && j + 1 < board[0].length)
                {
                    if (board[i][j].getSymbol().equals(board[i + 1][j + 1].getSymbol()))
                    {
                        count++;
                        i++;
                    }
                    else
                    {
                        count = 1;
                    }
                    if (count == 4)
                    {
                        return true;
                    }
                }
            }
            i = temp;
        }

        for (int i = board.length - 1; i > 0; i--)
        {
            int count = 1;
            int temp = i;
            for (int j = 0; j < board[0].length; j++)
            {
                if (!board[i][j].getSymbol().equals(Space.BLANK) && i - 1 > 0 && j + 1 < board[0].length)
                {
                    if (board[i][j].getSymbol().equals(board[i - 1][j + 1].getSymbol()))
                    {
                        count++;
                        i--;
                    }
                    else
                    {
                        count = 1;
                    }
                    if (count == 4)
                    {
                        return true;
                    }
                }
            }
            i = temp;
        }
        return false;
    }
}
