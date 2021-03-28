import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class highScoreFonster extends JFrame {
	public static final int SIZE = 10;
	private JLabel label;
	private Lista minLista ;
	private Lista L_Lista ;
	private JList guiLista[];
	private JLabel highScoreList;
	private JLabel latestList;
	private JList hScoreList;
	private JList LList;
	private String name;
	private JPanel panel;
	private String highScore;
	private int[] Scores = new int[SIZE];
	private int tmp;
	
	private static String[] highScore_tmp = new String[SIZE];
	private String[] latest = Latest.getLatest();
	private String[] highScore_tmp_tmp = new String[SIZE];
	
	
	public highScoreFonster() {
		minLista = new Lista();
		L_Lista = new Lista();
		setLayout(new GridLayout(1,2));
		label = new JLabel("Enter your name : (max 3 letters)");
		panel = new JPanel();
		panel.setLayout(new GridLayout(SIZE, 1));
		hScoreList = new JList(minLista.getList());
		LList = new JList(L_Lista.getList());
		add(hScoreList);
		add(LList);
		String tmp = JOptionPane.showInputDialog("Enter your Name:");
		label.setText(tmp);
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.name = Character.toString(tmp.charAt(0)) + Character.toString(tmp.charAt(1)) + Character.toString(tmp.charAt(2));
	}
	
	
	public void readFile() {
		
			Scanner scanner;
			try {
				scanner = new Scanner(new File("highScore.txt"));
				int i = 0;
				while (scanner.hasNextLine()) {
					
					   highScore_tmp[i] = scanner.nextLine();
					   
					   if(scanner.hasNextLine()) {
						   i++;
					   }
					   
					}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}		
		
	}
	
	public void order() {
		
		/* Hämtat från StackOverflow  */
		for(int i = 0 ; i < highScore_tmp.length ;i++) {
			
			if( highScore_tmp[i] != null) {
			String ints[] = new String[SIZE];
			ints[i] = highScore_tmp[i].replaceAll("\\D+","");
			Scores[i] = Integer.parseInt(ints[i]);
			//System.out.println(Scores[i]);
			}
		
			/* End Stackoverflow*/
				
		}
		for(int j = 0 ; j < highScore_tmp.length && highScore_tmp[j] != null  ;j++) {
				for(int i = 0 ; i < highScore_tmp.length && highScore_tmp[i] != null ;i++) {
					
						if(Scores[i] < Scores[i + 1]) {
							tmp = Scores[i];
							Scores[i] = Scores[i + 1];
							Scores[ i + 1 ] = tmp;
							highScore_tmp_tmp[i] = highScore_tmp[i];
							highScore_tmp[i] = highScore_tmp[ i + 1 ];
							highScore_tmp[i + 1 ] = highScore_tmp_tmp[i];
						}
					
				}
		}
	
	}
	
	public void writeFile(int x) {
		
		
			try {
				FileWriter X = new FileWriter("highScore.txt");
				for(int i = 0 ; i < highScore_tmp.length && highScore_tmp[i] != null  ; i++) {
					X.write(highScore_tmp[i] + "\n");
				}
				if(x != 0) {
				X.write( this.name +" "+ Score.getScore() + "\n");
				}
				X.close();
				
			} catch (IOException e) {
	
				e.printStackTrace();
			}
		}	
	
	
	


public void khara() {
	for(int i = 0; i < highScore_tmp.length && highScore_tmp[i] != null; i++) {
		System.out.println(highScore_tmp[i]);
		minLista.add(new String(highScore_tmp[i]));
		
	}
	
	for(int i = 0; i < this.latest.length && this.latest[i] != null; i++) {
		L_Lista.add(new String(latest[i]));
	}
}
	 
}
