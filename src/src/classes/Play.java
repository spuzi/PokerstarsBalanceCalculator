package src.classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * This class represents a single play Poker stars save one play in the next
 * format:
 * 
 * PokerStars Zoom Hand #189846733637: Hold'em No Limit (€0.01/€0.02) -
 * 2018/08/13 19:35:14 CET [2018/08/13 13:35:14 ET] Table 'Arneb' 6-max Seat #1
 * is the button Seat 1: monton1 (€2.13 in chips) Seat 2: asuusu (€2.05 in
 * chips) Seat 3: spuzipakete (€2 in chips) Seat 4: Suave1984 (€6.09 in chips)
 * Seat 5: kukukic18 (€4.03 in chips) Seat 6: turbo005 (€2.93 in chips) asuusu:
 * posts small blind €0.01 spuzipakete: posts big blind €0.02 HOLE CARDS ***
 * Dealt to spuzipakete [Qc 9d] Suave1984: folds kukukic18: raises €0.04 to
 * €0.06 turbo005: folds monton1: folds asuusu: folds spuzipakete: folds
 * Uncalled bet (€0.04) returned to kukukic18 kukukic18 collected €0.05 from pot
 * kukukic18: doesn't show hand SUMMARY *** Total pot €0.05 | Rake €0 Seat 1:
 * monton1 (button) folded before Flop (didn't bet) Seat 2: asuusu (small blind)
 * folded before Flop Seat 3: spuzipakete (big blind) folded before Flop Seat 4:
 * Suave1984 folded before Flop (didn't bet) Seat 5: kukukic18 collected (€0.05)
 * Seat 6: turbo005 folded before Flop (didn't bet)
 */

public class Play {
	String PLAYER_NAME = "spuzipakete";
	String id = ""; // Every play has its own id
	double moneyBeforePlay = 0.0;
	double moneyAfterPlay = 0.0;
	String date = ""; // Date the play was played
	String time = ""; // Time the play was played
	String currency = "";
	String amount = "";
	double smallBlind = 0.0;
	double bigBlind = 0.0;
	String winner = "";
	boolean summary = false;

	// Saves the position where is sat every player
	HashMap<Position, Player> positionOfPlayers = new HashMap<>();

	/**
	 * Get the data from the string that pokerStars saves for each hand played
	 */
	public Play(String play) {

		StringTokenizer tokens = new StringTokenizer(play, "\n");
		while (tokens.hasMoreTokens()) {
			String str = tokens.nextToken();

			// Load info of this hand
			if (str.trim().substring(0, 1).equals("#")) { // First line
				loadHandInfo(str);
				summary = false;
			}
			// Seat of our player , we can check how much money we have before the play
			else if (str.substring(0, 4).equals("Seat") && !summary) {
				// Find where is sat each player and saves this information in a Hashmap
				savePositionOfEachPlayerInTable(str);
			}
			// Case of paying SB/BB
			else if (str.contains("posts")) {
				postBlind(str);
			}
			// Check cards dealed to our player
			else if (str.contains("Dealt to")) {
				getHandDealedToOurPlayer(str);
			} 
			// A player do an action: fold, raise, call, check
			else if (aPlayerHasDoneAnAction(str) && !summary) {
				playerDoAnAction(str);
			}
			else if (str.contains("collected") && !summary) {
				playerWinPot(str);
			}
			else if (str.contains("Rake")) {
				winnerPaysRake(str);
			}
			else if (str.contains("FLOP")) {
				System.out.println("FLOP");
			}
			else if (str.contains("TURN")) {
				System.out.println("TURN");
			}
			else if (str.contains("RIVER")) {
				System.out.println("RIVER");
			}
			// Winner shows the cards
			else if (str.contains("shows")) {
				System.out.println("winner shows hand");
			}

		}
	}



	/**
	 * Load id, date and time of the hand played Get the following data: -Id of the
	 * hand -Date(day,month,year) when the hand was played -Time (hour, minute,
	 * second) when the hand was played -Currency: type of coin played (€, $...)
	 * -Amount of big/small blind
	 */
	private void loadHandInfo(String str) {
		this.currency = getCurrency(str);
		this.smallBlind = getSmallBlind(str);
		this.bigBlind = getBigBlind(str);
		this.id = getIdOfHand(str); //
		this.date = getDate(str);
		this.time = getTime(str);
	}

	/**
	 * Get the type of currency played: €, $ ...
	 * 
	 * @return
	 */
	public String getCurrency(String str) {
		return str.substring(str.indexOf("(") + 1, str.indexOf(")")).substring(0, 1);
	}

	/**
	 * Get the amount of small blind in this hand
	 */
	public double getSmallBlind(String str) {
		return Double.parseDouble(
				str.substring(str.indexOf("(") + 1, str.indexOf(")")).replace(this.currency, "").split("/")[0]);
	}

	/**
	 * Get the amount of big blind in this hand
	 */
	public double getBigBlind(String str) {
		return Double.parseDouble(
				str.substring(str.indexOf("(") + 1, str.indexOf(")")).replace(this.currency, "").split("/")[1]);
	}

	/**
	 * Get the Id of the hand
	 */
	private String getIdOfHand(String str) {
		return str.trim().substring(1, str.indexOf(":") - 1);
	}

	/**
	 * Get the date of the hand
	 */
	private String getDate(String str) {
		return str.split("-")[1].split(" ")[1];
	}

	/**
	 * Get time of the hand
	 */
	private String getTime(String str) {
		return str.split("-")[1].split(" ")[2];
	}

	/**
	 * Find where is sat each player and saves this information in a Hashmap
	 * 
	 * @param str
	 */
	private void savePositionOfEachPlayerInTable(String str) {
		// position in table
		int positionInTable = Integer.parseInt(str.substring(0, str.indexOf(":")).split(" ")[1]);
		// Player info
		String playerName = str.substring(str.indexOf(":") + 1, str.indexOf("(")).trim();
		double playerMoney = Double
				.parseDouble(str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(" ")[0].substring(1));
		Player player = new Player(playerName, playerMoney);

		switch (positionInTable) {
		// Button
		case 1:
			this.positionOfPlayers.put(Position.BTN, player);
			break;
		// Small blind
		case 2:
			this.positionOfPlayers.put(Position.SB, player);
			break;
		// Big blind
		case 3:
			this.positionOfPlayers.put(Position.BB, player);
			break;
		// UTG
		case 4:
			this.positionOfPlayers.put(Position.UTG, player);
			break;
		// MP
		case 5:
			this.positionOfPlayers.put(Position.MP, player);
			break;
		// CO
		case 6:
			this.positionOfPlayers.put(Position.CO, player);
			break;
		}
	}

	/**
	 * Post the big and small blind
	 */
	public void postBlind(String str) {
		// Player in small blind pays small blind
		if (str.contains("small blind")) {
			this.positionOfPlayers.get(Position.SB).payMoney(this.smallBlind);
		}
		// Player in big blind pays
		else {
			this.positionOfPlayers.get(Position.BB).payMoney(this.bigBlind);
		}
	}

	/**
	 * Analyze what cards have we recieve
	 */
	private Hand getHandDealedToOurPlayer(String str) {
		Hand hand = null;
		hand = new Hand(str);
		String nameOfThePlayer = str.split(" ")[2];
		getPlayerByName(nameOfThePlayer).setHand(new Hand(str));
		return hand;
	}

	/**
	 * Check if a player has made an action (fold, check , call, raise)
	 */
	private boolean aPlayerHasDoneAnAction(String str) {
		if (str.contains("folds") || str.contains(Action.CHECK.toString())
				|| str.contains("raises") || str.contains("calls") || str.contains("bets"))
			return true;
		return false;
	}
	
	/**
	 * Search a player by name
	 */
	private Player getPlayerByName(String nameOfThePlayer) {
		for (Map.Entry<Position, Player> entry : this.positionOfPlayers.entrySet()) {
			if (entry.getValue().getName().equals(nameOfThePlayer)) {
				return entry.getValue();
			}
		}
		return null;
	}
	/**
	 * A player can do one of these actions: fold, check, call, raise
	 */
	private void playerDoAnAction(String str) {
		String playerName = str.split(":")[0];
		getPlayerByName(playerName).doAction(str);
	}
	
	/**
	 * A player has win the pot 
	 */
	private void playerWinPot(String str) {
		Double amount = Double.parseDouble( str.split(" ")[2].substring(1) );
		String playerName = str.split(" ")[0];
		getPlayerByName(playerName).winMoney(amount);
		winner = playerName;
	}
	
	/**
	 * The winner of the pot has to pay the rake
	 */
	private void winnerPaysRake(String str) {
		Double rake = Double.parseDouble(str.split(" ")[5].substring(1));
		getPlayerByName(this.winner).payRake(rake);
		summary = true;
	}
	
	/**
	 * 
	 */
	private void winnerShowsHand(String str) {
		Hand hand = new Hand(str);
		getPlayerByName(this.winner).setHand(hand);
	}
	
}
