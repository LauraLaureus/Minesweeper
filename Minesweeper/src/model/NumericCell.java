package model;

public class NumericCell extends Cell{
    
    private  int distance;

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

    public void setDistance(int distance) {
        this.distance = distance;
    }

    
    
}
