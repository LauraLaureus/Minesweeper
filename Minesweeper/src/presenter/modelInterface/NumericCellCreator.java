package presenter.modelInterface;

import java.util.ArrayList;
import model.CellField;
import model.Coordenate;
import model.NumericCell;

public class NumericCellCreator {
    
    private final CellField field;
  

    public NumericCellCreator(CellField field) {
        this.field = field;
    }
        

    public void createNumericCells(ArrayList<Coordenate> builtCells) {

        int totalNumCells = field.getLvl().getColumns() * field.getLvl().getRows();

        ArrayList<Coordenate> newBuiltOnes;
        ArrayList<Coordenate> recentBuilt = new ArrayList<>();
        int i = 1;
        while (builtCells.size() < totalNumCells){
            
            for (Coordenate cell : builtCells){
                newBuiltOnes = this.createCellsNearBy(cell,i);
                this.addNewToPrevious(newBuiltOnes,recentBuilt);
            }
            this.addNewToPrevious(recentBuilt, builtCells);
            i++;
        }

        //Collections.sort(builtCells, new CoordenateComparator());
    }

    
    private ArrayList<Coordenate>
            createCellsNearBy(Coordenate originCell, int distance) {

        Coordenate limitTopLeft = getLimitTopLeft(field.getLvl().getRows()
                ,field.getLvl().getColumns(), originCell);
        Coordenate limitBottonRight = getLimitBottomDown(field.getLvl().getRows()
                ,field.getLvl().getColumns(), originCell);

        ArrayList<Coordenate> result = new ArrayList<>();

        for (int i = limitTopLeft.getRow(); i < limitBottonRight.getRow(); i++) {
            for (int j = limitTopLeft.getColumn(); j < limitBottonRight.getColumn(); j++) {
                
                if(field.getCellAt(new Coordenate (i,j)) != null){}
                else{
                   
                    Coordenate coord = new Coordenate(i,j);
                    NumericCell newNumCell = new NumericCell(coord,distance);
                    field.addCellAt(newNumCell, coord);
                    result.add(coord);
                }
            }
        }
        
        return result;
    }

    private void addNewToPrevious(ArrayList<Coordenate> littleArrayList,
            ArrayList<Coordenate> bigArrayList) {
        
        for (Coordenate newElement : littleArrayList) {
            bigArrayList.add(newElement);
        }
    }

    private Coordenate getLimitTopLeft(int rows, int columns, Coordenate originCell) {
        
        int x, y;
        
        if(originCell.getRow() == 0 || originCell.getRow() == rows)
            x = originCell.getRow();
        else 
            x = originCell.getRow() - 1;
        
        
        
        if(originCell.getColumn() == 0 || originCell.getColumn() == columns)
            y = originCell.getColumn();
        else 
            y = originCell.getColumn() - 1;
        
        
        return new Coordenate (x,y);
    }

    private Coordenate getLimitBottomDown(int rows, int columns, Coordenate originCell) {

        int x, y;
        
        if(originCell.getRow() == 0 || originCell.getRow() == rows)
            x = originCell.getRow();
        else 
            x = originCell.getRow() + 1;
        
        
        
        if(originCell.getColumn() == 0 || originCell.getColumn() == columns)
            y = originCell.getColumn();
        else 
            y = originCell.getColumn() + 1;
        
        
        return new Coordenate (x,y);
    }
}
