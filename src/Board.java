public class Board {
    private static final String BLUE = "\033[1;94m";
    private static final String WHITE = "\033[1;97m";

    private Space[][] board;

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

    public Space getSpace(int row, int column)
    {
        if (row >= 0 && column >= 0 && row < board.length && column < board[row].length);
        {
            return board[row][column];
        }
    }

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
                if (board[i][column].getSymbol() == Space.BLANK)
                {
                    board[i][column].setSymbol(player.getPiece().getSymbol());
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isFull()
    {
        for (Space[] row : board)
        {
            for (Space element : row)
            {
                if (element.getSymbol() == Space.BLANK)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin()
    {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    public boolean checkHorizontal()
    {
        for (int i = 0; i < board.length; i++)
        {
            int count = 1;
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j].getSymbol() != Space.BLANK && j + 1 < board.length)
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

    public boolean checkVertical()
    {
        for (int j = 0; j < board[0].length; j++)
        {
            int count = 1;
            for (int i = 0; i < board.length; i++)
            {
                if (board[i][j].getSymbol() != Space.BLANK && i + 1 < board.length)
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

    public boolean checkDiagonal()
    {
        for (int i = 0; i < board.length; i++)
        {
            int count = 1;
            int temp = i;
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j].getSymbol() != Space.BLANK && i + 1 < board.length && j + 1 < board[0].length)
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
                if (board[i][j].getSymbol() != Space.BLANK && i - 1 > 0 && j + 1 < board[0].length)
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
