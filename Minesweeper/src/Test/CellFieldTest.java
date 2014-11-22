package Test;

import model.BasicLevel;
import model.Cell;
import model.CellField;

public class CellFieldTest implements Test {

    @Override
    public void execute() {

        CellField field  = new CellField(new BasicLevel());
        
        Cell[][] matrix = field.getField();
        Cell current;
        
        printLineReference();
        for (int row = 0; row < matrix.length; row++) {
            
            System.out.print(row);
            
            for (int column = 0; column < matrix[0].length; column++) {

                current = matrix[row][column];
                
                if(current.hasMine()) System.out.print(" M ");
                else System.out.print(" " + 
                        current.getMinesSurroundingMe() + " ");
            }
            System.out.println("");
        }
    }

    private void printLineReference() {
        for (int i = 0; i < 8; i++) {
            System.out.print (" " + i + " ");
        }
        System.out.println("");
    }
    
}
