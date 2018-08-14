import java.util.ArrayList;

public class Main {

	public static Player player = new Player();
	
	public static void main(String[] args) {


		FileManager fm = new FileManager();
		ArrayList<Table> tables =  fm.getTables();
		
		tables.forEach(table->{
			
		});
		
	}

}
