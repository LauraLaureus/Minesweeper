package model;

public class ExpertLevel implements Level {

    private final int mines = 99;
    private final int rows = 16;
    private final int columns = 30;

    public ExpertLevel() {
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
        return columns;
    }

}
