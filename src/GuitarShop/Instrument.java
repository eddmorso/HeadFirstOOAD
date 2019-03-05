package GuitarShop;

public class Instrument {
    private String serialNumber;
    private double price;
    InstrumentSpec instrumentSpec;

    public Instrument(String serialNumber, double price, InstrumentSpec instrumentSpec){
        this.serialNumber = serialNumber;
        this.instrumentSpec = instrumentSpec;
        this.price = price;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InstrumentSpec getInstrumentSpec() {
        return instrumentSpec;
    }
}
