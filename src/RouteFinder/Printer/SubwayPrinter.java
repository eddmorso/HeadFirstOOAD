package RouteFinder.Printer;

import RouteFinder.Subway.Connection;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {
    private PrintStream out;

    public SubwayPrinter(OutputStream out){
        this.out = new PrintStream(out);
    }

    public void printDirections(List route){
        final String ARROW = " ---> ";

        Connection firstConnection = (Connection) route.get(0);
        out.println("Start of from the station " + firstConnection.getStation1().getName() + " on the line " + firstConnection.getLineName());
        out.print(ARROW + firstConnection.getStation2().getName() + ARROW);

        String line = firstConnection.getLineName();

        for(int i = 1; i < route.size(); i++){
            Connection connection = (Connection) route.get(i);

            if(connection.getLineName().equalsIgnoreCase(line)) {
                if(i == route.size() - 1){
                    out.print(connection.getStation2().getName());
                }else
                out.print(connection.getStation2().getName() + ARROW);
            }else{
                if(i == route.size() - 1){
                    out.println("Change line to " + connection.getLineName());
                    out.print(ARROW + connection.getStation2().getName());
                }else {
                    out.println("Change line to " + connection.getLineName());
                    out.print(ARROW + connection.getStation2().getName() + ARROW);
                    line = connection.getLineName();
                }
            }
        }
    }
}
