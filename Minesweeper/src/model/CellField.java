package model;

public class CellField {
    
    private boolean lock = false;
    private final Level lvl;
    private Cell[][] field;

    public CellField(Level lvl) {
        this.lvl = lvl;
        field = new Cell[lvl.getRows()][lvl.getColumns()];
    }

    public Level getLvl() {
        return lvl;
    }

    public Cell[][] getCellMatrix() {
        return field;
    }

    public void addCellAt(Cell cell, Coordenate coord) {
        field[coord.getRow()][coord.getColumn()] = cell;
    }
    
    public void lock(){
        this.lock = true;                
    }
    
    public Cell getCellAt(Coordenate coord){
        return field[coord.getRow()][coord.getColumn()];
    }

}
