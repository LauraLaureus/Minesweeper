package model;

public class MineCell extends Cell {

    public MineCell(Coordenate coord){
        this.coord = coord;
    }
    
    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public void discover() {
        //TODO llamar al evento FINDEPARTIDA.
    }

}
