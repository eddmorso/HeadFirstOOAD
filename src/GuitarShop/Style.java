package GuitarShop;

public enum Style {

    F, A;

    @Override
    public String toString() {
        switch (this){
            case A: return "a";
            case F: return "f";

            default: return null;
        }
    }
}
