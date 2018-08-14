
/**
 * This class represents a single play
 * Poker stars save one play in the next format:
 * 
	PokerStars Zoom Hand #189846733637:  Hold'em No Limit (€0.01/€0.02) - 2018/08/13 19:35:14 CET [2018/08/13 13:35:14 ET]
	Table 'Arneb' 6-max Seat #1 is the button
	Seat 1: monton1 (€2.13 in chips) 
	Seat 2: asuusu (€2.05 in chips) 
	Seat 3: spuzipakete (€2 in chips) 
	Seat 4: Suave1984 (€6.09 in chips) 
	Seat 5: kukukic18 (€4.03 in chips) 
	Seat 6: turbo005 (€2.93 in chips) 
	asuusu: posts small blind €0.01
	spuzipakete: posts big blind €0.02
	*** HOLE CARDS ***
	Dealt to spuzipakete [Qc 9d]
	Suave1984: folds 
	kukukic18: raises €0.04 to €0.06
	turbo005: folds 
	monton1: folds 
	asuusu: folds 
	spuzipakete: folds 
	Uncalled bet (€0.04) returned to kukukic18
	kukukic18 collected €0.05 from pot
	kukukic18: doesn't show hand 
	*** SUMMARY ***
	Total pot €0.05 | Rake €0 
	Seat 1: monton1 (button) folded before Flop (didn't bet)
	Seat 2: asuusu (small blind) folded before Flop
	Seat 3: spuzipakete (big blind) folded before Flop
	Seat 4: Suave1984 folded before Flop (didn't bet)
	Seat 5: kukukic18 collected (€0.05)
	Seat 6: turbo005 folded before Flop (didn't bet)
*/

public class Play {
	String PLAYER_NAME ="spuzipakete";
	long id = -1;
	double moneyBeforePlay = 0.0;
	double moneyAfterPlay = 0.0;
	
	
	/**
	 * Get the data from the string that pokerStars saves for each hand played
	 */
	public Play(String play) {
		
	}
	
	
}





