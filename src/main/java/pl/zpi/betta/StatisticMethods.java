package pl.zpi.betta;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticMethods {
    private Map<String,Float> value = new LinkedHashMap<String,Float>();
    private int wzrostowa =0;
    private int spadkowa =0;
    private int stala = 0;

    //w konstruktorze nalezy przekazac MAP z danymi!
    public StatisticMethods(Map<String,Float> newVal){
        value = newVal;
    }

    //I hope it get up!

    //nalezy najpierw odpalic sessions, potem zgetowac paramtery
    public void Sessions(){
        Iterator<Map.Entry<String,Float>> it = value.entrySet().iterator();
        Map.Entry<String,Float>aktualnaPara = it.next();
        Map.Entry<String,Float>nastepna = it.next();
        while(it.hasNext()){
            Float wynik = nastepna.getValue() - aktualnaPara.getValue();
            if(wynik > 0)
                wzrostowa++;
            else if (wynik < 0)
                spadkowa++;
            else
                stala++;
            aktualnaPara = nastepna;
            nastepna = it.next();
        }
    }
    public int getWzrostowa(){
        return wzrostowa;
    }
    public int getSpadkowa(){
        return spadkowa;
    }
    public int getStala(){
        return stala;
    }
}
