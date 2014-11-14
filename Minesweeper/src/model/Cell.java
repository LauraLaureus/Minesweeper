package model;

public abstract class Cell {
    
    protected boolean discovered;
    protected boolean flagged;
    
    
    public abstract boolean isMine();
    
    
    public boolean isFlagged(){
        return this.flagged;
    }
    
    public void flag(){
        this.flagged = true;
    }
    
    public  void unflag(){
        this.flagged = false;
    }
    
    public boolean isDiscovered(){
        return this.discovered;
    }
    
    public abstract void discover();
   
    
    
}
