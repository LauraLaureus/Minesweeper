package Presenter.modelInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import model.CellField;
import model.Coordenate;
import model.CoordenateComparator;
import model.Level;
import model.MineCell;

public class MineCellCreator {

    private final CellField field;
    private final Level lvl;
    private ArrayList<Coordenate> coords;
    
    public MineCellCreator(CellField field){
        this.field = field;
        this.lvl = field.getLvl();
    }
    
    public void createMineCells(){
        
        this.generateCoordenates();
        
        for (Coordenate coord : coords) {
            field.addCellAt(new MineCell(coord),coord);
        }
    }
    
    private void generateCoordenates() {
        TreeSet<Coordenate> result = new TreeSet<>();

        while (result.size() < this.lvl.getMines()) {
            result.add(createCoordenate(lvl.getRows(), lvl.getColumns()));
        }

        ArrayList<Coordenate> resultArray = new ArrayList<>(result);
        Collections.sort(resultArray, new CoordenateComparator());
        
        this.coords = resultArray;
    }

    private static Coordenate createCoordenate(int row, int column) {
        int x = (int) (Math.random() * (double) row);
        int y = (int) (Math.random() * (double) column);

        Coordenate newCoord = new Coordenate(x, y);
        return newCoord;
    }

    public ArrayList<Coordenate> getCoords() {
        return coords;
    }

    
}
