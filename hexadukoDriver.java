public class hexadukoDriver
{
    public static void main(String[] args)
    {
        Puzzle puzzle = new Puzzle(args[0]);
        PuzzleSolver solvedPuzzle = new PuzzleSolver(puzzle.getPuzzle());
        solvedPuzzle.solver(solvedPuzzle.getP());
        solvedPuzzle.display();
    }
}