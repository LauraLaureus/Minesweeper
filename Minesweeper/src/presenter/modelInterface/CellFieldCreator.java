package Presenter.modelInterface;

import java.util.ArrayList;
import model.CellField;
import model.Coordenate;
import model.Level;
import model.Mine;
import presenter.modelInterface.NumericCellCreator;

public class CellFieldCreator {

    private  CellField field;
    private  MineCellCreator mineCreator;
    private  NumericCellCreator numericCreator;
    
    public CellFieldCreator(Level lvl) {
        this.field = new CellField(lvl);
        this.mineCreator = new MineCellCreator(field);
        this.numericCreator = new NumericCellCreator(field);
    }
    
    public void createField(){
        
        mineCreator.createMineCells();
        ArrayList<Coordenate> minesLocation = mineCreator.getCoords();
        numericCreator.createNumericCells(minesLocation);
    
    }
    
    public CellField getField(){
        return this.field;
    }
    
}
