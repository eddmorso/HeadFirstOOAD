package RouteFinder.Subway;

public class Station {
    String name;

    public Station(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj){
        if(obj instanceof Station){
            Station otherStation = (Station) obj;
            return otherStation.getName().equalsIgnoreCase(name);
        }
        return false;
    }

    public int hashCode(){
        return name.toLowerCase().hashCode();
    }
}
