package main;

public class Card {

	int value;
	String name;
	
	int altValue = 1;
	
	public Card(String name, int value) {
		
		this.name = name;
		this.value = value;
		
		
	}
	
	
	
	
	public int getAltValue() {
		return altValue;
	}

	public void setToAltValue() {
		value = 1;
		
		//System.out.println("Set to alt value");
	}
	
	
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
