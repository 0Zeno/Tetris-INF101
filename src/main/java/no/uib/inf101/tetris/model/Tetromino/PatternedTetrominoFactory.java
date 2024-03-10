package no.uib.inf101.tetris.model.Tetromino;

public class PatternedTetrominoFactory implements ITetrominoFactory {

    String pattern;
    int counter;

    public PatternedTetrominoFactory(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Tetromino getNext() {
        if (counter == pattern.length()) {
            counter = 0;
        }
        char tetrominoType = pattern.charAt(counter);
        counter += 1;
        return Tetromino.newTetromino(tetrominoType);
    }

}
