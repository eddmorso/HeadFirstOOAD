package RouteFinder.Subway;

import java.util.*;

public class Subway {
    private List<Station> stations;
    private List<Connection> connections;

    public Subway(){
        stations = new LinkedList<>();
        connections = new LinkedList<>();
    }

    public void addStation(String newStation){
        if(hasStation(newStation)) {
            System.out.println("Station already exists");
        }else stations.add(new Station(newStation));
    }

    public void addConnection(String station1Name, String station2Name, String lineName){
        if(hasStation(station1Name) && hasStation(station2Name)){
            Station station1 = new Station(station1Name);
            Station station2 = new Station(station2Name);

            Connection connection = new Connection(station1, station2,lineName);
            connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));
        }else{
            System.out.println("Invalid stations");
        }
    }

    public boolean hasStation(String stationName){
        return stations.contains(new Station(stationName));
    }

    public boolean hasConnection(String station1Name, String station2Name, String lineName){

        Station station1 = new Station(station1Name);
        Station station2 = new Station(station2Name);

        for(Connection connection : connections) {
            if (connection.getLineName().equalsIgnoreCase(lineName)) {
                if (connection.getStation1().equals(station1) && connection.getStation2().equals(station2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Station> getStations() {
        return stations;
    }
}
