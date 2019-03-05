package GuitarShop;

public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
    COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

    public String toString(){
        switch(this){
            case INDIAN_ROSEWOOD: return "indian rosewood";
            case ALDER: return "alder";
            case CEDAR: return "cedar";
            case MAPLE: return "maple";
            case SITKA: return "sitka";
            case COCOBOLO: return "cocobolo";
            case MAHOGANY: return "mahogany";
            case ADIRONDACK: return "adirondack";
            case BRAZILIAN_ROSEWOOD: return "brazilian rosewood";

            default: return null;
        }
    }
}
