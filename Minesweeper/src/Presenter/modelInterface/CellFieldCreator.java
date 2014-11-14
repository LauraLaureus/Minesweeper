package Presenter.modelInterface;

import java.util.ArrayList;
import model.CellField;
import model.Coordenate;
import model.Level;
import model.MineCell;

public class CellFieldCreator {

    private static CellField field;

    public CellFieldCreator(Level lvl) {
        this.field = new CellField(lvl);
    }
    
    public static void createField(){
        
        ArrayList<Coordenate> minesPosition = 
                MineCellCoordenatesCreator.createCorrdenates(field.getLvl().getMines());
        
        for (Coordenate minePos : minesPosition) {
            field.addCellAt(new MineCell(minePos), minePos);
        }
        
        NumericCellCreator.createCellsNearBy(minesPosition);
    }
    
}
