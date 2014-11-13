package model;

public abstract class Cell {
    
    protected boolean locked;
    protected boolean flagged;
    
    public abstract boolean isMine();
    public abstract boolean islocked();
    public abstract void flag();
    public abstract void unflag();
    
    
}
