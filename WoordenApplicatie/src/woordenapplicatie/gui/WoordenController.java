package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {

    WordSort WordSort = new WordSort();
    private static final String DEFAULT_TEXT = 
            "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Heb je dan geen hoedje meer\n"
            + "Maak er één van bordpapier\n"
            + "Eén, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "En als het hoedje dan niet past\n"
            + "Zetten we 't in de glazenkas\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier";

    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }

//    Aantal
//Het tellen van het aantal verschillende woorden en het totaal aantal woorden in de tekst. 
    @FXML
    public void aantalAction(ActionEvent event) {
        taOutput.setText(WordSort.aantal(DEFAULT_TEXT));

    }

//Sorteer
//Laat in “omgekeerde” alfabetische ordening alle verschillende woorden zien. 
    @FXML
    public void sorteerAction(ActionEvent event) {
        taOutput.setText(WordSort.sorteer(DEFAULT_TEXT));
    }

//Frequentie
//Het bijhouden hoeveel keer een woord voorkomt in de tekst gesorteren op frequentie.
    @FXML
    public void frequentieAction(ActionEvent event) {
        taOutput.setText(WordSort.frequentie(DEFAULT_TEXT));
    }

//Concordantie
//Een concordantie voor de gegeven tekst is een lijst van alle woorden die in een tekst voorkomen, 
//met de verwijzing naar de plaats waar ze staan. 
    @FXML
    public void concordatieAction(ActionEvent event) {
        taOutput.setText(WordSort.concordantie(DEFAULT_TEXT));
    }  
}