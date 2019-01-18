package pl.zpi.betta;

import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticMethods {
    private Map<String,Float> value = new LinkedHashMap<String,Float>();

    public StatisticMethods(Map<String,Float> newVal){
        value = newVal;
    }
    private void Sessions(){
        for(Map.Entry<String,Float> entry : value.entrySet()){

        }
    }
}
