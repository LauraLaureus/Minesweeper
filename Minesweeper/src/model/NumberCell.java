package model;

public class NumberCell extends Cell {

    private int distance;

    public NumberCell() {
        this.distance = 0;
        this.flagged = false;
        this.locked = false;
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public boolean islocked() {
        return this.locked;
    }

    @Override
    public void flag() {
        this.flagged = true;
    }

    @Override
    public void unflag() {
        this.flagged = false;
    }

    public void setDistance(int newDistance) {
        this.distance = newDistance;
    }

    public int getDistance() {
        return distance;
    }

    public void lock() {
        this.locked = true;
    }
    
    public void unlock(){
        this.locked = false;
    }

}
