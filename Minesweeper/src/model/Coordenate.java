package model;

public class Coordenate implements Comparable{

    private final int row;
    private final int column;

    public Coordenate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Coordenate other = (Coordenate) obj;
        
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        if ( !(o instanceof Coordenate)) return -1;
        
        return new CoordenateComparator().compare(this, (Coordenate) o);
    }

    
}
