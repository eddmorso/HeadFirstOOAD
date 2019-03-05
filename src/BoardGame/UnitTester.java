package BoardGame;
import java.util.List;

public class UnitTester {

    public static void main(String [] args){
        Unit unit = new Unit(1);
        Unit unit1 = new Unit(2);
        Unit unit2 = new Unit(3);
        Unit unit3 = new Unit(4);

        GroupOfUnit groupOfUnit = new GroupOfUnit();

        addUnitToGroupOfUnits(unit, groupOfUnit);
        addUnitToGroupOfUnits(unit1, groupOfUnit);
        addUnitToGroupOfUnits(unit2, groupOfUnit);
        removeUnitFromGroupOfUnitsById(unit1, groupOfUnit);
        removeUnitFromGroupOfUnitsByObj(unit2, groupOfUnit);
        throwNoSuchUnitExceptionRemovingTheUnit(unit3, groupOfUnit);

        System.out.println(groupOfUnit.getUnits());
    }

    public static void commonPropertyTest(Unit unit, String property, String propertyValue) {
        unit.setProperty(property, propertyValue);
            if (unit.getProperty(property).equals(propertyValue)) {
                System.out.println("Test passed");
            } else System.out.println("Test failed");
    }

    public static void specificPropertyTest(Unit unit, String property, String propertyValue){
        unit.setProperty(property, propertyValue);
        if(unit.getProperty(property).equals(propertyValue)){
            System.out.println("Test passed");
        }else System.out.println("Test failed");
    }

    public static void rewritingPropertyTest(Unit unit, String property, String propertyValue){
        unit.setProperty(property, propertyValue);
        if(unit.getProperty(property).equals(propertyValue)){
            System.out.println("Test passed");
        }else System.out.println("Test failed");
    }

    public static void nonExistentPropertyTest(Unit unit, String property) {
        try {
            Object value = unit.getProperty(property);
        }catch (RuntimeException e){
            System.out.println(e + " Test passed");
            return;
        }
        System.out.println("Test failed");
    }

    public static void addUnitToGroupOfUnits(Unit unit, GroupOfUnit groupOfUnit){
        groupOfUnit.addUnit(unit);

        List<Unit> units = groupOfUnit.getUnits();

        for(int i = 0; i < units.size(); i++){
            if(units.get(i).getId() == unit.getId()){
                System.out.println("Test passed");
                return;
            }
        }
        System.out.println("Test failed");
    }

    public static void removeUnitFromGroupOfUnitsById(Unit unit, GroupOfUnit groupOfUnit){
        groupOfUnit.removeUnit(unit.getId());

        List<Unit> units = groupOfUnit.getUnits();

        for(int i = 0; i < units.size(); i++){
            if(units.get(i).getId() == unit.getId()){
                System.out.println("Test failed");
                return;
            }
        }
        System.out.println("Test passed");
    }

    public static void removeUnitFromGroupOfUnitsByObj(Unit unit, GroupOfUnit groupOfUnit){
        groupOfUnit.removeUnit(unit);

        List<Unit> units = groupOfUnit.getUnits();

        for(int i = 0; i < units.size(); i++){
            if(units.get(i).getId() == unit.getId()){
                System.out.println("Test failed");
                return;
            }
        }
        System.out.println("Test passed");
    }

    public static void throwNoSuchUnitExceptionRemovingTheUnit(Unit unit, GroupOfUnit groupOfUnit){
        try {
            groupOfUnit.removeUnit(unit.getId());
            System.out.println("Test failed");
        }catch (RuntimeException e){
            System.out.println(e + " Test passed");
            return;
        }
    }
}
