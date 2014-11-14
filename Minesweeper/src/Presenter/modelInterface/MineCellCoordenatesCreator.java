package Presenter.modelInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import model.Coordenate;
import model.CoordenateComparator;
import model.Level;

class MineCellCoordenatesCreator {

    public static ArrayList<Coordenate> createCorrdenates(Level lvl) {
        TreeSet<Coordenate> result = new TreeSet<>();

        while (result.size() < lvl.getMines()) {
            result.add(createCoordenate(lvl.getRows(), lvl.getColumns()));
        }

        ArrayList<Coordenate> resultArray = new ArrayList<>(result);
        Collections.sort(resultArray, new CoordenateComparator());
        
        return resultArray;
    }

    private static Coordenate createCoordenate(int row, int column) {
        int x = (int) (Math.random() * (double) row);
        int y = (int) (Math.random() * (double) column);

        Coordenate newCoord = new Coordenate(x, y);
        return newCoord;
    }

}
