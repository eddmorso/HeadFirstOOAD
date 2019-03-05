package BoardGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
    private int width, height;
    private List<List<Tile>> tiles;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        initialise();
    }

    public Tile getTile(int x, int y){
        return tiles.get(x).get(y);
    }


    public void addUnit(Unit unit, int x, int y){
        Tile tile = getTile(x,y);
        tile.addUnit(unit);
    }

    public List<Unit> getUnits(int x, int y){
        return tiles.get(x).get(y).getUnits();
    }

    public void removeUnits(int x, int y){
        Tile tile = getTile(x, y);
        tile.removeUnits();
    }
    public void removeUnit(Unit unit, int x, int y){
        Tile tile = getTile(x, y);
        tile.removeUnit(unit);
    }
    private void initialise(){
        tiles = new ArrayList<>(width);

        for(int i = 0; i < width; i++){
            tiles.add(i, new ArrayList<Tile>(height));
            for(int j = 0; j < height; j++){
                tiles.get(i).add(j, new Tile());
            }
        }
    }
}
