package Test;

import java.util.ArrayList;
import java.util.Collections;
import model.Coordenate;
import model.CoordenateComparator;

//SUCESS
public class CoordenateComparatorTest implements Test {

    public CoordenateComparatorTest() {
    }

    
    @Override
    public void execute() {

        ArrayList<Coordenate> example = new ArrayList<>();
        
        int[][] examples = {{7,7},{6,6},{5,5},{4,4},{3,3},{2,2},{1,1},{0,0},{8,8},{9,9}};
        
        for (int i = 0; i < examples.length; i++) {
            example.add(new Coordenate(examples[i][0], examples[i][1]));
        }

        Collections.sort(example , new CoordenateComparator());
        
        for (Coordenate coord : example) {
            
            System.out.println("X: " + coord.getRow() + "Y: " + coord.getColumn());
        }
    }

    
}
