package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	private List<String> soluzione;
	private AnagrammaDAO dao;
	
	public Model() {
		this.soluzione = new ArrayList<String>();
		dao = new AnagrammaDAO();
	}

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<String> anagrammi(String parola) {
		//this.soluzione = new ArrayList<String>();
		parola.toUpperCase();
		List<Character> disponibili = new ArrayList<>();
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		
		// avvia la ricorsione
		cerca("", 0, disponibili);
		
		return this.soluzione;
	}

	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma.
	 * @param parziale parte iniziale dell'anagramma costruito finora
	 * @param livello livello della ricorsione, sempre uguale a parziale.lenght()
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size() == 0) { // oppure equivalente: livello==parola.length()
			// CASO TERMINALE
			this.soluzione.add(parziale);
		} 		
		// CASO NORMALE
		// provare ad aggiungere alla soluzione parziale tutti i caratteri 
		// presenti tra i 'disponibili'
		for(Character ch : disponibili) {
			String tentativo = parziale+ch;
			List<Character> rimanenti = new ArrayList<>(disponibili);
			// devo per forza creare una nuova lista perchè non posso rimuovere
			// elementi da una lista su cui sto iterando
			rimanenti.remove(ch);
			cerca(tentativo, livello+1, rimanenti);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return dao.isCorrect(anagramma);
	}
}
