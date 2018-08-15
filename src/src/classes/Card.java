package src.classes;

/**
 * This class represents a single cards
 *
 */
public class Card {
	Suit suit;
	String value;
		
	public Card (String value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public Card (String str) {
		calculateSuit(str);
		calculateValue(str);
		
	}
	
	private void calculateValue(String str) {
		this.value = str.substring(0,1);
	}
	
	private void calculateSuit(String str) {
		switch( str.substring(1)) {
		case "h":
			this.suit = Suit.HEARTS;
			break;

		case "d":
			this.suit = Suit.DIAMONDS;
			break;

		case "s":
			this.suit = Suit.SPADES;
			break;	
			
		default:
			this.suit = Suit.CLUBS;
		}
	}
	
}
