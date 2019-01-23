package main;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	int cardCount = 0;
	
	String name;
	int value;
	int hitValue;
	boolean playing;
	int wins;
	
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name, int hitValue, int value, boolean playing, int wins){
		this.name = name;
		this.hitValue = hitValue;
		this.value = value;
		this.playing = playing;
		this.wins = wins;
	}
	

	
	//Methods 
	public void hit(){
		
		Random r = new Random();
		int random = r.nextInt(Main.deck.size());
		//System.out.println(Main.deck.size());
		
		hand.add(cardCount,Main.deck.get(random));
		Main.deck.remove(random);
		
		
		cardCount++;
		
		value = 0;
		
		for(int i = 0; i <cardCount; i++) {
			value = value + hand.get(i).getValue();
			
		}
		
		if(value > 21) aceCheck();
		isPlaying();
		
	}
	
	public void aceCheck() {

		//System.out.println("aceCheck running");
		
		for(int i = 0; i < hand.size();i++) {
			if((hand.get(i).getName().substring(0, Math.min(hand.get(i).getName().length(), 3)) == "ace") & (value > 21)) {
				
				hand.get(i).setToAltValue();
				
			}
			
			value = 0;
			
			for(int j = 0; j <cardCount; j++) {
				value = value + hand.get(j).getValue();
				
			}
		}
		
		
	}
	
	public void clearHand() {
		
		value = 0;
		cardCount = 0;
		hand.clear();
		
	}
	
	public void hold() {
		playing = false;
	}

	
	
	//Values

	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getHitValue() {
		return hitValue;
	}


	public void setHitValue(int hitValue) {
		this.hitValue = hitValue;
	}


	public boolean isPlaying() {
		
		if (hitValue > value) {
			playing = true;
		}
		else {
			playing = false;	
		}
		
		return playing;
	}


	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	public int getWins() {
		return wins;
	}



	public void setWins(int wins) {
		this.wins = wins;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
}
