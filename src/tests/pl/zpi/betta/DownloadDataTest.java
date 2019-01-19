package pl.zpi.betta;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DownloadDataTest {


    // test dla pobierania z api
    @Test
    void testDownloadData() {
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-02/");
        Map<String, Float> map = download.getValue();
        double x=  5.3480;  //sprawdzona na sztywno
        //System.out.println((float)x);
        assertEquals((float)x,map.get("2012-01-02"));
    }

}