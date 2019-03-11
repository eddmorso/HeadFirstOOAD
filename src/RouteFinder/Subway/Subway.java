package RouteFinder.Subway;

import java.util.*;

public class Subway {
    private List<Station> stations;
    private List<Connection> connections;
    private Map network;

    public Subway(){
        stations = new LinkedList<>();
        connections = new LinkedList<>();
        this.network = new HashMap();
    }

    public void addStation(String newStation){
        if(hasStation(newStation)) {
            System.out.println("Station " + newStation + " already exists");
        }else stations.add(new Station(newStation));
    }

    public void addConnection(String station1Name, String station2Name, String lineName){
        if(hasStation(station1Name) && hasStation(station2Name)){
            Station station1 = new Station(station1Name);
            Station station2 = new Station(station2Name);

            Connection connection = new Connection(station1, station2,lineName);
            connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));

            addToNetwork(station1, station2);
            addToNetwork(station2, station1);
        }else{
            throw  new RuntimeException("Invalid connection");
        }
    }

    private void addToNetwork(Station station1, Station station2){
        if(network.keySet().contains(station1)){
            List connectingStations = (List) network.get(station1);
            if(!connectingStations.contains(station2)){
                connectingStations.add(station2);
            }
        }else{
            List connectingStatons = new LinkedList();
            connectingStatons.add(station2);
            network.put(station1, connectingStatons);
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

    public List getDirections(String startStationName, String endStationName){
        if(!this.hasStation(startStationName) || !this.hasStation(endStationName)){
            throw new RuntimeException("Station entered do not exist on this subway");
        }

        Station start = new Station(startStationName);
        Station end = new Station(endStationName);

        List route = new LinkedList();
        List reachableStations = new LinkedList();
        Map previousStations = new HashMap();

        List neighbors = (List) network.get(start);
        for(Iterator iterator = neighbors.iterator(); iterator.hasNext(); ){
            Station station = (Station) iterator.next();
            if(station.equals(end)){
                route.add(getConnection(start, end));
                return route;
            }else{
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }

        List nextStaions = new LinkedList();
        nextStaions.addAll(neighbors);
        Station currentStation = start;

        searchLoop:
        for(int i = 1; i < stations.size(); i++){
            List tmpNextStations = new LinkedList();

            for(Iterator j = nextStaions.iterator(); j.hasNext(); ){
                Station station = (Station) j.next();
                reachableStations.add(station);
                currentStation = station;
                List currentNeighbors = (List)network.get(currentStation);

                for(Iterator k = currentNeighbors.iterator(); k.hasNext(); ){
                    Station neighbor = (Station) k.next();

                    if(neighbor.equals(end)){
                        reachableStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                        break searchLoop;
                    }else if(!reachableStations.contains(neighbor)){
                        reachableStations.add(neighbor);
                        tmpNextStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                    }
                }
            }
            nextStaions = tmpNextStations;
        }

        boolean keepLooping = true;
        Station keyStation = end;
        Station station;

        while(keepLooping){
            station = (Station)previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            if(start.equals(station)){
                keepLooping = false;
            }
            keyStation = station;
        }
        return route;
    }

    private Connection getConnection(Station station1, Station station2){
        for(Iterator iterator = connections.iterator(); iterator.hasNext(); ){
            Connection connection = (Connection) iterator.next();

            Station one = connection.getStation1();
            Station two = connection.getStation2();

            if((station1.equals(one) && (station2.equals(two)))){
                return connection;
            }
        }
        return null;
    }
}
