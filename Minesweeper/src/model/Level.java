package model;

public class Level {

    final static int BASIC = 0;
    final static int MEDIUM = 1;
    final static int EXPERT = 2;

    private final int level;

    public Level(int level) {
        this.level = level;
    }

    public int getMines() {
        int mines = 0;

        switch (level) {
            case Level.BASIC:
                mines = 10;
                break;
            case Level.MEDIUM:
                mines = 40;
                break;
            case Level.EXPERT:
                mines = 99;
                break;
        }
        return mines;
    }

    public int getRows() {

        int rows = 0;
        switch (level) {
            case Level.BASIC:
                rows = 8;
                break;
            case Level.MEDIUM:
                rows = 16;
                break;
            case Level.EXPERT:
                rows = 16;
                break;
        }

        return rows;
    }

    public int getColumns() {
        int columns = 0;
        switch (level) {
            case Level.BASIC:
                columns = 8;
                break;
            case Level.MEDIUM:
                columns = 16;
                break;
            case Level.EXPERT:
                columns = 30;
                break;
        }

        return columns;

    }

}
