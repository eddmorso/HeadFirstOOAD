package DougsDogDoor;

import java.util.ArrayList;
import java.util.List;

public class DogDourSimulator {
    public static void main(String [] args){

        DogDoor door = new DogDoor();
        door.addBark(new Bark("woof"));
        door.addBark(new Bark("rowfl"));
        door.addBark(new Bark("rooowfl"));
        door.addBark(new Bark("rawfl"));

        Remote remote = new Remote(door);
        BarkRecognizer barkRecognizer = new BarkRecognizer(door);
        door.setCloseTime(1000);

        System.out.println("Flido wants outside");
        barkRecognizer.recognize(new Bark("rowfl"));
        //remote.pressButton();
        try{
            Thread.currentThread().sleep(10000);
        }catch (InterruptedException e){}

        System.out.println("Another dog starts barking");
        //remote.pressButton();
        barkRecognizer.recognize(new Bark("yip"));

        try{
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){}

        System.out.println("Flido starts barking again");
        barkRecognizer.recognize(new Bark("rawfl"));
    }
}
