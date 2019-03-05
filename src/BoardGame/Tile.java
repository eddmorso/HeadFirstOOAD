package BoardGame;

import java.util.LinkedList;
import java.util.List;

public class Tile {
    List<Unit> units;

    public Tile(){
        units = new LinkedList<>();
    }

    protected void addUnit(Unit unit){
        units.add(unit);
    }

    protected void removeUnit(Unit unit){
        units.remove(unit);
    }

    protected List<Unit> getUnits(){
        return units;
    }

    protected void removeUnits(){
        units.clear();
    }
}
