package DougsDogDoor;

public class Bark {

    private String contents;

    public Bark (String contents){
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public boolean equals(Object bark){
        if(bark instanceof Bark) {
            Bark otherBark = (Bark) bark;
            if(this.contents.equalsIgnoreCase(otherBark.contents)){
                return true;
            }
        }
        return false;
    }
}
