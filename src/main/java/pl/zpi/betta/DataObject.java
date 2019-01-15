package pl.zpi.betta;


import java.util.List;

public class DataObject {
        public char table;
        public String currency;
    public List<Item> rates;

    @Override
    public String toString() {
        return table + " - " + currency + rates;
    }
}
