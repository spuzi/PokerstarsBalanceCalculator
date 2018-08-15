package src.classes;

/**
 * This class represents a Hand compound of 2 cards 
 *
 */
public class Hand {
	Card[] cards;
	
	public Hand (Card[] cards) {
		this.cards = cards;
	}
	
	/**
	 * Read the hand form the pokerstar description. For example: Dealt to spuzipakete [Ts 2h]
	 */
	public Hand (String str) {
		String[] aux =str.substring(str.indexOf("[")+1 , str.indexOf("]")).split(" ");
		this.cards = new Card[2];
		this.cards[0] = new Card( aux[0] );
		this.cards[1] = new Card( aux[1] );
		
	}
	
	public boolean isSuited() {
		return true;
	}

}
