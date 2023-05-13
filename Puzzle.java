/**
 * Puzzle class that is used to represent a hexaduko puzzle.
 */
public class Puzzle
{
    private char[][] puzzle;

    /**
     * Initializes Puzzle object using the file provided in the argument
     * @param filename The name of the file
     */
    public Puzzle(String filename)
    {
        PuzzleBuilder builder = new PuzzleBuilder(); //instantiate PuzzleBuilder object
        puzzle = builder.createPuzzle(filename);     //uses PuzzleBuilder object to create hexaduko puzzle
    }
    
    /**
     * Returns the hexaduko puzzle of the Puzzle object
     * @return The hexaduko puzzle of the Puzzle object
     */
    public char[][] getPuzzle()
    {
        return puzzle;
    }
}