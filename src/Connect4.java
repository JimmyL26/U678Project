import java.util.Scanner;

public class Connect4 {
    private Player[] players;
    private Board board;
    private Scanner scanner;

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
                        System.out.println("It is a tie!");
                    }
                }
            }
        }
    }

    public void takeTurn(Player player)
    {
        boolean validColumn = false;
        while (!validColumn)
        {
//            clearConsole();
            board.drawBoard();
            System.out.print(player.getPiece().getSymbol() + ", " + player.getName() + "'s turn! \nChoose a column: ");
            int column = scanner.nextInt();
            validColumn = board.recordMove(column, player);
        }
    }

    private void clearConsole()
    {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
