package src.classes;
import java.util.*;


public class Player {
	
	private String name = "spuzipakete";
	// Write here where is your hand history (you can change it in pokerstars)
	String HANDS_DIRECTORY = "C:\\Users\\fsanchez\\git\\PokerstarsBalanceCalculator\\resources";
	private double money = 0.0;
	
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
	
	//****** GETS AND SETS ******
	public void setMoney (double amount) {
		this.money = amount;
	}
	
	public double getMoney () {
		return this.money;
	}

	
	
}
