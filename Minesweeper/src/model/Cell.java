package model;

import java.util.ArrayList;
import static model.Status.*;

public class Cell {

    private ArrayList<Cell> neighbours;
    private Mine mine;
    private Status status;
    private int minesSurroundingMe;

    public Cell() {
        this.status = NONE;
    }

    public boolean hasMine() {
        return mine != null;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setNeighbours(ArrayList<Cell> neighbours) {
        this.neighbours = neighbours;
        this.minesSurroundingMe = mineDetector();
    }

    public void setMine() {
        this.mine = new Mine();
    }

    
    private int mineDetector() {
        int result = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.hasMine()) {
                result++;
            }
        }
        return result;
    }

    public int getMinesSurroundingMe() {
        return minesSurroundingMe;
    }
    
    

}
