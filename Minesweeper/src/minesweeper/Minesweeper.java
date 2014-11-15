package minesweeper;

import Presenter.modelInterface.CellFieldCreator;
import Test.Test;
import model.Level;
import Presenter.modelInterface.MineCellCoordenatesCreator;
import java.util.ArrayList;
import model.Cell;
import model.CellField;
import model.Coordenate;
import model.NumericCell;

public class Minesweeper {

    public static void main(String[] args) {
    
        Test randomMineGeneratorTest = new Test() {

            
            @Override
            public void execute() {
                Level basic = new Level(Level.BASIC);
                ArrayList<Coordenate> returned = 
                        MineCellCoordenatesCreator.createCorrdenates(basic);
                
                int i = 0;
                for (Coordenate coord : returned) {
                    System.out.println( "Coordenadas:" +
                            "X: " +  coord.getRow() +
                            " Y: " + coord.getColumn());
                }
            }
        };
       
        //randomMineGeneratorTest.execute(); //SUCESS 
        
        Test distanceAndMineDrawing = new Test() {

            @Override
            public void execute() {

                CellFieldCreator creator = new CellFieldCreator(
                    new Level(Level.BASIC));
                CellField field = creator.getField();
                Cell[][] cellMatrix = field.getCellMatrix();
                
                for (Cell[] cellMatrixRow : cellMatrix) {
                    for (Cell cell : cellMatrixRow) {
                        if (cell.isMine())
                            System.out.print(true + " ");
                        else
                            System.out.println(((NumericCell)cell).getDistance()
                             + " ");
                    }
                    System.out.println("");
                }
                
            }
        };
        
        distanceAndMineDrawing.execute();
        
       
    }

    
   
    
}
