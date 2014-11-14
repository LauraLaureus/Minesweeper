package model;

public class NumericCell extends Cell{

    public NumericCell(Coordenate coord){
        this.coord = coord;
    }
    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public void discover() {
    }
    
}
