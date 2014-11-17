package minesweeper;

import Presenter.modelInterface.CellFieldCreator;
import Test.Test;
import model.BasicLevel;
import model.Cell;
import model.NumericCell;

public class Minesweeper {

    public static void main(String[] args) {

        //randomMineGeneratorTest.execute(); //SUCESS 
        Test distanceAndMineDrawing = new Test() {

            @Override
            public void execute() {
                CellFieldCreator creator = new CellFieldCreator(
                        new BasicLevel());
                
                creator.createField();
                
                Cell[][] field = creator.getField().getCellMatrix();

                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field[0].length; j++) {
                        if (field[i][j] != null) {
                            if (field[i][j].isMine()) {
                                System.out.print("M");
                            } else {
                                System.out.print(((NumericCell) field[i][j]).getDistance());
                            }
                        }else{
                            System.out.print("NULL");
                        }
                    }

                    System.out.println("");
                }
            }
        };

        distanceAndMineDrawing.execute();

    }

}
