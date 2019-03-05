package GuitarShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuitarShopSimulator {
    public static void main(String [] args){
        Inventory inventory = new Inventory();
        initialiseInventory(inventory);

        Map properties = new HashMap();
        List results = new ArrayList();

        properties.put("builder", Builder.FENDER);
        properties.put("backWood", Wood.INDIAN_ROSEWOOD);

        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        results = inventory.search(clientSpec);

        for(int i = 0; i < results.size(); i++){
            Instrument instrument = (Instrument) results.get(i);

            System.out.println(instrument.getSerialNumber() + " " + instrument.getPrice() + "$ "
                    + instrument.getInstrumentSpec().getProperties());
        }

    }

    public static void initialiseInventory(Inventory inventory){
        Map properties = new HashMap();

        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("backWood", Wood.INDIAN_ROSEWOOD);
        inventory.addInstrument("1", 1234, new InstrumentSpec(properties));

        properties.clear();
        properties.put("instrumentType", InstrumentType.BONJO);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "POP11");
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("backWood", Wood.INDIAN_ROSEWOOD);
        inventory.addInstrument("2", 780, new InstrumentSpec(properties));

        properties.clear();
        properties.put("instrumentType", InstrumentType.MANDALIN);
        properties.put("builder", Builder.ANY);
        properties.put("model", "KI-123");
        properties.put("style", Style.F);
        properties.put("topWood", Wood.CEDAR);
        properties.put("backWood", Wood.INDIAN_ROSEWOOD);
        inventory.addInstrument("3", 4000, new InstrumentSpec(properties));

        properties.clear();
        properties.put("instrumentType", InstrumentType.DOBRO);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "F14");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("backWood", Wood.INDIAN_ROSEWOOD);
        inventory.addInstrument("4", 5123, new InstrumentSpec(properties));
    }
}