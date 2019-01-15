package pl.zpi.betta;

import java.text.NumberFormat;
import java.util.Locale;

public class Item {
    private String effectiveDate;
    private float mid;

    public Item() {


    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance( new Locale("US"));
        nf.setMinimumFractionDigits(4);
//        String s = nf.format(Float.toString(mid));
        return  effectiveDate + nf.format(mid);
    }
}
