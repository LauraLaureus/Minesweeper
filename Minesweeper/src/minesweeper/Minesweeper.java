package minesweeper;

import Presenter.modelInterface.CellFieldCreator;
import Test.Test;
import model.Level;
import Presenter.modelInterface.MineCellCreator;
import java.util.ArrayList;
import model.Cell;
import model.CellField;
import model.Coordenate;
import model.NumericCell;

public class Minesweeper {

    public static void main(String[] args) {
    
        
       
        //randomMineGeneratorTest.execute(); //SUCESS 
        
        Test distanceAndMineDrawing = new Test() {

            @Override
            public void execute() {
                CellFieldCreator creator = new CellFieldCreator(
                new Level(Level.BASIC));
                
                Cell[][] field = creator.getField().getCellMatrix();
                
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field[0].length; j++) {
                        
                        if(field[i][j].isMine())
                            System.out.print("M");
                        else
                            System.out.print(((NumericCell)field[i][j]).getDistance());
                        
                    }
                    
                    System.out.println("");
                }
            }    
        };
        
        distanceAndMineDrawing.execute();
        
       
    }

    
   
    
}
