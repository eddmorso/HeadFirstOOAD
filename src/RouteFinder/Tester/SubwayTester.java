package RouteFinder.Tester;

import RouteFinder.Loader.SubwayLoader;
import RouteFinder.Printer.SubwayPrinter;
import RouteFinder.Subway.Subway;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SubwayTester {
    public static void main (String [] args){
//        args = new String[2];
//
//        args[0] = "Ajax Rapids";
//        args[1] = "Break Neck Pizza";

        if(args.length != 2){
            System.err.println("Usage: SubwayTester [firstStation][secondStation]");
            System.exit(-1);
        }
        try {
            Subway objectVille = new Subway();
            SubwayLoader subwayLoader = new SubwayLoader(objectVille);
            subwayLoader.loadFromFile(new File("./src/RouteFinder/Tester/Map.txt"));

            if (!objectVille.hasStation(args[0])) {
                System.err.print(args[0] + " is not a station in ObjectVille");
                System.exit(-1);
            }else if (!objectVille.hasStation(args[1])) {
                System.err.print(args[0] + " is not a station in ObjectVille");
                System.exit(-1);
            }

            List route = objectVille.getDirections(args[0], args[1]);

            SubwayPrinter subwayPrinter = new SubwayPrinter(System.out);

            subwayPrinter.printDirections(route);

        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}
