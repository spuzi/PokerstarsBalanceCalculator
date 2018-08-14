import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {

	/**
	 * List all the tables you have played
	 */
	public static ArrayList<Table> getTables() {
		ArrayList<Table> tablesRead =new ArrayList<>();
		File tablesFolder = new File(Main.player.HANDS_DIRECTORY);
		for (File eachTable : tablesFolder.listFiles()) {
			tablesRead.add(new Table(eachTable.getName()));
		}
		return tablesRead;
	}

	/**
	 * Read the content of a file
	 */
	public static String readFile(String filePath) {
		String fileContent = "";
		File file = new File(filePath);
		BufferedReader br;
		try {
			br = new BufferedReader( new InputStreamReader( new FileInputStream(filePath), "UTF8"));
			String st;
			while ((st = br.readLine()) != null) {
				fileContent += st;
			}
		} catch (FileNotFoundException e) {
			System.err.println("The following file doesnt exists: " + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading the following file: " + filePath);
			e.printStackTrace();
		}
		return fileContent;
	}

}