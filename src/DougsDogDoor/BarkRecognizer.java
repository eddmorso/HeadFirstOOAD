package DougsDogDoor;

public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer (DogDoor door){
        this.door = door;
    }

    public void recognize(Bark neededBark) {

        System.out.println(" BarkRecognizer heard a '" + neededBark.getContents() + "'");

        for (Bark bark : door.getBark()) {
            if (neededBark.equals(bark)) {
                door.open();
                return;
            }
        }
        if(!door.isOpen()) System.out.println("not allowed bark");
    }
}
