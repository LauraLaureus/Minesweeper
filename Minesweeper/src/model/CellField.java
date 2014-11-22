package model;

import java.util.ArrayList;
import java.util.TreeSet;

public class CellField {

    private boolean lock = false;
    private final Level lvl;
    private final Cell[][] field;

    public CellField(Level lvl) {
        this.lvl = lvl;
        field = new Cell[lvl.getRows()][lvl.getColumns()];
        fillTheField();
    }

    public Level getLvl() {
        return lvl;
    }

    public void lock() {
        this.lock = true;
    }

    public Cell getCellAt(Coordenate coord) {
        return field[coord.getRow()][coord.getColumn()];
    }

    public Cell[][] getField() {
        return field;
    }
    

    private void fillTheField() {
        generateAllCells();
        setMines();
        presentNeighbours();
    }

    private void generateAllCells() {

        for (int i = 0; i < lvl.getRows(); i++) {
            for (int j = 0; j < lvl.getColumns(); j++) {
                field[i][j] = new Cell();
            }

        }
    }

    private void setMines() {
        ArrayList<Coordenate> mineCoords = generateMineCoords();

        for (Coordenate mineCoord : mineCoords) {
            field[mineCoord.getRow()][mineCoord.getColumn()].setMine();
        }
    }

    private ArrayList<Coordenate> generateMineCoords() {
        TreeSet<Coordenate> result = new TreeSet<>();

        while (result.size() < lvl.getMines()) {
            result.add(generateSingleRandomCoordenate());
        }

        return new ArrayList<>(result);

    }

    private Coordenate generateSingleRandomCoordenate() {
        int x = (int) (Math.random() * (double) lvl.getRows());
        int y = (int) (Math.random() * (double) lvl.getColumns());
        return new Coordenate(x, y);
    }

    private void presentNeighbours() {
        ArrayList<Cell> northNeighbours;
        ArrayList<Cell> eastNeighbours;
        ArrayList<Cell> southNeighbours;
        ArrayList<Cell> westNeighbours;
        Coordenate target;

       
        for (int row = 0; row < field.length ; row++) {
            for (int column = 0; column < field[0].length; column++) {
                
                target = new Coordenate(row, column);
                northNeighbours = presentNorthNeighbours(target);
                eastNeighbours = presentEastNeighbours(target);
                southNeighbours = presentSouthNeighbours(target);
                westNeighbours = presentWestNeighbours(target);

                field[row][column].setNeighbours(
                        reuniteNESWneighbours(
                                northNeighbours, eastNeighbours,
                                southNeighbours, westNeighbours));
            }
        }
    }

    private ArrayList<Cell> presentNorthNeighbours(Coordenate target) {
        ArrayList<Cell> northNeighbours = new ArrayList<>();

        if (target.getRow() ==  0) return northNeighbours;
        if (target.getColumn() == (lvl.getColumns() - 1)) {
            northNeighbours.add(field[target.getRow() - 1][target.getColumn()]);

        } else if (target.getRow() != 0) {
            northNeighbours.add(field[target.getRow() - 1][target.getColumn()]);
            northNeighbours.add(field[target.getRow() - 1][target.getColumn() + 1]);
        }

        return northNeighbours;

    }

    private ArrayList<Cell> presentEastNeighbours(Coordenate target) {
        ArrayList<Cell> eastNeighbours = new ArrayList<>();

        if(target.getColumn() == (lvl.getColumns() - 1)) 
            return eastNeighbours;
        if (target.getRow() == (lvl.getRows() - 1)) {
            eastNeighbours.add(field[target.getRow()][target.getColumn() + 1]);
        } else if (target.getColumn() != (lvl.getColumns() - 1)) {
            eastNeighbours.add(field[target.getRow()][target.getColumn() + 1]);
            eastNeighbours.add(field[target.getRow() + 1][target.getColumn() + 1]);
        }
        return eastNeighbours;
    }

    private ArrayList<Cell> presentSouthNeighbours(Coordenate target) {
        ArrayList<Cell> southNeighbours = new ArrayList<>();

        if (target.getRow() == (lvl.getRows() - 1)) return southNeighbours;
        if (target.getColumn() == 0) {
            southNeighbours.add(field[target.getRow() + 1][target.getColumn()]);
        } else  {
            southNeighbours.add(field[target.getRow() + 1][target.getColumn()]);
            southNeighbours.add(field[target.getRow() + 1][target.getColumn()-1]);
        }
        return southNeighbours;
    }

    private ArrayList<Cell> presentWestNeighbours(Coordenate target) {
        ArrayList<Cell> westNeighbours = new ArrayList<>();
        
        if (target.getColumn() == 0) return westNeighbours;
        if (target.getRow() == 0)  {
            westNeighbours.add(field[target.getRow()][target.getColumn()-1]);
        } else if (target.getRow() != (lvl.getRows() - 1)) {
            westNeighbours.add(field[target.getRow()-1][target.getColumn()-1]);
            westNeighbours.add(field[target.getRow()][target.getColumn()-1]);
        }
        
        return westNeighbours;
    }

    private ArrayList<Cell> reuniteNESWneighbours(ArrayList<Cell> northNeighbours,
            ArrayList<Cell> eastNeighbours, ArrayList<Cell> southNeighbours, 
            ArrayList<Cell> westNeighbours)
    {
    
        ArrayList<Cell> reunited = new ArrayList<>();
        
        for (Cell northen : northNeighbours) {
            reunited.add(northen);
        }
        
        for (Cell easten : eastNeighbours) {
            reunited.add(easten);
        }
        
        for (Cell southen : southNeighbours) {
            reunited.add(southen);
        }
        
        for (Cell westen : westNeighbours) {
            reunited.add(westen);
        }
        return reunited;
    }


}
