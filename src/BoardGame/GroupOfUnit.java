package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class GroupOfUnit {
    private List<Unit> units;

    public GroupOfUnit(List<Unit> units){
        this.units = new ArrayList<>(units);
    }

    public GroupOfUnit(){
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit){
        units.add(unit);
    }

    public void removeUnit(int id) throws RuntimeException{
        for(int i = 0; i < units.size(); i++){
            if (units.get(i).getId() == id) {
                units.remove(i);
                return;
            }
        }
        throw new RuntimeException("no such unit in group");
    }

    public void removeUnit(Unit unit) throws RuntimeException{
        for(int i = 0; i < units.size(); i++){
            if(units.get(i).equals(unit)){
                units.remove(i);
                return;
            }
        }
        throw new RuntimeException("no such unit in group");
    }

    public List<Unit> getUnits() throws RuntimeException{
        if(units.isEmpty()) throw new RuntimeException("Group is empty");
        return units;
    }
}
