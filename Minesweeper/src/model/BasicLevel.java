package model;

public class BasicLevel implements Level{

    private final int mines = 10;
    private final int rows = 8;
    private final int colunms = 8;

    public BasicLevel() {
    }

    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public int getRows() {
        return rows;
    }

    

    @Override
    public int getColumns() {
        return colunms;
    }
    
    
}
