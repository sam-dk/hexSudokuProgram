/**
 * PuzzleChecks class that provides methods for checking if a row, column, or section
 * of a hexaduko puzzle contains a certain character
 */
public class PuzzleChecks
{
    /**
     * Check method that checks if a row, column, or section contains a character
     * @param a The character that is being checked
     * @param x The row to be checked
     * @param y The column to be checked
     * @param array The hexaduko puzzle used to check
     * @return True if the character is not found, False if the character is found
     */
    protected boolean check(char a, int x, int y, char[][] array)
    {
        if(checkRow(a, x, array) && checkCol(a, y, array) && checkSect(a, x, y, array))
            return true;
        return false;
    }

    /**
     * Check if a section contains a character
     * @param a The character that is being checked
     * @param x The row to be checked
     * @param y The column to be checked
     * @param array The hexaduko puzzle used to check
     * @return True if the character is not found, False if the character is found
     */
    private boolean checkSect(char a, int x, int y, char[][] array)
    {
        int rows = x - x % 4;
        int cols = y - y % 4;
        for(int i = rows; i < (rows + 4); i++)
        {
            for(int j = cols; j < (cols + 4); j++)
            {
                if(array[i][j] == a)
                    return false;
            }
        }
        return true;
    }

    /**
     * Check if a row contains a character
     * @param a The character that is being checked
     * @param row The row to be checked
     * @param array The hexaduko puzzle used to check
     * @return True if the character is not found, False if the character is found
     */
    private boolean checkRow(char a, int row, char[][] array)
    {
        for(int j = 0; j < array[0].length; j++)
        {
            if(array[row][j] == a)
                return false;
        }
        return true;
    }

    /**
     * Check if a section contains a character
     * @param a The character that is being checked
     * @param col The column to be checked
     * @param array The hexaduko puzzle used to check
     * @return True if the character is not found, False if the character is found
     */
    private boolean checkCol(char a, int col, char[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i][col] == a)
                return false;
        }
        return true;
    }
}