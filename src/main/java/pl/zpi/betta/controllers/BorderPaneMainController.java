package pl.zpi.betta.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import pl.zpi.betta.DownloadData;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class BorderPaneMainController {
    private DownloadData downloadData;
    private LocalDate localDate;
    private LocalDate date;
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

    public BorderPaneMainController() throws IOException {
    }

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
        String table = "A";
        String value1 = (String) currencyChoiceBox1.getValue();
        String value2 = (String) currencyChoiceBox2.getValue();
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
        downloadData = new DownloadData("http://api.nbp.pl/api/exchangerates/rates/"+table+ "/"+ value1 +"/" + date.toString()+"/"+localDate.toString()+"/?format=json");

    }
}
