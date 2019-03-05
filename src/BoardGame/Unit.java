package BoardGame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Unit {
    private String type;
    private int id;
    private String name;
    private List<Weapon> weapons;
    private Map<String, Object> properties;

    public Unit(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProperty(String name, Object object) {
        if(properties == null) properties = new HashMap();
        properties.put(name, object);
    }

    public Object getProperty(String name) throws RuntimeException {
        if (properties == null) {
            throw new RuntimeException("Empty properties");
        }
        Object value = properties.get(name);
        if (value == null) {
            throw new RuntimeException("You're screwing up! No property value");
        }else return value;
    }

    public void addWeapon(Weapon weapon) {
        if(weapons == null) weapons = new LinkedList<>();
        weapons.add(weapon);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
}
