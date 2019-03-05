package GuitarShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List instruments;

    public Inventory(){
        instruments = new LinkedList();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec){
        Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber){
        Instrument neededInstrument;
        if(!instruments.isEmpty()){
            for(Iterator iterator = instruments.iterator(); iterator.hasNext(); ){
                Instrument instrument = (Instrument) iterator.next();
                if(instrument.getSerialNumber().equals(serialNumber)){
                    neededInstrument = instrument;
                    return neededInstrument;
                }
            }
        }
        return null;
    }

    public List search(InstrumentSpec searchSpec) {

        List neededInstruments = new LinkedList();

        for (int i = 0; i < instruments.size(); i++) {
            Instrument instrument = (Instrument) instruments.get(i);
            if (instrument.getInstrumentSpec().matches(searchSpec))
                neededInstruments.add(instrument);
        }
        return neededInstruments;
    }
}
