import java.util.Scanner;

/**
 * This class represents a Connect4 object
 *
 * @author Jimmy Li
 */
public class Connect4 {
    /** The list of players **/
    private Player[] players;

    /** The board used for Connect 4 **/
    private Board board;

    /** The Scanner object used for user inputs**/
    private Scanner scanner;

    /**
     * Instantiates a Connect4 Object.
     */
    public Connect4()
    {
        scanner = new Scanner(System.in);
        players = new Player[2];
        for (int i = 0; i < players.length; i++)
        {
            System.out.print("Player " + (i + 1) + "'s Name is: ");
            String name = scanner.nextLine();
            Piece piece = new Piece(i);
            players[i] = new Player(name, piece);
        }
        clearConsole();
        board = new Board();
    }

    /**
     * Starts the game and allow users to take turns placing their pieces until there is a victor or a tie
     */
    public void runGame()
    {
        boolean endGame = false;
        while (!endGame && !board.isFull())
        {
            for (Player player : players)
            {
                if (!endGame)
                {
                    takeTurn(player);
                    if (board.checkWin())
                    {
                        endGame = true;
                        clearConsole();
                        board.drawBoard();
                        System.out.println(player.getName() + " Won!");
                    }
                    if (board.isFull())
                    {
                        endGame = true;
                        clearConsole();
                        board.drawBoard();
                        System.out.println("It's a tie!");
                    }
                }
            }
        }
    }

    /**
     * Helper method that will allow users to choose what column to place their piece and record their move onto the 2D Space array
     *
     * @param player The player taking the turn
     */
    public void takeTurn(Player player)
    {
        boolean validColumn = false;
        while (!validColumn)
        {
            clearConsole();
            board.drawBoard();
            System.out.print(player.getPiece().getSymbol() + ", " + player.getName() + "'s turn! \nChoose a column: ");
            int column = scanner.nextInt();
            validColumn = board.recordMove(column, player);
        }
    }

    /**
     * Helper method that separates the new board from the old ones
     */
    private void clearConsole()
    {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
