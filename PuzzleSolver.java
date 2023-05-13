import java.util.LinkedList;

/**
 * PuzzleSolver class this is a subclass of PuzzleChecks.
 * The PuzzleSolver class is used to solve hexaduko puzzles.
 */
public class PuzzleSolver extends PuzzleChecks
{
    private char[] values = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    private char[][] puzzle;

    /**
     * Initializes PuzzleSolver object with the hexaduko puzzle in the argument
     * @param p The hexaduko puzzle to be solved
     */
    public PuzzleSolver(char[][] p)
    {
        this.puzzle = p;
    }

    /**
     * Checks if a character is able to be put into a spot in the hexaduko puzzle
     * @param a The character that is being checked
     * @param x The row to be checked
     * @param y The column to be checked
     * @param p The hexaduko puzzle used to check
     * @return True if the character can be placed in that spot, False if the character cannot be placed in that spot
     */
    public boolean promising(char a, int x, int y, char[][] p)
    {
        if(super.check(a, x, y, p))
            return true;
        return false;
    }

    /**
     * Attempts to solve the hexaduko puzzle in the argument, returns whether the puzzle can be solved or not
     * @param p The hexaduko puzzle that is to be solved
     * @return True if the puzzle can be solved, False if the puzzle cannot be solved
     */
    public boolean solver(char[][] p)
    {
        int[] testCase = searching(p); //[0] -> row; [1] -> col;
        if(done(p) == false) //if p contains any '-'
        {
            for(int val = 0; val < values.length; val++)
            {
                if(promising(values[val], testCase[0], testCase[1], p)) //tests character from values at the spot
                {
                    p[testCase[0]][testCase[1]] = values[val]; //if character can be placed, places character
                    if(solver(p)) //recursively checks if solution is viable
                        return true;
                    else
                    {
                        p[testCase[0]][testCase[1]] = '-'; //if solution not viable, place dash at spot
                    }
                }
            }
            return false; //return false to pop recursive stack
        }   
        return true; //if p is complete, return true
    }        
    
    /**
     * Displays the puzzle of the PuzzleSolver object
     */
    public void display()
    {
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Searches through the puzzle provided in the argument to find the spot where the least
     * amount of possible choices are available to choose from
     * @param p The hexaduko puzzle to be checked
     * @return An array of length two, that contains the row and col of the spot
     */
    public int[] searching(char[][] p)
    {
        int lowest = 16;
        int temp = 0;
        int[] arr = new int[2];
        for(int i = 0; i < p.length; i++)
        {
            for(int j = 0; j < p[0].length; j++)
            {
                if(p[i][j] == '-') //searches through p to find a '-'
                {
                    for(int val = 0; val < values.length; val++)
                    {
                        if(promising(values[val], i, j, p)) //checks all characters from values that can be put at the spot
                        {  
                            temp++; //if a character is viable, increment temp
                        }
                    }
                    if(temp <= lowest) //finds spot with least amount of choices available
                    {
                        lowest = temp; //lowest set to temp. arr[0] -> row; arr[1] -> col;
                        arr[0] = i;
                        arr[1] = j;
                    } 
                }
            }
            temp = 0; //temp to 0
        }
        return arr;
    }

    /**
     * Looks through the puzzle to see if the puzzle is finished or not
     * @param p The hexaduko puzzle to be checked
     * @return True if the puzzle if finished, False if the puzzle is not finished
     */
    public boolean done(char[][] p)
    {
        for(int i = 0; i < p.length; i++)
        {
            for(int j = 0; j < p[0].length; j++)
            {
                if(p[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    /**
     * Returns the puzzle of PuzzleSolver object
     * @return The hexaduko puzzle that is to be solved
     */
    public char[][] getP()
    {
        return puzzle;
    }
}
