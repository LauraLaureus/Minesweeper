package model;

public class NumericCell extends Cell{
    
    private final int distance;

    public NumericCell(Coordenate coord, int distance){
        this.coord = coord;
        this.distance = distance;
    }
    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public void discover() {
    }

    public int getDistance() {
        return distance;
    }

    
    
}
