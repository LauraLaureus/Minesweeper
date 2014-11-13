package model;

public class MineCell extends Cell{

    private boolean discovered;

    public MineCell() {
        this.discovered = false;
    }
    
    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public boolean islocked() {
        return false;
    }

    @Override
    public void flag() {
        this.flagged = true;
    }

    @Override
    public void unflag() {
        this.flagged = false;
    }
   
    public boolean isDiscovered(){
        return this.discovered;
    }
    
    public void discover(){
        this.discovered = true;
    }
}
