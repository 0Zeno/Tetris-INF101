package no.uib.inf101.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid <E> implements IGrid <E>{

    private int row;
    private int col;
    List<List<E>> grid;

    public Grid(int row, int col, E defaultValue){
        this.col = col;
        this.row = row;
        this.grid = new ArrayList<>();
        
        for (int rows = 0; rows < this.row; rows++){
            List<E> tempList = new ArrayList<>();
            for (int cols = 0; cols < col; cols++) {
                tempList.add(defaultValue);
            }
            grid.add(tempList);
        }

    }

    public Grid(int row, int col) {
        this(row, col, null);
    }

    
    /** 
     * @return int
     */
    @Override
    public int rows() {
        return this.row;
    }

    
    /** 
     * @return int
     */
    @Override
    public int cols() {
        return this.col;
    }

    
    /** 
     * @return Iterator<GridCell<E>>
     */
    @Override
    public Iterator<GridCell<E>> iterator() {
        ArrayList<GridCell<E>> grid = new ArrayList<GridCell<E>>();

        for (int i = 0; i < rows(); i++){
            for (int n = 0; n < cols(); n ++){
                CellPosition pos = new CellPosition(i, n);
                grid.add(new GridCell<E>(pos, get(pos)));
            }
        }
        return grid.iterator();
    }

    @Override
    public E get(CellPosition pos) {
       if (!positionIsOnGrid(pos)){
        throw new IndexOutOfBoundsException("Position not on grid");
       }
       return grid.get(pos.row()).get(pos.col());
    }
    
    @Override
    public void set(CellPosition pos, E value) {
        if (!positionIsOnGrid(pos)){
            throw new IndexOutOfBoundsException("Position not on grid");
        }
        grid.get(pos.row()).set(pos.col(), value);
    }

    @Override
    public boolean positionIsOnGrid(CellPosition pos) {
        boolean IsOnRow = pos.row() >= 0 && pos.row() <this.row;
        boolean IsOnCol = pos.col() >= 0 && pos.col() <this.col;
        return IsOnCol && IsOnRow;
    }


    private List<E> removeRow(int row){
        return this.grid.remove(row);
    }

    public void removeFullRow(int row){
        List<E> removedRow = removeRow(row);
        this.grid.add(0, removedRow);
    }
}

    
    

