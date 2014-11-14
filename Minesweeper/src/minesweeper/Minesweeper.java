package minesweeper;

import Test.Test;
import model.Level;
import Presenter.modelInterface.MineCellCoordenatesCreator;
import java.util.ArrayList;
import model.Coordenate;

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
       
        randomMineGeneratorTest.execute();
        
       
    }

    
   
    
}
