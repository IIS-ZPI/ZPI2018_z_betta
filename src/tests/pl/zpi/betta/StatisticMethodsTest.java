package pl.zpi.betta;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticMethodsTest {

    StatisticMethodsTest statisticMethodsTest = new StatisticMethodsTest();


// 1 tydzień -------------------------------------------------------------------------------------------------------------------------------------------------

    DownloadData weekDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-08/");
    Map<String, Float> weekMap = weekDownload.getValue();
    StatisticMethods statystyki = new StatisticMethods(weekMap);
    statystyki.updateVals();

    //test dla mediany
    @Test
    void testWeekGetMedian(){
        //statisticMethodsTest.StatisticMethods(weekMap);
        //statisticMethodsTest.updateMap(weekMap);
        double y =statystyki.getMedian();
        double x= 4.6805;
        assertEquals(x,y);
    }
//
//    //test dla dominanty
//    @Test
//    void testWeekGetMode(){
//        double y =statisticMethodsTest.GetMode(weekMap);
//        double x= 0; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testWeekGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(weekMap);
//        double x= 0.0168;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testWeekGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(weekMap);
//        double x= 0.36; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje wzrostowe
//    @Test
//    void testWeekGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(weekMap);
//        int x= 2; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testWeekGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(weekMap);
//        int x= 2; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testWeekGetStala(){
//        int y =statisticMethodsTest.getStala(weekMap);
//        int x= 0; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//
//
//// 2 tygodnie -------------------------------------------------------------------------------------------------------------------------------------------------
//
//    DownloadData twoWeeksDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-15/");
//    Map<String, Float> twoWeeksMap = twoWeeksDownload.getValue();
//
//    //test dla mediany
//    @Test
//    void testTwoWeeksGetMedian(){
//        double y =statisticMethodsTest.GetMedian(twoWeeksMap);
//        double x= 4.6946;
//        assertEquals(x,y);
//    }
//
//    //test dla dominanty
//    @Test
//    void testTwoWeeksGetMode(){
//        double y =statisticMethodsTest.GetMode(twoWeeksMap);
//        double x= 0; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testTwoWeeksGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(twoWeeksMap);
//        double x= 0.0232;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testTwoWeeksGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(twoWeeksMap);
//        double x= 0.50; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje wzrostowe
//    @Test
//    void testTwoWeeksGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(twoWeeksMap);
//        int x= 4;
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testTwoWeeksGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(twoWeeksMap);
//        int x= 5;
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testTwoWeeksGetStala(){
//        int y =statisticMethodsTest.getStala(twoWeeksMap);
//        int x= 0;
//        assertEquals(x,y);
//    }
//
//
//// 1 miesiac -------------------------------------------------------------------------------------------------------------------------------------------------
//
//    DownloadData monthDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-01-31/");
//    Map<String, Float> monthWeeksMap = monthDownload.getValue();
//
//    //test dla mediany
//    @Test
//    void testMonthGetMedian(){
//        double y =statisticMethodsTest.GetMedian(monthWeeksMap);
//        double x= 4.7079;
//        assertEquals(x,y);
//    }
//
//    //test dla dominanty
//    @Test
//    void testMonthGetMode(){
//        double y =statisticMethodsTest.GetMode(monthWeeksMap);
//        double x= 0; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testMonthGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(monthWeeksMap);
//        double x= 0.0281;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testMonthGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(monthWeeksMap);
//        double x= 0.6; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje wzrostowe
//    @Test
//    void testMonthGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(monthWeeksMap);
//        int x= 12;
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testMonthGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(monthWeeksMap);
//        int x= 9;
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testMonthGetStala(){
//        int y =statisticMethodsTest.getStala(monthWeeksMap);
//        int x= 0;
//        assertEquals(x,y);
//    }
//
//// 1 kwartał -------------------------------------------------------------------------------------------------------------------------------------------------
//
//    DownloadData quarterDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-03-31/");
//    Map<String, Float> quarterMap = quarterDownload.getValue();
//
//    //test dla mediany
//    @Test
//    void testQuarterGetMedian(){
//        double y =statisticMethodsTest.GetMedian(quarterMap);
//        double x= 4.7212;
//        assertEquals(x,y);
//    }
//
//    //test dla dominanty
//    @Test
//    void testQuarterGetMode(){
//        double y =statisticMethodsTest.GetMode(quarterMap);
//        double x= 4.7527; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testQuarterGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(quarterMap);
//        double x= 0.0465;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testQuarterGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(quarterMap);
//        double x= 0.98; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje wzrostowe
//    @Test
//    void testQuarterGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(quarterMap);
//        int x= 37;
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testQuarterGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(quarterMap);
//        int x= 26;
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testQuarterGetStala(){
//        int y =statisticMethodsTest.getStala(quarterMap);
//        int x= 0;
//        assertEquals(x,y);
//    }
//
//// 1 połowa roku -------------------------------------------------------------------------------------------------------------------------------------------------
//
//    DownloadData halfYearDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-06-30/");
//    Map<String, Float> halfYearMap = halfYearDownload.getValue();
//
//    //test dla mediany
//    @Test
//    void testHalfYearGetMedian(){
//        double y =statisticMethodsTest.GetMedian(halfYearMap);
//        double x= 4.8002;
//        assertEquals(x,y);
//    }
//
//    //test dla dominanty
//    @Test
//    void testHalfYearGetMode(){
//        double y =statisticMethodsTest.GetMode(halfYearMap);
//        double x= 4.7527; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testHalfYearGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(halfYearMap);
//        double x= 0.0810;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testHalfYearGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(halfYearMap);
//        double x= 1.69; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//
//    //Sesje wzrostowe
//    @Test
//    void testHalfYearGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(halfYearMap);
//        int x= 71;
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testHalfYearGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(halfYearMap);
//        int x= 53;
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testHalfYearGetStala(){
//        int y =statisticMethodsTest.getStala(halfYearMap);
//        int x= 0;
//        assertEquals(x,y);
//    }
//
//// rok 2018  -------------------------------------------------------------------------------------------------------------------------------------------------
//
//    DownloadData yearDownload = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2018-01-01/2018-12-31/");
//    Map<String, Float> yearMap = yearDownload.getValue();
//
//    //test dla mediany
//    @Test
//    void testYearGetMedian(){
//        double y =statisticMethodsTest.GetMedian(yearMap);
//        double x= 4.8170;
//        assertEquals(x,y);
//    }
//
//    //test dla dominanty
//    @Test
//    void testYearGetMode(){
//        double y =statisticMethodsTest.GetMode(yearMap);
//        double x= 4.7527; //Brak wartości
//        assertEquals(x,y);
//    }
//
//    //test dla odchylenie standardowe
//    @Test
//    void testYearGetStandardDev(){
//        double y =statisticMethodsTest.GetStandardDev(yearMap);
//        double x= 0.0735;
//        assertEquals(x,y);
//    }
//
//    //Współczynnik zmienności
//    @Test
//    void testYearGetVariationCoefficient(){
//        double y =statisticMethodsTest.GetVariationCoefficient(yearMap);
//        double x= 1.53; //Wartość podana w procentach
//        assertEquals(x,y);
//    }
//
//    //Sesje wzrostowe
//    @Test
//    void testYearGetWzrostowa(){
//        int y =statisticMethodsTest.getWzrostowa(yearMap);
//        int x= 130;
//        assertEquals(x,y);
//    }
//
//    //Sesje spadkowe
//    @Test
//    void testYearGetSpadkowa(){
//        int y =statisticMethodsTest.getSpadkowa(yearMap);
//        int x= 121;
//        assertEquals(x,y);
//    }
//
//    //Sesje bez zmian
//    @Test
//    void testYearGetStala(){
//        int y =statisticMethodsTest.getStala(yearMap);
//        int x= 0;
//        assertEquals(x,y);
//    }

}