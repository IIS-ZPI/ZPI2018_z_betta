package pl.zpi.betta;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticMethodsTest {

// 1 tydzień -------------------------------------------------------------------------------------------------------------------------------------------------

    DownloadData weekDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-08/");
    Map<String, Float> weekMap = weekDownload.getValue();
    StatisticMethods weekStatisticMethodsTest = new StatisticMethods(weekMap);
    weekStatisticMethodsTest.updateVals();
    weekStatisticMethodsTest.sessions();

//test dla mediany
    @Test
    void testWeekGetMedian(){
        double y =weekStatisticMethodsTest.getMedian();
        double x= 4.6805;
        assertEquals(x,y);
    }

//test dla dominanty
    @Test
    void testWeekGetMode(){
        float y =weekStatisticMethodsTest.getMode();
        double x= 0; //Brak wartości
        assertEquals((float)x,y);
    }

//test dla odchylenie standardowe
    @Test
    void testWeekGetStandardDev(){
        float y =weekStatisticMethodsTest.getStandardDev();
        double x= 0.0168;
        assertEquals((float)x,y);
    }

//Współczynnik zmienności
    @Test
    void testWeekGetVariationCoefficient(){
        float y =weekStatisticMethodsTest.getVariationCoefficient();
        double x= 0.36; //Wartość podana w procentach
        assertEquals((float)x,y);
    }

//Sesje wzrostowe
    @Test
    void testWeekGetWzrostowa(){
        int y =weekStatisticMethodsTest.getWzrostowa();
        int x= 2;
        assertEquals(x,y);
    }

//Sesje spadkowe
    @Test
    void testWeekGetSpadkowa(){
        int y =weekStatisticMethodsTest.getSpadkowa();
        int x= 2;
        assertEquals(x,y);
    }

//Sesje bez zmian
    @Test
    void testWeekGetStala(){
        int y =weekStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }



//// 2 tygodnie -------------------------------------------------------------------------------------------------------------------------------------------------

    DownloadData twoWeeksDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-15/");
    Map<String, Float> twoWeeksMap = twoWeeksDownload.getValue();
    StatisticMethods twoWeeksStatisticMethodsTest = new StatisticMethods(twoWeeksMap);
    twoWeeksStatisticMethodsTest.updateVals();
    twoWeeksStatisticMethodsTest.sessions();

//test dla mediany
    @Test
    void testTwoWeeksGetMedian(){
        double y =twoWeeksStatisticMethodsTest.getMedian();
        double x= 4.6946;
        assertEquals(x,y);
    }

//test dla dominanty
    @Test
    void testTwoWeeksGetMode(){
        float y =twoWeeksStatisticMethodsTest.getMode();
        double x= 0; //Brak wartości
        assertEquals((float)x,y);
    }

//test dla odchylenie standardowe
    @Test
    void testTwoWeeksGetStandardDev(){
        float y =twoWeeksStatisticMethodsTest.getStandardDev();
        double x= 0.0232;
        assertEquals((float)x,y);
    }

//Współczynnik zmienności
    @Test
    void testTwoWeeksGetVariationCoefficient(){
        float y =twoWeeksStatisticMethodsTest.getVariationCoefficient();
        double x= 0.50; //Wartość podana w procentach
        assertEquals((float)x,y);
    }

//Sesje wzrostowe
    @Test
    void testTwoWeeksGetWzrostowa(){
        int y =twoWeeksStatisticMethodsTest.getWzrostowa();
        int x= 4;
        assertEquals(x,y);
    }

//Sesje spadkowe
    @Test
    void testTwoWeeksGetSpadkowa(){
        int y =twoWeeksStatisticMethodsTest.getSpadkowa();
        int x= 5;
        assertEquals(x,y);
    }

//Sesje bez zmian
    @Test
    void testTwoWeeksGetStala(){
        int y =twoWeeksStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }


//// 1 miesiac -------------------------------------------------------------------------------------------------------------------------------------------------
    DownloadData monthDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-31/");
    Map<String, Float> monthMap = monthDownload.getValue();
    StatisticMethods monthStatisticMethodsTest = new StatisticMethods(monthMap);
    monthStatisticMethodsTest.updateVals();
    monthStatisticMethodsTest.sessions();

//test dla mediany
    @Test
    void testMonthGetMedian(){
        double y =monthStatisticMethodsTest.getMedian();
        double x= 4.7079;
        assertEquals(x,y);
    }

//test dla dominanty
    @Test
    void testMonthGetMode(){
        float y =monthStatisticMethodsTest.getMode();
        double x= 0; //Brak wartości
        assertEquals((float)x,y);
    }

//test dla odchylenie standardowe
    @Test
    void testMonthGetStandardDev(){
        float y =monthStatisticMethodsTest.getStandardDev();
        double x= 0.0281;
        assertEquals((float)x,y);
    }

//Współczynnik zmienności
    @Test
    void testMonthGetVariationCoefficient(){
        float y =monthStatisticMethodsTest.getVariationCoefficient();
        double x= 0.6; //Wartość podana w procentach
        assertEquals((float)x,y);
    }

//Sesje wzrostowe
    @Test
    void testMonthGetWzrostowa(){
        int y =monthStatisticMethodsTest.getWzrostowa();
        int x= 12;
        assertEquals(x,y);
    }

//Sesje spadkowe
    @Test
    void testMonthGetSpadkowa(){
        int y =monthStatisticMethodsTest.getSpadkowa();
        int x= 9;
        assertEquals(x,y);
    }

//Sesje bez zmian
    @Test
    void testMonthGetStala(){
        int y =monthStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }

// 1 kwartał -------------------------------------------------------------------------------------------------------------------------------------------------
    DownloadData quarterDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-03-31/");
    Map<String, Float> quarterMap = quarterDownload.getValue();
    StatisticMethods quarterStatisticMethodsTest = new StatisticMethods(quarterMap);
    quarterStatisticMethodsTest.updateVals();
    quarterStatisticMethodsTest.sessions();

//test dla mediany
    @Test
    void testQuarterGetMedian(){
        double y =quarterStatisticMethodsTest.getMedian();
        double x= 4.7212;
        assertEquals(x,y);
    }

//test dla dominanty
    @Test
    void testQuarterGetMode(){
        float y =quarterStatisticMethodsTest.getMode();
        double x= 4.7527; //Brak wartości
        assertEquals((float)x,y);
    }

    //test dla odchylenie standardowe
    @Test
    void testQuarterGetStandardDev(){
        float y =quarterStatisticMethodsTest.getStandardDev();
        double x= 0.0465;
        assertEquals((float)x,y);
    }

    //Współczynnik zmienności
    @Test
    void testQuarterGetVariationCoefficient(){
        float y =quarterStatisticMethodsTest.getVariationCoefficient();
        double x= 0.98; //Wartość podana w procentach
        assertEquals((float)x,y);
    }

    //Sesje wzrostowe
    @Test
    void testQuarterGetWzrostowa(){
        int y =quarterStatisticMethodsTest.getWzrostowa();
        int x= 37;
        assertEquals(x,y);
    }

    //Sesje spadkowe
    @Test
    void testQuarterGetSpadkowa(){
        int y =quarterStatisticMethodsTest.getSpadkowa();
        int x= 26;
        assertEquals(x,y);
    }

    //Sesje bez zmian
    @Test
    void testQuarterGetStala(){
        int y =quarterStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }

// 1 połowa roku -------------------------------------------------------------------------------------------------------------------------------------------------
    DownloadData halfYearDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-06-30/");
    Map<String, Float> halfYearMap = halfYearDownload.getValue();
    StatisticMethods halfYearStatisticMethodsTest = new StatisticMethods(halfYearMap);
    halfYearStatisticMethodsTest.updateVals();
    halfYearStatisticMethodsTest.sessions();

    //test dla mediany
    @Test
    void testHalfYearGetMedian(){
        double y =halfYearStatisticMethodsTest.getMedian();
        double x= 4.8002;
        assertEquals(x,y);
    }

    //test dla dominanty
    @Test
    void testHalfYearGetMode(){
        float y =halfYearStatisticMethodsTest.getMode();
        double x= 4.7527;
        assertEquals((float)x,y);
    }

    //test dla odchylenie standardowe
    @Test
    void testHalfYearGetStandardDev(){
        float y =halfYearStatisticMethodsTest.getStandardDev();
        double x= 0.0810;
        assertEquals((float)x,y);
    }

//Współczynnik zmienności
    @Test
    void testHalfYearGetVariationCoefficient(){
        float y =halfYearStatisticMethodsTest.getVariationCoefficient();
        double x= 1.69; //Wartość podana w procentach
        assertEquals((float)x,y);
    }


    //Sesje wzrostowe
    @Test
    void testHalfYearGetWzrostowa(){
        int y =halfYearStatisticMethodsTest.getWzrostowa();
        int x= 71;
        assertEquals(x,y);
    }

    //Sesje spadkowe
    @Test
    void testHalfYearGetSpadkowa(){
        int y =halfYearStatisticMethodsTest.getSpadkowa();
        int x= 53;
        assertEquals(x,y);
    }

    //Sesje bez zmian
    @Test
    void testHalfYearGetStala(){
        int y =halfYearStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }

//// rok 2018  -------------------------------------------------------------------------------------------------------------------------------------------------
    DownloadData yearDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
    Map<String, Float> yearMap = yearDownload.getValue();
    StatisticMethods yearStatisticMethodsTest = new StatisticMethods(yearMap);
    yearStatisticMethodsTest.updateVals();
    yearStatisticMethodsTest.sessions();

//test dla mediany
    @Test
    void testYearGetMedian(){
        double y =yearStatisticMethodsTest.getMedian();
        double x= 4.8170;
        assertEquals(x,y);
    }

//test dla dominanty
    @Test
    void testYearGetMode(){
        double y =yearStatisticMethodsTest.getMode();
        double x= 4.7527; //Brak wartości
        assertEquals(x,y);
    }

//test dla odchylenie standardowe
    @Test
    void testYearGetStandardDev(){
        double y =yearStatisticMethodsTest.getStandardDev();
        double x= 0.0735;
        assertEquals(x,y);
    }

 //Współczynnik zmienności
    @Test
    void testYearGetVariationCoefficient(){
        double y =yearStatisticMethodsTest.getVariationCoefficient();
        double x= 1.53; //Wartość podana w procentach
        assertEquals(x,y);
    }

//Sesje wzrostowe
    @Test
    void testYearGetWzrostowa(){
        int y =yearStatisticMethodsTest.getWzrostowa();
        int x= 130;
        assertEquals(x,y);
    }

//Sesje spadkowe
    @Test
    void testYearGetSpadkowa(){
        int y =yearStatisticMethodsTest.getSpadkowa();
        int x= 121;
        assertEquals(x,y);
    }

//Sesje bez zmian
    @Test
    void testYearGetStala(){
        int y =yearStatisticMethodsTest.getStala();
        int x= 0;
        assertEquals(x,y);
    }



//// TESTY WYDAJNOŚCIOWE DLA rok 2018  -------------------------------------------------------------------------------------------------------------------------------------------------

    private final long MAX_TIME_YEAR_PERFORMANCE=4000; //4 sekundy w ms
    boolean flagaFalseYearB = false;


    DownloadData yearPerformanceDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
    Map<String, Float> yearPerformanceMap = yearPerformanceDownload.getValue();
    StatisticMethods yearPerformanceStatisticMethodsTest = new StatisticMethods(yearPerformanceMap);
    yearPerformanceStatisticMethodsTest.updateVals();
    yearPerformanceStatisticMethodsTest.sessions();

// TEST WYDAJNOŚCIOWY test dla mediany
    @Test
    void testPerformanceYearGetMedian(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getMedian();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY  test dla dominanty
    @Test
    void testPerformanceYearGetMode(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getMode();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY  test dla odchylenie standardowe
    @Test
    void testPerformanceYearGetStandardDev(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getStandardDev();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY  Współczynnik zmienności
    @Test
    void testPerformanceYearGetVariationCoefficient(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getVariationCoefficient();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY  Sesje wzrostowe
    @Test
    void testPerformanceYearGetWzrostowa(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getWzrostowa();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY  Sesje spadkowe
    @Test
    void testPerformanceYearGetSpadkowa(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getSpadkowa();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

//TEST WYDAJNOŚCIOWY Sesje bez zmian
    @Test
    void testPerformanceYearGetStala(){
        long startTimeYear = System.currentTimeMillis();
        yearPerformanceStatisticMethodsTest.getStala();
        long endTimeYear = System.currentTimeMillis();
        if(MAX_TIME_YEAR_PERFORMANCE>endTimeYear-startTimeYear) org.junit.Assert.assertTrue(flagaFalseYearB = true);
        assertEquals(true, flagaFalseYearB );
    }

}