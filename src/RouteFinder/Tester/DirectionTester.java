package RouteFinder.Tester;

import RouteFinder.Loader.SubwayLoader;
import RouteFinder.Printer.SubwayPrinter;
import RouteFinder.Subway.Subway;

import java.io.*;

public class DirectionTester {
    public static void main(String [] args){
        Subway subway = new Subway();
        SubwayLoader subwayLoader = new SubwayLoader(subway);
        try {
            subwayLoader.loadFromFile(new File("./src/RouteFinder/Tester/Map.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream("route.txt");
            SubwayPrinter subwayPrinter = new SubwayPrinter(fileOutputStream);
            subwayPrinter.printDirections(subway.getDirections("Design Patterns Plaza", "SimUDuck Lake"));
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
