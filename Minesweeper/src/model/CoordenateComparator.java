package model;

import java.util.Comparator;

public class CoordenateComparator implements Comparator<Coordenate> {

    @Override
    public int compare(Coordenate o1, Coordenate o2) {

        int compareRow = compareRow(o1, o2);

        if (Math.abs(compareRow) == 1) {
            return compareRow;
        } else {
            return compareColumn(o1, o2);
        }
    }

    private int compareRow(Coordenate o1, Coordenate o2) {
        int diffRow = o1.getRow() - o2.getRow();
        if (diffRow < 0) {
            return -1;
        } else if (diffRow > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    private int compareColumn(Coordenate o1, Coordenate o2) {
        int diffColumn = o1.getColumn() - o2.getColumn();
        if (diffColumn < 0) {
            return -1;
        } else if (diffColumn > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
