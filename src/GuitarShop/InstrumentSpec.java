package GuitarShop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
    private Map properties;

    public InstrumentSpec(Map properties){
        if(properties == null){
            this.properties = new HashMap();
        }else{
            this.properties = new HashMap(properties);
        }
    }

    public Map getProperties() {
        return properties;
    }

    public Object getProperty(String propertyName){
        return properties.get(propertyName);
    }

    public boolean matches(InstrumentSpec searchSpec){
        for(Iterator iterator = searchSpec.getProperties().keySet().iterator(); iterator.hasNext(); ){
            String propertyName = (String) iterator.next();
            if(!properties.get(propertyName).equals(searchSpec.getProperties().get(propertyName)))
                return false;
        }
        return true;
    }
}