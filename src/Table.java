
/**
 * This class represents a table you have played.
 * You can check the tables in your directory:
 * 
 * C:\Users\{youruser}\AppData\Local\PokerStars.ES\HandHistory\{yourpokerstarsuser}
 *
 */

import java.util.*;

public class Table {
	private String fileName = "";
	private String name = "";
	private String amount = "";
	
	ArrayList<Play> plays = new ArrayList<Play>();
	
	
	public Table (String nameOfTheTable) {
		this.fileName = nameOfTheTable;
		String[] data =  nameOfTheTable.split("-");
		this.name = data[0].trim();
		this. amount = data[1].trim() + "-" + data[2].trim();
	}
	
	public static void main (String[] args) {
		String name = "HH20180813 Arneb #5 - €0.01-€0.02 - EUR No Limit Hold'em.txt";
		Table table = new Table (name);
		System.out.println(name);
		table.loadPlays();
	}
	
	public ArrayList<Play> loadPlays(){
		String content =  FileManager.readFile(Main.player.HANDS_DIRECTORY+"\\"+ this.fileName);
		System.out.println(content);
		return null;
	}
	
//	public double calculateWinnings() {
//		
//	}
	
}



