package GuitarShop;

public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS,
    OLSON, RYAN, PRS, ANY;

    public String toString(){
        switch(this){
            case ANY: return "any";
            case PRS: return "prs";
            case RYAN: return "ryan";
            case OLSON: return "olson";
            case FENDER: return "fender";
            case GIBSON: return "gibson";
            case MARTIN: return "martin";
            case COLLINGS: return "collings";

            default: return null;
        }
    }
}
