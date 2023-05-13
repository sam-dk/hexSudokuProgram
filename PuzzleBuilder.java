import java.io.*;
import java.util.Scanner;

/**
 * PuzzleBuilder class used to create a hexaduko puzzle that is read from a file
 */
public class PuzzleBuilder
{
    /**
     * Initializes PuzzleBuilder object
     */
    public PuzzleBuilder()
    {
    }

    /**
     * Creates a hexaduko puzzle from the file provided in the argument
     * @param filename The name of the file
     * @return The hexaduko puzzle created from the file
     */
    public char[][] createPuzzle(String filename)
    {
        char[][] arr = new char[16][16]; 
        try
        {
            File file = new File(filename);
            Scanner infile = new Scanner(file);
            int i = 0;
            while(infile.hasNextLine())
            {
                String line = infile.nextLine();
                for(int j = 0; j < line.length(); j++)
                {
                    arr[i][j] = line.charAt(j);
                }
                i++;
            }
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }
        return arr;
    }

}