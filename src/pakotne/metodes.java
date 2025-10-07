package pakotne;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class metodes {

	public static String virknesParbaude(String zinojums, String noklusejums) {
		 String virkne;
		 do {
			 virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			 if(virkne == null)
				 return null;
		 }while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		 
		return virkne;
	}
	
	public static int skaitlaParbaude(String zinojums, int min, int max) {
		  String ievade;
		  int skaitlis;
		  
		  while(true) {
			  ievade = JOptionPane.showInputDialog(null, zinojums, 
					  "datu ievade", JOptionPane.INFORMATION_MESSAGE);
			  if (ievade == null)
				  return -1;
			  
			  try {
				  skaitlis = Integer.parseInt(ievade);
				  if(skaitlis < min || skaitlis > max) {
					  JOptionPane.showMessageDialog(null, "Norādīts nederīgs intervāls",
							  "nekorekti dati", JOptionPane.WARNING_MESSAGE);
					  continue;
				  }
				  return skaitlis;
			  }catch(NumberFormatException e) {
				  JOptionPane.showMessageDialog(null, 
						  "netika ievadīts vesels skaitlis",
						  "Nekorekti dati", JOptionPane.ERROR_MESSAGE);
			  }
			  
		  }
		}
	
	public static DecimalFormat df = new DecimalFormat("0.#");
	
	public static int studSk = 0, kritSk = 0;
	
	static String[] studenti;
	static String[] kriteriji;
	static int[] kriterijaSvars;
	static int[][] kriterijaVertejums;
	static double[] semestraVertejums;
	
	static void audzeknuIevade() {
		String StudentuSk;
		StudentuSk = virknesParbaude("Ievadi studentu skaitu!:", "2");
		studSk = Integer.parseInt(StudentuSk);
		studenti = new String[studSk];
		for(int i=0; i<studenti.length; i++) {
			studenti[i] = virknesParbaude("Ievadi skolena "+(i+1)+" vārdu", "Vektors");
	}
	
	}
	
	static void kriterijuIevade() {
		String KriterijSk;
		KriterijSk = virknesParbaude("Ievadi studentu skaitu!:", "2");
		kritSk = Integer.parseInt(KriterijSk);
		kriteriji = new String[kritSk];
		for(int i=0; i<studenti.length; i++) {
			studenti[i] = virknesParbaude("Ievadi skolena "+(i+1)+" vārdu", "Vektors");
	}
	
	}
	
	static void apreikinatGalaVert() {
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				
				JOptionPane.showMessageDialog(null ,"Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j], "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			JOptionPane.showMessageDialog(null ,"Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
}
