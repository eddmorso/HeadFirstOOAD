package GuitarShop;

public enum  InstrumentType {
    GUITAR, BONJO, MANDALIN, DOBRO, FIDDLE;

    @Override
    public String toString() {
        switch (this){
            case BONJO: return "bonjo";
            case DOBRO: return "dobro";
            case FIDDLE: return "fiddle";
            case GUITAR: return "guitar";
            case MANDALIN: return "mandalin";

            default: return "unspecified";
        }
    }
}
