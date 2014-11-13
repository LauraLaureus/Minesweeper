package minesweeper;

/**
 *
 * @author Laura
 */
public class Minesweeper {

    public static void main(String[] args) {
        
        PlayCommand.execute(GameFactory.getNewGame());
        /*TODO
        Se llama a GameFactory para que gener todos los datos de la partida.
        Se llama al procedimiento jugar.
        */
    }
    
}
