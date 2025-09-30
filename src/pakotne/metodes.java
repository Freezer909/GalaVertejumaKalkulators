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
	
	public static int studSk, kritSk;
	
	public static int[] kriterijaSvars = new int[kritSk];
	public static int[][] kriterijaVertejums = new int[studSk][kritSk];
	public static double[] semestraVertejums = new double[studSk];
	
	static String[] audzeknuIevade() {
		studSk = main.skaitlaParbaude("Ievadi audzēkņu skaitu", 1, 10);
		String[] studenti = new String[studSk];
		for(int i=0; i<studenti.length; i++) {
			studenti[i] = virknesParbaude("Ievadi skolena "+(i+1)+" vārdu", "Vektors");
	}
		return studenti;
	
	}
	
	static void kriterijuIevade() {
	kritSk = skaitlaParbaude("Ievadi cik daudz būs kritēriju!", 1, 10);
	String[] kriteriji = new String[kritSk];
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			virknesParbaude("Ievadi "+(i+1)+". kritēriju", "PD");
			// Norāda katra kritērija svaru
				kriterijaSvars[i] = skaitlaParbaude("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")", 1, 100);
				//Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 //kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			 while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
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
