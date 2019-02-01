package pl.zpi.betta;

import javax.print.attribute.standard.MediaName;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

import static java.util.Collections.sort;

public class StatisticMethods {
    private Map<String,Float> value = new LinkedHashMap<String,Float>();
    private ArrayList<Float> vals = new ArrayList<Float>();
    private int wzrostowa =0;
    private int spadkowa =0;
    private int stala = 0;
    private String currency = "";

    //w konstruktorze nalezy przekazac MAP z danymi!
    public StatisticMethods(Map<String,Float> newVal, String currency){
        this.currency = currency;
        updateMap(newVal);
    }

    public StatisticMethods(Map<String,Float> newVal){
        updateMap(newVal);
    }

    //I hope it get up!

    public String getCurrency() {
        return currency;
    }

    //nalezy najpierw odpalic sessions, potem zgetowac paramtery
    public void sessions(){
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
        return wzrostowa +1 ;
    }
    public int getSpadkowa(){
        return spadkowa;
    }
    public int getStala(){
        return stala;
    }

    public void updateMap(Map<String,Float>newVal){
        value = newVal;
        updateVals();
    }
    public void updateVals(){
        //System.out.println("Update vals!");
        for(Map.Entry<String,Float> entry : value.entrySet()){
            //System.out.println(entry.getValue());
            Float tmp = (float) Math.round(entry.getValue() * 10000) / 10000;
            vals.add(tmp);
            //System.out.println(tmp);
        }
    }
    //mediana
    public double getMedian(){
        vals.sort((Float f1, Float f2)-> f1.compareTo(f2));

        double median = 0;
        float pos1 = (float) Math.floor((vals.size()-1) / 2.0);
        float pos2 = (float) Math.ceil((vals.size()-1) / 2.0);
        if (pos1 == pos2 ) {
            median = vals.get((int)pos1);
        } else {
            median = (vals.get((int)pos1) + vals.get((int)pos2)) / 2.0 ;
        }
        return (double)Math.round( median * 10000) / 10000 ;
    }

    //dominanta
    public Float getMode(){
        float maxValue = 0;
        int maxCount = 0, i, j;

        for (i = 0; i < vals.size(); ++i) {
            int count = 0;
            for (j = 0; j < vals.size(); ++j) {
                //System.out.println(vals.get(j));
                //System.out.println();
                //System.out.println(vals.get(i));
                if ((vals.get(j).equals(vals.get(i))) && (i != j))
                    ++count;
            }
            //System.out.println(count);
            if (count > maxCount && count > 1) {
                //System.out.println(i);
                //System.out.println(vals.get(i));
                maxCount = count;
                maxValue = vals.get(i);
            }
        }
        return maxValue;
    }

    //odchylenie standardowe
    public Float getStandardDev(){
        float standardDeviation = (float) 0.0;
        int length = vals.size();

        float mean = getMean();

        for(float num: vals) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return (float)Math.round( Math.sqrt(standardDeviation/length) * 10000) / 10000;
    }

    //srednia
    public Float getMean(){
        float sum =0;
        for(float num : vals){
            sum += num;
        }
        return sum / vals.size();
    }
    //wspolczynnik zmiennosci
    public Float getVariationCoefficient(){
        return (float)Math.round((getStandardDev()/getMean())*10000)/100;
    }

}
