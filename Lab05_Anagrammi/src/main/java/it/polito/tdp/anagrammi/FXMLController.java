package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola = txtInput.getText();
    	List<String> trovate = this.model.anagrammi(parola);
    	List<String> corrette = new ArrayList<>();
    	List<String> errate = new ArrayList<>();
    	for(String s : trovate) {
    	  	if(this.model.isCorrect(s)) {
    	  		corrette.add(s);
    	  	} else {
    	  		errate.add(s);
    	  	}    	  		
    	}
    	String s1 = "";
    	if(corrette.size() != 0) {
    		for(String s : corrette) {
    			s1 += s+"\n";
    		}
    		txtCorretti.appendText(s1);
    	}
    	String s2 = "";
    	if(errate.size() != 0) {
    		for(String s : errate) {
    			s2 += s+"\n";
    		}
    		txtErrati.appendText(s2);
    	}
    	return;
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
