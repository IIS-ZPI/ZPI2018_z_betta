package pl.zpi.betta.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import pl.zpi.betta.DownloadData;
import pl.zpi.betta.StatisticMethods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class BorderPaneMainController {
    private DownloadData downloadData;
    private DownloadData downloadData1;
    private StatisticMethods currency;
    private StatisticMethods currency1;
    private LocalDate localDate;
    private LocalDate date;
    ObservableList currencyList = FXCollections.observableArrayList("USD", "EUR", "GBP", "CHF", "AUD", "CAD", "SGD", "JPY","RUB","SEK");
    ObservableList analysisList = FXCollections.observableArrayList("Wyznaczenie ilości sesji", "Miary statystyczne", "Rozkład częstości zmian");
    ObservableList periodList = FXCollections.observableArrayList("Tydzień" , "2 Tygodnie", "Miesiąc", "1/4 Roku", "1/2 Roku", "Rok");
    @FXML
    private CheckBox currencyBox2;
    @FXML
    private ChoiceBox currencyChoiceBox1;
    @FXML
    private ChoiceBox currencyChoiceBox2;
    @FXML
    private ChoiceBox analysisChoiceBox;
    @FXML
    private ChoiceBox periodChoiceBox;
    @FXML
    private Button quitButton;
    @FXML
    private Button applyButton;

    public BorderPaneMainController() throws IOException {
    }

    @FXML
    private void initialize() {
        currencyChoiceBox1.setValue("USD");
        currencyChoiceBox1.setItems(currencyList);
        currencyChoiceBox2.setItems(currencyList);
        analysisChoiceBox.setValue("Wyznaczenie ilości sesji");
        analysisChoiceBox.setItems(analysisList);
        periodChoiceBox.setValue("Tydzień");
        periodChoiceBox.setItems(periodList);
    }

    @FXML
    private void quitOnClick() {

    }

    @FXML
    private void applyOnClick() {
        String value1 = (String) currencyChoiceBox1.getValue();
        String value2 = (String) currencyChoiceBox2.getValue();
        boolean checkBox2 = currencyBox2.isSelected();
        String flag = (String) analysisChoiceBox.getValue();

        if(checkBox2){
            downloadData = new DownloadData(urlBuilder(value1));
            downloadData1 = new DownloadData(urlBuilder(value2));
            currency = new StatisticMethods(downloadData.getValue(), value1);
            currency.sessions();
            currency1 = new StatisticMethods(downloadData1.getValue(),value2);
            currency1.sessions();
                if (flag == "Rozkład częstości zmian") {
                    analysisCompare(currency, currency1);
                }
                else {
                    analysis(currency);
                    analysis(currency1);
                }
                }
       else {
            downloadData = new DownloadData(urlBuilder(value1));
            currency = new StatisticMethods(downloadData.getValue(),value1);
            currency.sessions();
            analysis(currency);
        }
    }
    public String urlBuilder(String value) {
        String url = "";
        String per = (String) periodChoiceBox.getValue();
        localDate = LocalDate.now();
        switch (per) {
            case "Tydzień":
                date = localDate.minus(Period.ofWeeks(1));
                break;
            case "2 Tygodnie":
                date = localDate.minus(Period.ofWeeks(2));
                break;
            case "Miesiąc":
                date = localDate.minus(Period.ofMonths(1));
                break;
            case "1/4 Roku":
                date = localDate.minus(Period.ofMonths(3));
                break;
            case "1/2 Roku":
                date = localDate.minus(Period.ofMonths(6));
                break;
            case "Rok":
                date = localDate.minus(Period.ofYears(1));
                break;
        }
        return url = "http://api.nbp.pl/api/exchangerates/rates/A/"+ value +"/" + date.toString()+"/"+localDate.toString()+"/?format=json";
    }

    public void analysis(StatisticMethods currency) {
        String analysis = (String) analysisChoiceBox.getValue();
        switch (analysis) {
            case "Wyznaczenie ilości sesji":
                currency.getWzrostowa();
                currency.getStala();
                currency.getSpadkowa();
                System.out.println("Waluta : " + currency.getCurrency() + ", wzrostowa : " + currency.getWzrostowa() + ", stala : " + currency.getStala() + ", spadkowa : " + currency.getSpadkowa());
                break;
            case "Miary statystyczne":
                currency.getMedian();
                currency.getMode();
                currency.getStandardDev();
                System.out.println("Waluta : " + currency.getCurrency() + ", mediana : " + currency.getMedian() + ", dominanta : " + currency.getMode() + ", odchylenie standardowe : " + currency.getStandardDev());
                break;

            case "Rozkład częstości zmian":
                currency.getVariationCoefficient();
                System.out.println("Waluta : " + currency.getCurrency() + ", rozklad czestosci zmian : " + currency.getVariationCoefficient());
                break;
        }

        }
    public void analysisCompare(StatisticMethods currency, StatisticMethods currency1){

                currency.getVariationCoefficient();
                System.out.println("Waluta : " + currency.getCurrency() + ", rozklad czestosci zmian : " + currency.getVariationCoefficient());
                currency1.getVariationCoefficient();
                System.out.println("Waluta : " + currency1.getCurrency() + ", rozklad czestosci zmian : " + currency1.getVariationCoefficient());

        }
    }
