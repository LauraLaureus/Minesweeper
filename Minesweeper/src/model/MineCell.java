package model;

public class MineCell extends Cell {

    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public void discover() {
        //TODO llamar al evento FINDEPARTIDA.
    }

}
