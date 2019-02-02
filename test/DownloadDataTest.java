package pl.zpi.betta;

import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;



class DownloadDataTest {


    private final long MAX_TIME_DOWNLOAD=2000; //2 sekundy w ms
    boolean flagaFalseB = false;


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
        double x=  0.0351;  //sprawdzona na sztywno
        //System.out.println(x);
        assertEquals((float)x,map.get("2019-01-03"));
    }

//TEST WYDAJNOŚCIOWY  dla 1 dnia  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceDayDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-02/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

//test - Sprawdzenie dla pobierania danych z tygodnia  -------------------------------------------------------------------------------------------------------------------------------------------
@Test
void testWeekDownloadTest(){
   // System.out.println("Pobieranie danych dla tygodnia");
    DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-08/");
    Map<String, Float> map = download.getValue();
    //System.out.println(map.size());
    int x = 5; // zliczone na sztywno
    assertEquals((float)x,map.size());
}


//TEST WYDAJNOŚCIOWY  dla 1 tygodnia  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceWeekDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-08/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        //System.out.println(flagaFalseB);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

//test - Sprawdzenie dla pobierania danych z dwóch tygodni  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testTwoWeeksDownloadTest(){
     //   System.out.println("Pobieranie danych dla dwóch tygodni");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-15/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 10; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

//TEST WYDAJNOŚCIOWY  dla 2 tygodni  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceTwoWeeksDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-15/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

//test - Sprawdzenie dla pobierania danych z miesiąca  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testMonthDownloadTest(){
     //   System.out.println("Pobieranie danych dla miesiaca");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 22; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }
//test WYDAJNOŚCIOWY  dla 1 miesiąca  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceMonthDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-31/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

    //test - Sprawdzenie dla pobierania danych z kwartału  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testQuarterDownloadTest(){
     //   System.out.println("Pobieranie danych dla kwartału");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-03-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 64; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

//test WYDAJNOŚCIOWY  dla 1 kwartału  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceQuarterDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-03-31/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

    //test - Sprawdzenie dla pobierania danych z połowy roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testHalfYearDownloadTest(){
        //System.out.println("Pobieranie danych dla połowy roku");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-06-30/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 125; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

//test WYDAJNOŚCIOWY  dla połowy roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceHalfYearDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-06-30/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }

    //test - Sprawdzenie dla pobierania danych z  roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testYearDownloadTest(){
     //   System.out.println("Pobieranie danych dla roku");
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
        Map<String, Float> map = download.getValue();
        //System.out.println(map.size());
        int x = 252; // zliczone na sztywno
        assertEquals((float)x,map.size());
    }

//test WYDAJNOŚCIOWY  dla roku  -------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    void testPerformanceYearDownloadDataGbp() {
        long startTimeDay = System.currentTimeMillis();
        DownloadData download = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
        long endTimeDay = System.currentTimeMillis();
        //System.out.println(endTimeDay-startTimeDay);
        //System.out.println(MAX_TIME_DOWNLOAD);
        if(MAX_TIME_DOWNLOAD>endTimeDay-startTimeDay) org.junit.Assert.assertTrue(flagaFalseB = true);
        assertEquals(true, flagaFalseB );
    }
}