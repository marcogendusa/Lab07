package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Blackout;
import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Nerc> menuNerc;

    @FXML
    private TextField txtAnni;

    @FXML
    private TextField txtOre;

    @FXML
    private Button btnAnalizza;

    @FXML
    private TextArea txtOutput;

    @FXML
    void handleWorstCase(ActionEvent event) {
    	
    	txtOutput.clear();
    	
    	Nerc nerc = menuNerc.getValue();
    	if(nerc==null)
    		txtOutput.appendText("Nessun NERC selezionato");
    	
    	try {
    		int ore = Integer.parseInt(txtOre.getText());
    		int anni = Integer.parseInt(txtAnni.getText());
    		
    		for(Blackout b : model.calcolaSequenza(nerc, anni, ore))
    				txtOutput.appendText(b.toString()+"\n");
    		
    	} catch(NumberFormatException e) {
    		
    	}

    }

    @FXML
    void initialize() {
        assert menuNerc != null : "fx:id=\"menuNerc\" was not injected: check your FXML file 'lab7.fxml'.";
        assert txtAnni != null : "fx:id=\"txtAnni\" was not injected: check your FXML file 'lab7.fxml'.";
        assert txtOre != null : "fx:id=\"txtOre\" was not injected: check your FXML file 'lab7.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'lab7.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'lab7.fxml'.";
        
    }
    
    public void setModel(Model model) {
    		this.model = model;
        	menuNerc.getItems().addAll(model.getAllNerc());
    }
    
}
