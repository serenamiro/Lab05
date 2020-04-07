package it.polito.tdp.anagrammi.model;

import java.util.List;

public abstract class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		List<String> ana = m.anagrammi("eat");
		System.out.println(ana);
	}

}
