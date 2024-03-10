package no.uib.inf101.tetris.model.Tetromino;

public class RandomTetrominoFactory implements ITetrominoFactory {

    private Character getRandomTetromino() {
        //https://www.geeksforgeeks.org/java-math-random-method-examples/
        //https://ioflood.com/blog/charat-java/#:~:text=The%20charAt%20function%20in%20Java%20is%20used%20to%20return%20the,character%20you%20want%20to%20access.
        String tetrominoOptions = "LJSZTIO";
        int index = (int) (Math.random() * tetrominoOptions.length() );
        char randomtetromino = tetrominoOptions.charAt(index);
        return randomtetromino;
    }

    @Override
    public Tetromino getNext() {
        return Tetromino.newTetromino(getRandomTetromino());
    }

}
