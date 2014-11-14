package model;

import java.util.Comparator;

public class CoordenateComparator implements Comparator<Coordenate> {

    @Override
    public int compare(Coordenate o1, Coordenate o2) {
        Coordenate origin = new Coordenate(0,0);
        return compareFrom(origin,o1,o2);
    }
    
    public int compareFrom(Coordenate origin, Coordenate o1, Coordenate o2){
        double vector1x = o1.getRow() - origin.getRow();
        double vector1y = o1.getColumn() - origin.getColumn();
        
        double vector1Module = Math.sqrt(vector1x*vector1x + vector1y*vector1y);
        
        double vector2x = o2.getRow() - origin.getRow();
        double vector2y = o2.getColumn() - origin.getColumn();
        
        double vector2Module = Math.sqrt(vector2x*vector2x + vector2y*vector2y);
        
        return Double.compare(vector1Module, vector2Module);
    }
}
