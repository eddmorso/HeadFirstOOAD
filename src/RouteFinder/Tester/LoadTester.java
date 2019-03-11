package RouteFinder.Tester;

import RouteFinder.Loader.SubwayLoader;
import RouteFinder.Subway.Connection;
import RouteFinder.Subway.Station;
import RouteFinder.Subway.Subway;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadTester {
    public static void main(String [] args){
        File loadFile = new File("./src/RouteFinder/Tester/Map.txt");

        Subway subway = new Subway();

        SubwayLoader subwayLoader = new SubwayLoader(subway);
        try {
            subway = subwayLoader.loadFromFile(loadFile);
        }catch (IOException e){
            System.out.println(e);
        }
        printSubwayTest(subway);
    }


    private static boolean loadSuccessTest(Subway subway){
        return subway.hasStation("XHTML Expressway") &&
                    subway.hasConnection("LSP Lane", "Ajax Rapids", "Booch Line") &&
                        subway.hasStation("LSP Lane");
    }

    private static void printSubwayTest(Subway subway) {
        for (Station station : subway.getStations()) {
            System.out.println(station.getName());
        }
        System.out.println();

        List<Connection> connections = subway.getConnections();
        List<Station> stations = new ArrayList<>();

        String line = connections.get(0).getLineName();
        System.out.println(line);

        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).getLineName().equalsIgnoreCase(line)) {
                if (!stations.contains(connections.get(i).getStation1())) {
                    stations.add(connections.get(i).getStation1());
                }
            } else {
                line = connections.get(i).getLineName();

                System.out.println(stations);

                stations.clear();

                stations.add(connections.get(i).getStation1());

                System.out.println();
                System.out.println(line);
            }
        }
        System.out.println(stations);

    }
}
