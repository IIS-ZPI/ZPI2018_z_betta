package pl.zpi.betta;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class DownloadDataTest {

//test - pobieranie danych z dnia  ------------------------------------------------------------------------------------------------------------------------------------------------------


    // test dla pobierania z api dla "gbp" - funt szerling
    @Test
    void testDownloadDataGbp() {
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-02/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.get("2012-01-02"));
        double x=  5.3480;  //sprawdzona na sztywno
        //System.out.println((float)x);
        assertEquals((float)x,map.get("2012-01-02"));
    }

    // test dla pobierania z api dla "EUR" - euro
    @Test
    void testDownloadDataEur() {
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/eur/2015-08-04/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.get("2015-08-04"));
        double x=  4.1463;  //sprawdzona na sztywno
        //System.out.println((float)x);
        assertEquals((float)x,map.get("2015-08-04"));
    }

    // test dla pobierania z api dla "RUB" - rubli rosyjskich
    @Test
    void testDownloadDataRub() {
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/rub/2017-08-11/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.get("2017-08-11"));
        double x=  0.0606;  //sprawdzona na sztywno
        //System.out.println((float)x);
        assertEquals((float)x,map.get("2017-08-11"));
    }


    // test dla pobierania z api dla "JPY" - jen japoński
    @Test
    void testDownloadDataJpy() {
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/jpy/2019-01-03/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map);
        //System.out.println(map.get("2019-01-03"));
        double x=  0.035132;  //sprawdzona na sztywno
        //System.out.println(x);
        assertEquals((float)x,map.get("2019-01-03"));
    }


//test - Sprawdzenie dla pobierania danych z tygodnia  -------------------------------------------------------------------------------------------------------------------------------------------
@Test
void weekDownloadTest(){
   // System.out.println("Pobieranie danych dla tygodnia");
    DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-08/");
    Map<String, Float> map = download.getValue();
    //System.out.println(map.size());
    int x = 5; // zliczone na sztywno
    assertEquals((float)x,map.size());
}

    //test - Sprawdzenie dla pobierania danych z dwóch tygodni  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void twoWeeksDownloadTest(){
     //   System.out.println("Pobieranie danych dla dwóch tygodni");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-15/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 10; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

//test - Sprawdzenie dla pobierania danych z miesiąca  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void monthDownloadTest(){
     //   System.out.println("Pobieranie danych dla miesiaca");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 22; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

    //test - Sprawdzenie dla pobierania danych z kwartału  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void quarterDownloadTest(){
     //   System.out.println("Pobieranie danych dla kwartału");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-03-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 64; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

    //test - Sprawdzenie dla pobierania danych z połowy roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void halfYearDownloadTest(){
        //System.out.println("Pobieranie danych dla połowy roku");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-06-30/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 125; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }


    //test - Sprawdzenie dla pobierania danych z  roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void yearDownloadTest(){
     //   System.out.println("Pobieranie danych dla roku");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 252; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

}