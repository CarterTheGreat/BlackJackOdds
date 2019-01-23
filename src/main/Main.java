package main;

import java.util.ArrayList;

public class Main {
	
	static int rounds = 1000;
	
	static boolean running = true;
	//static int cards [] = new int[52];
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	static ArrayList<Player> players = new ArrayList<Player>();
	
	//Dealer is not in list of players because the dealer HAS to play all turns after all other players are finished
	static Player playerOne = new Player("Player One",15,0,true,0);
	static Player playerTwo = new Player("Player Two",17,0,true,0);
	static Player playerThree = new Player("Player Three",18,0,true,0);
	static Player playerFour = new Player("Player Four",19,0,true,0);
	static Player playerFive= new Player("Player Five",20,0,true,0);
	static Player playerSix= new Player("Player Six",21,0,true,0);
	
	//Theses players must be added to player list in setPlayers
	static Player dealer = new Player("Dealer",16,0,true,0);
	
	
public static void main(String[] args) {
	
	for(int i = 0; i<rounds; i++) {
		
		
			setPlayers();
		
		buildDeck();
		play();
		check();
	}
	
	results();
	
	
}

public static void setPlayers() {
	
	players.clear();
	
	players.add(playerOne);
	players.add(playerTwo);
	players.add(playerThree);
	players.add(playerFour);
	players.add(playerFive);
	players.add(playerSix);
					
}

public static void buildDeck() {
	
	//System.out.println("Deck building started");
	
	for(int i = 0; i< players.size();i++) {
		players.get(i).clearHand();
	}	
	dealer.clearHand();
	
	Card aceA = new Card("ace",11);
	Card aceB = new Card("ace",11);
	Card aceC = new Card("ace",11);
	Card aceD = new Card("ace",11);
	
	Card aceE = new Card("ace",11);
	Card aceF = new Card("ace",11);
	Card aceG = new Card("ace",11);
	Card aceH = new Card("ace",11);

	Card aceI = new Card("ace",11);
	Card aceJ = new Card("ace",11);
	Card aceK = new Card("ace",11);
	Card aceL = new Card("ace",11);
	
	Card aceM = new Card("ace",11);
	Card aceN = new Card("ace",11);
	Card aceO = new Card("ace",11);
	Card aceP = new Card("ace",11);
	
	Card aceQ = new Card("ace",11);
	Card aceR = new Card("ace",11);
	Card aceS = new Card("ace",11);
	Card aceT = new Card("ace",11);
	
	Card aceU = new Card("ace",11);
	Card aceV = new Card("ace",11);
	Card aceW = new Card("ace",11);
	Card aceX = new Card("ace",11);

	Card aceY = new Card("ace",11);
	Card aceZ = new Card("ace",11);
	Card aceAA = new Card("ace",11);
	Card aceAB = new Card("ace",11);
	
	Card aceAC = new Card("ace",11);
	Card aceAD = new Card("ace",11);
	Card aceAE = new Card("ace",11);
	Card aceAF = new Card("ace",11);
	
	
	Card two = new Card("two",2);
	Card three = new Card("three",3);
	Card four = new Card("four",4);
	Card five = new Card("five",5);
	Card six = new Card("six",6);
	Card seven = new Card("seven",7);
	Card eight = new Card("eight",8);
	Card nine = new Card("nine",9);
	Card ten = new Card("ten",10);
	Card jack = new Card("jack",10);
	Card queen = new Card("queen",10);
	Card king = new Card("king",10);
	
	
	deck.clear();
	deck.add(aceA);
	deck.add(aceB);
	deck.add(aceC);
	deck.add(aceD);
	
	deck.add(aceE);
	deck.add(aceF);
	deck.add(aceG);
	deck.add(aceH);
	
	deck.add(aceI);
	deck.add(aceJ);
	deck.add(aceK);
	deck.add(aceL);
	
	deck.add(aceM);
	deck.add(aceN);
	deck.add(aceO);
	deck.add(aceP);
	
	deck.add(aceQ);
	deck.add(aceR);
	deck.add(aceS);
	deck.add(aceT);
	
	deck.add(aceU);
	deck.add(aceV);
	deck.add(aceW);
	deck.add(aceX);
	
	deck.add(aceY);
	deck.add(aceZ);
	deck.add(aceAA);
	deck.add(aceAB);
	
	deck.add(aceAC);
	deck.add(aceAD);
	deck.add(aceAE);
	deck.add(aceAF);
	
	for(int i = 0; i < 32; i++){
		
		for(int j = 0; j<12;j++) {

			deck.add(two);
			deck.add(three);
			deck.add(four);
			deck.add(five);
			deck.add(six);
			deck.add(seven);
			deck.add(eight);
			deck.add(nine);
			deck.add(ten);
			deck.add(jack);
			deck.add(queen);
			deck.add(king);
			
		}
	}
	
	
	/*Print Out Deck
	for(int i = 0; i < deck.size(); i++) {
		
		System.out.println(deck.get(i).getName());
	}
	*/
	
	//System.out.println("Deck built");
	
} 

public static void play() {
	
	boolean playersPlaying = true;
	boolean dealerPlaying = true;
	//Two starting Cards
	
	
	//----------------------------------------------------------------
	
	for(int i = 0; i < players.size();i++) {
		
		//System.out.println(players.get(i).getName() + " Hit");
		players.get(i).hit();
		players.get(i).hit();
	}
	
	dealer.hit();
	dealer.hit();
	
	
	//Rest of round
	
	while(playersPlaying) {
		
		//System.out.println("Playing Started");
			
		for(int i = 0; i<players.size();i++) {
			if (players.get(i).isPlaying()) {
				//System.out.println(players.get(i).getName()+ " Hit");
				players.get(i).hit();
			}
		}
		
		playersPlaying = false;
		
		for(int i = 0; i<players.size();i++) {
			if(players.get(i).isPlaying()) {
				playersPlaying = true;
			} 
		}
	}
	
	
	while (dealerPlaying) {
		if (dealer.isPlaying()) {
			//System.out.println("Dealer hit");
			dealer.hit();
		}else dealerPlaying = false;
	}
	
	
	//----------------------------------------------------------------
}

	 

public static void check() {
	
	int winningValue = 0;
	
	
	players.add(dealer);
	
	
	//System.out.println("Check begins");
	//Outputs each players value-------------------------------
	/*
	for(int i = 0; i<players.size();i++) {
		System.out.println(players.get(i).getName() +" value: "+ players.get(i).getValue());
	}
	*/
	//---------------------------------------------------------
	
	//Sets winner----------------------------------------------
	for(int i = 0; i< players.size();i++) {
		if((players.get(i).getValue() > winningValue) && (players.get(i).getValue() <= 21)){
			winningValue = players.get(i).getValue();
		}	
	}
	//---------------------------------------------------------
	
	//Adds wins to player totals and outputs winner value------
	for(int i = 0; i< players.size();i++) {
		if (winningValue == players.get(i).getValue()) {
			players.get(i).setWins(players.get(i).getWins()+1);
			System.out.println(players.get(i).getName()+ "    wins");
		}
	}
	//---------------------------------------------------------
}

public static void results() {
	
	
	
	
	//Print Cards----------------------------------
	/*
	for(int i = 0; i < players.size(); i++) {
		System.out.println(players.get(i).getName());
		for(int j = 0; j< players.get(i).hand.size();j++) {
			System.out.println(players.get(i).hand.get(j).getName());
		}
	}
	*/
	//Fin Print Cards--------------------------------
	
	//Output wins -----------------------------------
	for(int i = 0; i< players.size();i++) {
		System.out.println(players.get(i).getName()+ " Wins: "+ players.get(i).getWins());
	}	
	//----------------------------------------------
	
	//Win %-----------------------------------------
	/*
	 for(int i = 0; i< players.size();i++) {
	 
		int winPercent = (players.get(i).getWins() / rounds) * 100;
		System.out.println(players.get(i).getName()+ " Wins %: "+ winPercent +"%");
	}	
	*/
	//-----------------------------------------------
	System.out.println("------------------------------------------");
}

}
