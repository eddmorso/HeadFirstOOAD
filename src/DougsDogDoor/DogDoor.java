package DougsDogDoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;
    private int closeTime;
    private List<Bark> bark;

    public DogDoor(){
        bark = new ArrayList<>();
        this.open = false;
    }

    public void open() {
        System.out.println("Door's opened");
        open = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, closeTime);
    }

    public void close(){
        System.out.println("Door's closed automatically");
        open = false;
    }

    public boolean isOpen(){
        return open;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public void addBark(Bark bark){
        this.bark.add(bark);
    }

    public List<Bark> getBark() {
        return bark;
    }
}
