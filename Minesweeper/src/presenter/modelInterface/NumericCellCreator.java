package presenter.modelInterface;

import java.util.ArrayList;
import java.util.TreeSet;
import model.CellField;
import model.Coordenate;
import model.NumericCell;

public class NumericCellCreator {

    private final CellField field;

    public NumericCellCreator(CellField field) {
        this.field = field;
    }

    public void createNumericCells(ArrayList<Coordenate> builtCoords) {

        while(builtCoords.size() < 
                 ( field.getLvl().getRows() * field.getLvl().getColumns() ) ){
            
            ArrayList<Coordenate> candidates = surroundBuiltCells(builtCoords);
            
            for (Coordenate created : createdCells(candidates)) {
                builtCoords.add(created);
            }
            
            sort(builtCoords);
        }
    }

    private ArrayList<Coordenate> surroundBuiltCells(ArrayList<Coordenate> builtCoords) {

        TreeSet<Coordenate> candidates = new TreeSet<>();
        
        for (Coordenate builtCoord : builtCoords) {
            for (Coordenate candidate : getSurroundedValidCandidates(builtCoord)) {
                candidates.add(candidate);
            }
        }
        
        return new ArrayList<>(candidates);
    }
}
