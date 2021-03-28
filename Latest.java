import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Latest {
	public static final int SIZE = 3;
	private static String[] latest = new String[SIZE];
	private static String[] tmp = new String[SIZE];
	private int count = 0;
public void readFile() {

	
		Scanner scanner;
		try {
			scanner = new Scanner(new File("latest.txt"));
			int i = 0;
			while (scanner.hasNextLine()) {
				
				   latest[i] = scanner.nextLine();
				   count++;
				   if(scanner.hasNextLine()) {
					   i++;
				   }
				   
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
}
public static String[] getLatest() {
	return latest;
	
}




public void writeFile(int x) {
	
	
	if(count != 3) {
		try {
			FileWriter X = new FileWriter("latest.txt");
	
			if(x != 0) {
			X.write(Score.getScore() + "\n");
			}
			for(int i = 0 ; i < latest.length && latest[i] != null  ; i++) {
				X.write(latest[i] + "\n");
			}
	
			X.close();
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	}
}
