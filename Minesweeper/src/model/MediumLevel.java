package model;

public class MediumLevel implements Level {

    private final int mines = 40;
    private final int rows = 16;
    private final int columns = 16;

    public MediumLevel() {
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
