package src.classes;
import java.util.*;


public class Player {
	
	private String name = "spuzipakete";
	// Write here where is your hand history (you can change it in pokerstars)
	String HANDS_DIRECTORY = "C:\\Users\\fsanchez\\git\\PokerstarsBalanceCalculator\\resources";
	private double money = 0.0;
	// The card dealed to the player
	private Hand hand = null;
	// Actions made by a player. For instance: raise, check, raise, fold
	private ArrayList<Action> actions = new ArrayList<>();
	
	//****** CONSTRUCTORS ******
	public Player() {}
	
	public Player(String name ) {
		this.name = name;
	}
	
	public Player(String name , double money) {
		this.name = name;
		this.money = money;
	}
	
	/**
	 * Loose money
	 */
	public double payMoney(double moneyPaid) {
		this.money -= moneyPaid;
		return this.money;
	}
	
	/**
	 * Win money 
	 */
	public double winMoney(double moneyPaid) {
		this.money += moneyPaid;
		return this.money;
	}	
	
	/**
	 * A player can do an action: fold, check , call, raise
	 */
	public double doAction(String str) {
		System.out.println("hola");
		
		return this.money;
	}
	
	//****** GETS AND SETS ******
	public void setMoney (double amount) {
		this.money = amount;
	}
	
	public double getMoney () {
		return this.money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	
	
}
