package src.classes;
import java.util.*;


public class Player {
	
	private String name = "spuzipakete";
	// Write here where is your hand history (you can change it in pokerstars)
	String HANDS_DIRECTORY = "C:\\Users\\fsanchez\\git\\PokerstarsBalanceCalculator\\resources";
	private double money = 0.0;
	private double rake = 0.0;
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
	 * Rake paid
	 */
	public double payRake(double moneyPaid) {
		this.rake += moneyPaid;
		return this.rake;
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
		String action = str.split(" ")[1].trim();
		Action actionDone = null;
		
		Double amount = 0.0;
		switch(action) {
		case "raises":
			actionDone = Action.RAISE;
			 amount = Double.parseDouble( str.split("to")[1].trim().substring(1) );
			payMoney(amount);
			break;
		case "folds":
			actionDone = Action.FOLD;
			break;
		case "calls":
			 amount = Double.parseDouble(str.split(" ")[2].substring(1));
			payMoney(amount);
			break;
		}
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

	public double getRake() {
		return rake;
	}

	public void setRake(double rake) {
		this.rake = rake;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	
	
}
