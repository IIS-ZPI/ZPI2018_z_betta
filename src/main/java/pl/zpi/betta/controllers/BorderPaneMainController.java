package pl.zpi.betta.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import java.util.Scanner;

public class BorderPaneMainController {
    ObservableList currencyList = FXCollections.observableArrayList("PLN", "USD", "EUR", "GBP", "CHF", "AUD", "CAD", "SGD", "JPY","RUB","SEK");
    ObservableList analysisList = FXCollections.observableArrayList("Wyznaczenie ilości sesji", "Miary statystyczne", "Rozkład częstości zmian");
    ObservableList periodList = FXCollections.observableArrayList("Tydzień" , "2 Tygodnie", "Miesiąc", "1/4 Roku", "1/2 Roku", "Rok");
    @FXML
    private CheckBox currencyBox1;
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

    @FXML
    private void initialize() {
        currencyChoiceBox1.setValue("PLN");
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
        String per = (String) periodChoiceBox.getValue();
        int period = 0;
        switch (per) {
            case "Tydzień":
                period = 7;
                break;
            case "2 Tygodnie":
                period = 14;
                break;
            case "Miesiąc":
                period = 31;
                break;
            case "1/4 Roku":
                period = 123;
                break;
            case "1/2 Roku":
                period = 182;
                break;
            case "Rok":
                //do naprawy
                period = 255;
                break;
        }
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/"+ value1 +"/last/" + period + "/";
        System.out.println(url);

    }
}
