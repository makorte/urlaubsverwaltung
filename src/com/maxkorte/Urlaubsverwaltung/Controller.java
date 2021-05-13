package com.maxkorte.Urlaubsverwaltung;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    MenuItem mSchliessen;
    @FXML
    MenuItem mLoeschen;
    @FXML
    TextField tfVorname;
    @FXML
    TextField tfNachname;
    @FXML
    DatePicker dpVon;
    @FXML
    DatePicker dpBis;
    @FXML
    Button bBeantragen;
    @FXML
    TableView<Urlaubsantrag> tUrlaubsantraege;
    @FXML
    TableColumn<Urlaubsantrag, String> tcVorname;
    @FXML
    TableColumn<Urlaubsantrag, String> tcNachname;
    @FXML
    TableColumn<Urlaubsantrag, LocalDate> tcVon;
    @FXML
    TableColumn<Urlaubsantrag, LocalDate> tcBis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        tcNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        tcVon.setCellValueFactory(new PropertyValueFactory<>("urlaubVon"));
        tcBis.setCellValueFactory(new PropertyValueFactory<>("urlaubBis"));
    }

    public void handleSchliessen(){
        System.exit(0);
    }

    public void handleLoeschen(){
        clearBeantragen();
        tUrlaubsantraege.getItems().clear();
    }
    public void clearBeantragen(){
        tfVorname.setText("");
        tfNachname.setText("");
        dpVon.setValue(null);
        dpBis.setValue(null);
    }

    public void handleBBeantragen(){
        Urlaubsantrag a = new Urlaubsantrag(
                tfVorname.getText(), tfNachname.getText(), dpVon.getValue(), dpBis.getValue()
        );
        tUrlaubsantraege.getItems().add(a);

        clearBeantragen();
    }

    public void pruefeVon(){
        if (dpBis.getValue() != null && dpBis.getValue().isBefore(dpVon.getValue())) dpBis.setValue(dpVon.getValue());
    }

    public void pruefeBis(){
        if (dpVon.getValue() != null && dpVon.getValue().isAfter(dpBis.getValue())) dpVon.setValue(dpBis.getValue());
    }
}
