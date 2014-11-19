package model;

import java.util.ArrayList;
import static model.Status.*;

public class Cell {
    
    private ArrayList<Cell> neighbours;
    private Mine mine;
    private Status status;
    private int minesSurroundingMe;

    
    public Cell(ArrayList<Cell> neighbours, Mine mine) {
        this.neighbours = neighbours;
        this.mine = mine;
        this.status = NONE;
        this.minesSurroundingMe = mineDetector();
    }
    
    public boolean hasMine(){
        return mine != null;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private int mineDetector() {
        int result = 0;
        for (Cell neighbour : neighbours) {
            if(neighbour.hasMine()) result++;          
        }
        return result;
    }
    
    
    
    
}
